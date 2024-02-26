package entities;

public class SinhVienIT extends SinhVienTechMaster{
    private double javaPoint;
    private double htmlPoint;
    private double cssPoint;

    public SinhVienIT(String name, String major, double javaPoint, double htmlPoint, double cssPoint) {
        super(name, major);
        this.javaPoint = javaPoint;
        this.htmlPoint = htmlPoint;
        this.cssPoint = cssPoint;
    }

    @Override
    public double getDiem() {
        return (2 * javaPoint + htmlPoint + cssPoint)/4;
    }
}
