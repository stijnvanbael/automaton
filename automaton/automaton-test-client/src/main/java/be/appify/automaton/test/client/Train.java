package be.appify.automaton.test.client;

import be.appify.automaton.api.AbstractRobot;
import be.appify.automaton.api.Event;

public class Train extends AbstractRobot {
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
        //TODO
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
}
