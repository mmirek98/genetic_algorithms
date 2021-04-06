package sample.view;

import javafx.application.Application;
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
import sample.genetic.core.ReadingAttributes;
import sample.genetic.core.SetParams;
import java.net.URL;
import java.util.Map;

public class MainWindow extends Application {
    private Stage primaryStage;
    private WebView webView;
    private WebEngine webEngine;
    private VBox root;
    private Scene menuScene;
    private WebViewConnector webViewConnector;

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
        URL url = this.getClass().getResource("/resources/index.html");
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
            System.out.println("Run button clicked...");
            Map<String, String> params = webViewConnector.getParameters();
            sample.view.Parameters parsedParams = ParametersMapper.toParameters(params);
            double winner = this.runAlgorithm(parsedParams);
            Element learningStatus = this.webEngine.getDocument().getElementById("learningStatus");
            this.webViewConnector.setLearningStatus("The winner is: " + winner);
        };
    }

    private double runAlgorithm(sample.view.Parameters params) {
        ReadingAttributes read = new ReadingAttributes.AttributesBuilder()
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
                .inversionChance(params.getInversionChance())
                .eliteElements(params.getEliteStrategyAmount())
                .selectionParameter(params.getSelectionParameter())
                .build();
        SetParams param = new SetParams();
        double winnerValue = param.setParams(read);
        return winnerValue;
    }
}
