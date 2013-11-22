package be.appify.automaton.test.client;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Topology {
    private List<Segment> segments;

    public Topology(Segment... segments) {
        this.segments = Lists.newArrayList(segments);
    }

    public Collection<Segment> segments() {
        return Collections.unmodifiableCollection(segments);
    }

    public Topology straight(int length) {
        add(new StraightTrack(length));
        return this;
    }

    public Topology curve(int length) {
        add(new CurvedTrack(length));
        return this;
    }

    public Topology closeLoop() {
        if(!segments.isEmpty()) {
            Segment first = segments.get(0);
            Segment last = segments.get(segments.size() - 1);
            last.attach(first, Direction.CLOCKWISE);
            first.attach(last, Direction.COUNTERCLOCKWISE);
        }
        return this;
    }

    private void add(Segment segment) {
        if(!segments.isEmpty()) {
            Segment last = segments.get(segments.size() - 1);
            last.attach(segment, Direction.CLOCKWISE);
            segment.attach(last, Direction.COUNTERCLOCKWISE);
        }
        segments.add(segment);
    }
}
