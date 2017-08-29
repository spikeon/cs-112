public interface Car {
    void turn(Direction direction);
    void setBlinker(Direction which, boolean onoff);
    int accelerate(int how_much);
    int getSpeed();
}
