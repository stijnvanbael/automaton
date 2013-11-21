package be.appify.automaton.test.client;

public class SwitchTrack extends AbstractTrack {
    private final Direction forkDirection;
    private Direction switchPosition;
    private Segment nextSingleSegment;

    public SwitchTrack(Direction forkDirection) {
        super(100, 75);
        this.forkDirection = forkDirection;
        this.switchPosition = Direction.CLOCKWISE;
    }

    @Override
    public Segment nextSegment(Direction direction) {
        if(direction == forkDirection) {
            return super.nextSegment(switchPosition);
        } else {
            return nextSingleSegment;
        }
    }

    public SwitchTrack attachSingle(Segment next) {
        this.nextSingleSegment = next;
        return this;
    }

    public SwitchTrack position(Direction direction) {
        this.switchPosition = direction;
        return this;
    }
}
