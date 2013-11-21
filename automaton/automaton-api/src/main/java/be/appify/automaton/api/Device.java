package be.appify.automaton.api;

import java.util.Collection;

public interface Device {
    String name();

    Collection<Action> actions();

    Action action(String action);
}
