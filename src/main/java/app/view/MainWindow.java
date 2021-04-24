package app.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import app.genetic.core.AlgorithmAttributes;
import app.genetic.core.AlgorithmRunner;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.*;

public class MainWindow extends Application {
    private Stage primaryStage;
    private WebView webView;
    private WebEngine webEngine;
    private VBox root;
    private Scene menuScene;
    private WebViewConnector webViewConnector;
    private long executionTime;
    private String template = PlotData.getPlotHtmlTemplate();
    private final String replaceMarkInTemplate = "//INSERT_JSON_HERE";
    private final String resultFilePath = "result-plots.html";

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.initializeScene(primaryStage);
        this.setupUIConnection();

        this.primaryStage.show();
    }

    public void display(String[] args) {
        launch(args);
    }

    private void initializeScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.webView = new WebView();
        this.webEngine = this.webView.getEngine();
        URL url = this.getClass().getResource("/index.html");
        this.webEngine.load(url.toString());
        this.root = new VBox();
        this.root.getChildren().addAll(this.webView);
        this.primaryStage.setWidth(1366);
        this.webView.setPrefWidth(1366);
        this.webView.setPrefHeight(768);
        this.primaryStage.setHeight(768);
        this.menuScene = new Scene(this.root, 1366, 768);
        this.primaryStage.setScene(this.menuScene);
    }

    private void setupUIConnection() {
        this.webEngine.getLoadWorker().stateProperty().addListener(((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED == newValue) {
                JSObject window = (JSObject) this.webEngine.executeScript("window");
                JSObject jsConnector = (JSObject) this.webEngine.executeScript("getJsConnector()");
                this.webViewConnector = new WebViewConnector(jsConnector);
                window.setMember("javaConnector", this.webViewConnector);

                this.attachEventListenerToStartButton();
            }
        }));
    }

    private void attachEventListenerToStartButton() {
        EventListener runButtonListener = getRunButtonListener();
        Element runButton = this.webEngine.getDocument().getElementById("run");
        ((EventTarget) runButton).addEventListener("click", runButtonListener, false);
    }

    private EventListener getRunButtonListener() {
        return evt -> {
            this.webViewConnector.setSpinnerOverlay();
            Map<String, String> params = webViewConnector.getParameters();
            app.view.Parameters parsedParams = ParametersMapper.toParameters(params);

            CompletableFuture
                    .supplyAsync(() -> this.runAlgorithm(parsedParams))
                    .thenAccept(this::displayLearningResult);

        };
    }

    private void displayLearningResult(Double winner) {
        Platform.runLater(() -> {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    this.displayResult(winner);
                    createResultFile();
                } catch (IOException | URISyntaxException e) {
                    this.webViewConnector.unsetSpinnerOverlay();
                    e.printStackTrace();
                }
            }
        });
    }

    private void createResultFile() throws IOException, URISyntaxException {
        this.deleteResultFileIfExists();
        String updatedTemplate = template.replace(replaceMarkInTemplate, "const json = `" + PlotData.getPlotData() + "`;");
        File resultHtmlFile = new File(resultFilePath);
        resultHtmlFile.createNewFile();
        FileWriter writer = new FileWriter(resultFilePath);
        writer.write(updatedTemplate);
        writer.close();

        Path path = Paths.get(resultFilePath);
        File file = new File(path.toAbsolutePath().toString());
        Desktop.getDesktop().browse(new URI(file.toURI().toString()));
    }

    private void deleteResultFileIfExists() throws IOException {
        Files.deleteIfExists(new File(resultFilePath).toPath());
    }

    private void displayResult(double winner) {
        this.webViewConnector.unsetSpinnerOverlay();
        this.webViewConnector.setLearningStatus("The winner is: " + winner);
        this.webViewConnector.setExecutionTime("Execution time: " + this.executionTime + " ms");
    }

    private double runAlgorithm(app.view.Parameters params) {
        AlgorithmAttributes read = getAttributes(params);
        AlgorithmRunner algorithmRunner = new AlgorithmRunner();
        double winnerValue = algorithmRunner.learn(read);
        executionTime = algorithmRunner.getExecutionTime();
        PlotData.createEpochsAxis(params.getEpochsNumber());

        return winnerValue;
    }

    private AlgorithmAttributes getAttributes(app.view.Parameters params) {
        return new AlgorithmAttributes.AttributesBuilder()
                .populationSize(params.getPopulationSize())
                .populationLeftBoundary(params.getLeftRange())
                .populationRightBoundary(params.getRightRange())
                .numberOfEpochs(params.getEpochsNumber())
                .chromosomeAccuracy(params.getChromosomeAccuracy())
                .selectionStrategy(params.getSelectionStrategy())
                .crossingStrategy(params.getCrossingStrategy())
                .mutationStrategy(params.getMutationStrategy())
                .gradeStrategy(params.getGradeStrategy())
                .crossingChance(params.getCrossingChance())
                .mutationChance(params.getMutationChance())
                .eliteElements(params.getEliteStrategyAmount())
                .selectionParameter(params.getSelectionParameter())
                .build();
    }
}
