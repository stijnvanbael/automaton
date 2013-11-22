package be.appify.automaton.api;

import java.io.Serializable;

public class Event implements Serializable {
    private String[] parameters;

    public Event(String name, String... parameters) {
        this.parameters = parameters;
        this.name = name;
    }

    private String name;

    public String name() {
        return name;
    }
    public String[] parameters() {
        return parameters;
    }
}
