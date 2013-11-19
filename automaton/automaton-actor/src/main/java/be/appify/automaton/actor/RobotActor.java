package main.java.be.appify.automaton.actor;

import akka.actor.UntypedActor;
import be.appify.automaton.api.Robot;

public class RobotActor extends UntypedActor {

    private Robot robot;

    public RobotActor(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof RobotEvent) {
            ((RobotEvent) message).apply(robot);
        } else {
            unhandled(message);
        }
    }
}
