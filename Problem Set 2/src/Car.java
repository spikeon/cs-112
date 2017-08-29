/*
Complete Programming Challenge 2 at the end of the chapter "A First Look at Classes".
You need only submit the Car class.  Use these names:
Getters - getYearModel, getMake, getSpeed
 */
public class Car {
    private int yearModel;
    private String make;
    private int speed;

    public Car(int yearModel, String make) {
        this.yearModel = yearModel;
        this.make = make;
        this.speed = 0;
    }

    public void accelerate(){
        speed += 5;
    }

    public void brake(){
        speed -= 5;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
