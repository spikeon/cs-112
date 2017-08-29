/*
Complete Programming Challenge 7 at the end of the chapter "A First Look at Classes".
You need only submit the Circle class.
 */
public class Circle {
    private double radius;
    private final double PI = 3.14159;

    public Circle(){
        this.radius = 0.0;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPI() {
        return PI;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getCircumference() {
        return 2 * PI * radius;
    }
}
