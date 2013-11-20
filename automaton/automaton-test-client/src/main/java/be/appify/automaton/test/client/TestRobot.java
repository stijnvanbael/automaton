package be.appify.automaton.test.client;

import be.appify.automaton.api.Device;
import be.appify.automaton.api.Robot;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

public class TestRobot implements Robot {
    private Map<String, Device> devices;

    public TestRobot(Device... devices) {
        this.devices = Maps.uniqueIndex(Lists.newArrayList(devices), Device::name);
    }

    @Override
    public Collection<Device> devices() {
        return Collections.unmodifiableCollection(devices.values());
    }

    @Override
    public Device device(String name) {
        return devices.get(name);
    }
}
