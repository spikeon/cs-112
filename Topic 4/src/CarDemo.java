public class CarDemo {
    public static Car findFasterCar(Car first, Car second) {
        if(first.getSpeed() > second.getSpeed()) return first;
        else return second;
    }
    public static void main(String[] args) {
        Car civic = new Civic();
        Car corolla = new Corolla();

        civic.accelerate(50);
        corolla.accelerate(40);
        corolla.setBlinker(Direction.RIGHT, true);

        Car faster_car = findFasterCar(civic, corolla);
        faster_car.accelerate(-5);
    }
}
