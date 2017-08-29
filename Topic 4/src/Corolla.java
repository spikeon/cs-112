public class Corolla implements Car{

    private int speed = 0;
    private boolean left_blinker_on = false;
    private boolean right_blinker_on = false;
    public void turn(Direction direction){
        setBlinker(direction, true);
        accelerate(-15);
    }

    public void setBlinker(Direction which, boolean onoff) {
        if(which == Direction.LEFT) left_blinker_on = onoff;
        else if(which == Direction.RIGHT) right_blinker_on = onoff;
    }

    public int accelerate(int how_much) {
        speed += how_much;
        if(speed > 100) speed = 110;
        return getSpeed();
    }

    public int getSpeed() {
        return 0;
    }
}
