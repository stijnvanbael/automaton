package be.appify.automaton.api;

import java.util.List;

public interface Robot {
    List<Device> devices();

    Device device(String name);
}
