package sample;

import netscape.javascript.JSObject;

import java.util.HashMap;
import java.util.Map;

public class Connector {
    private HashMap<String, String> parameters = new HashMap<String, String>();
    private JSObject jsConnector;

    public Connector(JSObject jsConnector) {
        this.jsConnector = jsConnector;
    }

    public void run() {
        System.out.println("called run..");
        this.jsConnector.call("sendResult", "Loading...");
        // TODO: start learning...
    }

    public void sendParameter(String id, String value) {
        System.out.println("adding: id=" + id + "; value=" + value);
        this.parameters.put(id, value);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }
}
