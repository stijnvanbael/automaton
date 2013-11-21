package be.appify.automaton.test.client;

import be.appify.automaton.api.AbstractRobot;
import be.appify.automaton.api.Event;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Train extends AbstractRobot {

    private int speed;
    private Topology topology;

    public Train() {
        super(new Engine("engine"),
                new Detector("front-detector"),
                new Detector("rear-detector")
        );
        onEvent("topology", this::topology);
        onEvent("destination", this::destination);
        onEvent("switch-changed", this::switchChanged);
    }

    private Void topology(Event event) {
        this.topology = executeScript(event.parameters()[0], Topology.class);
        return null;
    }

    private Void destination(Event event) {
        //TODO
        return null;
    }

    private Void switchChanged(Event event) {
        //TODO
        return null;
    }

    private <T> T executeScript(String script, Class<T> resultType) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javaScript = scriptEngineManager.getEngineByName("JavaScript");
        try {
            return resultType.cast(javaScript.eval(script));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
