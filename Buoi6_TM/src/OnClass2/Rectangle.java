package OnClass2;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void output() {
        System.out.println("Chu vi chữ nhật: " + getPerimeter());
        System.out.println("Diện tích chữ nhật: " + getArea());
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
