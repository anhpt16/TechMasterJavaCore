package entities;

public abstract class SinhVienTechMaster {
    private String name;
    private String major;

    public SinhVienTechMaster(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public abstract double getDiem();
    public String getHocLuc(double diem){
        if(diem < 5){
            return "Yếu";
        }
        else if(diem >= 5 && diem < 6.5){
            return "Trung bình";
        }
        else if(diem >= 6.5 && diem < 7.5){
            return "Khá";
        }
        else if(diem >= 7.5 && diem <= 10){
            return "Giỏi";
        }
        else
            return "Điểm không hợp lệ !";
    }
    public void xuat(){
        System.out.println("Họ tên: " + name);
        System.out.println("Ngành: " + major);
        System.out.println("Điểm: " + getDiem());
        System.out.println("Học lực: " + getHocLuc(getDiem()));
    }
}
