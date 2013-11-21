package be.appify.automaton.test.client;

import be.appify.automaton.api.AbstractDevice;
import be.appify.automaton.api.Action;
import com.google.common.collect.ImmutableMap;

public class Engine extends AbstractDevice {
    public Engine(String name) {
        super(name, ImmutableMap.<String, Action>builder()
                .put("forward", Engine::forward)
                .put("reverse", Engine::reverse)
                .put("stop", Engine::stop)
                .build());
    }

    private static void forward(String... parameters) {
        System.out.println("Move forward at " + parameters[0] + "%");
    }
    private static void reverse(String... parameters) {
        System.out.println("Move backward at " + parameters[0] + "%");
    }
    private static void stop(String... parameters) {
        System.out.println("Stop");
    }
}
