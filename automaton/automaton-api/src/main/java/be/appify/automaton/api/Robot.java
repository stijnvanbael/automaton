package be.appify.automaton.api;

import com.google.common.base.Function;

import java.util.Collection;

public interface Robot {
    Collection<Device> devices();

    Device device(String name);

    void eventReceived(Event event);

    void onEvent(String name, Function<Event, Void> handler);
}
