package be.appify.automaton.test.client;

import be.appify.automaton.api.Action;
import com.google.common.collect.ImmutableMap;

import java.util.Collections;

public class Train extends TestRobot {
    public Train() {
        super(new TestDevice("engine", ImmutableMap.<String, Action>builder()
                .put("forward", Train::forward)
                .put("reverse", (p) -> System.out.println("Move backward at " + p[0] + "%"))
                .put("stop", (p) -> System.out.println("Stop"))
                .build()),
              new TestDevice("detector", Collections.emptyMap())
        );
    }

    private static void forward(String... parameters) {
        System.out.println("Move forward at " + parameters[0] + "%");
    }
}
