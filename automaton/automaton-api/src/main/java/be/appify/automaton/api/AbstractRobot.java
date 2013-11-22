package be.appify.automaton.api;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

public abstract class AbstractRobot implements Robot {
    private Map<String, Device> devices;
    private Map<String, Function<Event, Void>> eventHandlers;
    private Map<String, Object> variables;

    public AbstractRobot(Device... devices) {
        this.devices = Maps.uniqueIndex(Lists.newArrayList(devices), Device::name);
        this.eventHandlers = Maps.newHashMap();
        this.variables = Maps.newHashMap();
    }

    @Override
    public Collection<Device> devices() {
        return Collections.unmodifiableCollection(devices.values());
    }

    @Override
    public Device device(String name) {
        return devices.get(name);
    }

    @Override
    public Robot eventReceived(Event event) {
        Function<Event, Void> handler = eventHandlers.get(event.name());
        if(handler != null) {
            handler.apply(event);
        }
        return this;
    }

    @Override
    public Robot onEvent(String name, Function<Event, Void> handler) {
        eventHandlers.put(name, handler);
        return this;
    }

    @Override
    public Robot variable(String name, Object value) {
        variables.put(name, value);
        return this;
    }

    @Override
    public Object variable(String name) {
        return variables.get(name);
    }
}
