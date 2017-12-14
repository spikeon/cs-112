public class Car extends AbstractCar {

  public Car(boolean state) {
    on = state;
  }

  public void toggleIgnition() {
    on = !on;
  }

  public int goFaster() {
    if(!on) return -1;
    speed += 5;
    return speed;
  }

  @Override
  public String toString() {
    return "Car is " + (on ? "on" : "off") + ". Speed is " + speed + " MPH";

  }
}
