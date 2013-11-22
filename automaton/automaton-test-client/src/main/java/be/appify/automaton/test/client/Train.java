package be.appify.automaton.test.client;

import be.appify.automaton.api.AbstractRobot;
import be.appify.automaton.api.Event;

import javax.script.*;

public class Train extends AbstractRobot {
    public Train() {
        super(new Engine("engine"),
                new Detector("front-detector"),
                new Detector("rear-detector")
        );
        onEvent("event-handler", this::eventHandler);
    }

    private Void eventHandler(Event event) {
        executeScript(event.parameters()[0]);
        return null;
    }

    private void executeScript(String script) {
        this.executeScript(script, Object.class);
    }

    private <T> T executeScript(String script, Class<T> resultType) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javaScript = scriptEngineManager.getEngineByName("JavaScript");
        try {
            Bindings bindings = new SimpleBindings();
            bindings.put("robot", this);
            return resultType.cast(javaScript.eval(script, bindings));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
