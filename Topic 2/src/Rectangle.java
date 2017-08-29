public class Rectangle {

    private double l, w;

    public Rectangle() {
        setLength(0);
        setWidth(0);
    }

    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public void setLength(double length) {
        l = length;
    }
    public double getLength() {
        return l;
    }

    public void setWidth(double width) {
        w = width;
    }
    public double getWidth() {
        return w;
    }

    public double getArea() {
        return l * w;
    }
}
