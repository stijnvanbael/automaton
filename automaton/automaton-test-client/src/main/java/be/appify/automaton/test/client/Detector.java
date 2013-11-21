package be.appify.automaton.test.client;

import be.appify.automaton.api.AbstractDevice;

import java.util.Collections;

public class Detector extends AbstractDevice {
    public Detector(String name) {
        super(name, Collections.emptyMap());
    }
}
