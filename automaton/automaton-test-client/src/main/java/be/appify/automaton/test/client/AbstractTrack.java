package be.appify.automaton.test.client;

import com.google.common.collect.Maps;

import java.util.Map;

public class AbstractTrack implements Segment {
    private final int length;
    private final int maxSpeed;
    private final Map<Direction, Segment> nextSegments;

    public AbstractTrack(int length, int maxSpeed) {
        this.length = length;
        this.maxSpeed = maxSpeed;
        this.nextSegments = Maps.newHashMap();
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int maxSpeed() {
        return maxSpeed;
    }

    @Override
    public Segment nextSegment(Direction direction) {
        return nextSegments.get(direction);
    }

    @Override
    public Segment attach(Segment next, Direction direction) {
        this.nextSegments.put(direction, next);
        return this;
    }
}
