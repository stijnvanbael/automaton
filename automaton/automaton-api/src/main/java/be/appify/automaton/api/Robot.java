package be.appify.automaton.api;

import java.util.Collection;

public interface Robot {
    Collection<Device> devices();

    Device device(String name);
}
