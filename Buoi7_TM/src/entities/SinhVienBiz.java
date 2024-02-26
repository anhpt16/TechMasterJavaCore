package entities;

public class SinhVienBiz extends SinhVienTechMaster{
    private double marketingPoint;
    private double salePoint;

    public SinhVienBiz(String name, String major, double marketingPoint, double salePoint) {
        super(name, major);
        this.marketingPoint = marketingPoint;
        this.salePoint = salePoint;
    }

    @Override
    public double getDiem() {
        return (2 * marketingPoint + salePoint)/3;
    }
}
