package be.appify.automaton.test.client;

public interface Segment {
    int length();
    int maxSpeed();
    Segment nextSegment(Direction direction);
    Segment attach(Segment next, Direction direction);
}
