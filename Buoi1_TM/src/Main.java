
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Chu vi chu nhat: " + main.chuVi(10, 20));
        System.out.println("Dien tich chu nhat: " + main.dienTich(10, 20));
        System.out.println("Ban kinh duong tron: " + main.banKinh(113));
        System.out.println("Duong kinh duong tron: " + (2 * main.banKinh(113)));
        System.out.println("Chu vi hinh tron: " + main.chuViTron(main.banKinh(113)));
        System.out.println("Quang duong AB: " + main.quangDuong(38, 54, 2.25));
    }
    public double chuVi(double a, double b){
        return (a + b);
    }
    public double dienTich(double a, double b){
        return (a + b) * 2;
    }
    public double banKinh(double dienTich){
        return (Math.sqrt(dienTich / Math.PI));
    }
    public double chuViTron(double banKinh){
        return (2 * banKinh * Math.PI);
    }
    public double quangDuong(double v1, double v2, double t){
        return ((v1*t) + (v2*t));
    }
    public double thoiGian(double v1, double t1, double heSo){
        return ((v1 * t1)/(heSo * v1));
    }
}
