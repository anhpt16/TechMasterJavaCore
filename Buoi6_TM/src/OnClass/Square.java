package OnClass;

public class Square extends Rectangle{

    public Square(double side) {
        super(side, side);
    }

    @Override
    public void output() {
        System.out.println("Cạnh: " + getWidth());
        System.out.println("Chu vi: " + getPerimeter());
        System.out.println("Diện tích: " + getArea());
    }
}
