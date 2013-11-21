package be.appify.automaton.test.client;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;

public class Topology {
    private Collection<Segment> segments;

    public Topology(Segment... segments) {
        this.segments = Lists.newArrayList(segments);
    }

    public Collection<Segment> segments() {
        return Collections.unmodifiableCollection(segments);
    }
}
