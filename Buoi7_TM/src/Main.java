import entities.SinhVienBiz;
import entities.SinhVienIT;

public class Main {
    public static void main(String[] args) {
        SinhVienIT iter = new SinhVienIT("Hùng", "CNTT", 9, 8, 7);
        SinhVienBiz bizer = new SinhVienBiz("Bảo", "Marketing", 8, 8.5);

        iter.xuat();
        bizer.xuat();
    }
}
