package be.appify.automaton.api;

import java.util.List;

public interface Device {
    String name();

    List<Action> actions();

    Action action(String action);
}
