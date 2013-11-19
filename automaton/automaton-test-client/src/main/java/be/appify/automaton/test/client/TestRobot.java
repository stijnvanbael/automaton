package be.appify.automaton.test.client;

import be.appify.automaton.api.Device;
import be.appify.automaton.api.Robot;

import java.util.ArrayList;
import java.util.List;

public class TestRobot implements Robot {
    private List<Device> devices = new ArrayList<>();

    @Override
    public List<Device> devices() {
        return devices;
    }

    @Override
    public Device device(String name) {
        return null;
    }
}
