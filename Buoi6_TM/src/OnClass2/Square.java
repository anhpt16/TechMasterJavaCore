package OnClass2;

public class Square extends Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void output() {
        System.out.println("Chu vi vuông: " + getPerimeter());
        System.out.println("Diện tích vuông: " + getArea());
    }

    @Override
    public double getPerimeter() {
        return (side * 4);
    }

    @Override
    public double getArea() {
        return (side * side);
    }
}
