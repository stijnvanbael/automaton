package be.appify.automaton.test.client;

import be.appify.automaton.api.Action;
import be.appify.automaton.api.Device;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class TestDevice implements Device {
    private Map<String, Action> actions;
    private String name;

    public TestDevice(String name, Map<String, Action> actions) {
        this.actions = Maps.newHashMap(actions);
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Collection<Action> actions() {
        return Collections.unmodifiableCollection(actions.values());
    }

    @Override
    public Action action(String action) {
        return actions.get(action);
    }
}
