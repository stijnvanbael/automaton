package be.appify.automaton.api;

import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class AbstractDevice implements Device {
    private Map<String, Action> actions;
    private String name;

    public AbstractDevice(String name, Map<String, Action> actions) {
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
