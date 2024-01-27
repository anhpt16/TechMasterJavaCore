package Slide11;

public class Rectangle extends Geometry{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected double calculateArea() {
        return width * height;
    }

    @Override
    protected double caculatePerimeter() {
        return (2 * (width + height));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
