package app.view;

import netscape.javascript.JSObject;

import java.util.HashMap;
import java.util.Map;

public class WebViewConnector {
    private HashMap<String, String> parameters = new HashMap<>();
    private JSObject jsConnector;

    public WebViewConnector(JSObject jsConnector) {
        this.jsConnector = jsConnector;
    }

    public void sendParameter(String id, String value) {
        this.parameters.put(id, value);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public void setLearningStatus(String status) {
        this.jsConnector.call("sendResult", status);
    }

    public void setExecutionTime(String executionTime) {
        this.jsConnector.call("sendExecutionTime", executionTime);
    }

    public void setSpinnerOverlay() {
        this.jsConnector.call("setSpinnerOverlay");
    }

    public void unsetSpinnerOverlay() {
        this.jsConnector.call("unsetSpinnerOverlay");
    }
}
