package be.appify.automaton.api;

import com.google.common.base.Function;

import java.util.Collection;

public interface Robot {
    Collection<Device> devices();

    Device device(String name);

    Robot eventReceived(Event event);

    Robot onEvent(String name, Function<Event, Void> handler);

    Robot variable(String name, Object value);

    Object variable(String name);
}
