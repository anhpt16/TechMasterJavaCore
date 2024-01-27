package Slide11;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2.3, 6.5);
        Square square = new Square(5.5);

        System.out.println("Chu vi hình chữ nhật là: " + rectangle.caculatePerimeter() + " ,Diện tích hình chữ nhật là: " + rectangle.calculateArea());
        System.out.println("Chu vi hình vuông là: " + square.caculatePerimeter() + " ,Diện tích hình vuông là: " + square.calculateArea());
    }
}
