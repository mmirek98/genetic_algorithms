package sample;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventTarget;

import java.net.URL;
import java.util.Map;

import org.w3c.dom.events.EventListener;

public class Main extends Application {
    private Stage primaryStage;
    private WebView webView;
    private WebEngine webEngine;
    private VBox root;
    private Scene menuScene;
    private Connector connector;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.initializeScene(primaryStage);
        this.setupUIConnection();

        this.primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void initializeScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.webView = new WebView();
        this.webEngine = this.webView.getEngine();
        URL url = this.getClass().getResource("../resources/index.html");
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
                this.connector = new Connector(jsConnector);
                window.setMember("javaConnector", this.connector);

                this.attachEventListenerToStartButton();
            }
        }));
    }

    private void attachEventListenerToStartButton() {
        EventListener runButtonListener = new EventListener() {
            @Override
            public void handleEvent(org.w3c.dom.events.Event evt) {
                System.out.println("Run button clicked...");
                Map<String, String> params = connector.getParameters();
                for (Map.Entry<String, String> entry: params.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                System.out.println("running learning...");
            }
        };

        Document document = this.webEngine.getDocument();
        Element runButton = document.getElementById("run");
        ((EventTarget) runButton).addEventListener("click", runButtonListener, false);
    }
}

