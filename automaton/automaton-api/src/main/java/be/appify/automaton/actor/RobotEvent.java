package be.appify.automaton.actor;

import be.appify.automaton.api.Action;
import be.appify.automaton.api.Device;
import be.appify.automaton.api.Robot;

public abstract class RobotEvent {
    protected String device;
    protected String action;
    protected String[] parameters;

    protected abstract void initialize();

    public void apply(Robot robot) {
        Device device = robot.device(this.device);
        Action action = device.action(this.action);
        action.execute(parameters);
    }
}
