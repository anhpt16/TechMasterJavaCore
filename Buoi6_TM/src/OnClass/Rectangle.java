package OnClass;

public class Rectangle {
    private double width;
    private double height;

    protected double getWidth() {
        return width;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    protected double getArea(){
        return width * height;
    }

    protected double getPerimeter(){
        return (2 * (width + height));
    }

    public void output(){
        System.out.println("Dài: " + width);
        System.out.println("Rộng: " + height);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}
