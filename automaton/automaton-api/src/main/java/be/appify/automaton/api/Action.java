package be.appify.automaton.api;

public interface Action {

    String name();

    void execute(String... parameters);
}
