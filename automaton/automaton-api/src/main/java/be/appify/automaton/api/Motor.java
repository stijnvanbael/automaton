package be.appify.automaton.api;

public interface Motor extends Device {
    void forward(float speed);

    void reverse(float speed);

    void stop();
}
