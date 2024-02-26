package QLNV;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exit = "";
        do {
            System.out.println("------Menu------");
            System.out.println("0. Exit");
            System.out.println("1. Nhập nhân viên");
            System.out.println("2. Tìm kiếm nhân viên theo id");
            System.out.println("3. Tìm kiếm nhân viên theo giới tính");
            System.out.println("4. TÌm kiếm các nhân viên theo địa chỉ");
            System.out.println("5. Hiển thị tất các các nhân viên");
            System.out.println("-----------------");
            System.out.println("CHỌN (0-4): ");
            int choose = Integer.parseInt(sc.nextLine());

            int n = 0;
            Employee[] arrEmp = new Employee[0];

            switch (choose){
                case 0:
                    System.out.println("Xác nhận thoát ? (y/n)");
                    exit = sc.nextLine();
                    break;
                case 1:
                    System.out.println("Nhập vào số lượng nhân viên muốn nhập: ");
                    n = Integer.parseInt(sc.nextLine());

                    arrEmp = new Employee[n];
                    int idNumber;
                    String id;
                    String name;
                    LocalDate birth;
                    Sex sex = null;
                    String phoneNumber = null;
                    String email;
                    String address;

                    for (int i = 0; i < n; i++) {
                        //id
                        do {
                            System.out.println("Nhập id nhân viên " + (i+1) + ": ");
                            idNumber = Integer.parseInt(sc.nextLine());
                            if (idNumber <= 0)
                                System.out.println("Id không hợp lệ !");
                        } while (idNumber <= 0);
                        id = "NV" + idNumber;
                        //name
                        System.out.println("Nhập tên nhân viên " + (i+1) + ": ");
                        name = sc.nextLine();
                        //birth
                        System.out.println("Nhập ngày sinh nhân viên " + (i+1) + " (yyyy-MM-dd): ");
                        String day = sc.nextLine();
                        birth = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        //Sex
                        boolean checkSex = false;
                        do {
                            System.out.println("Nhập giới tính nhân viên " + (i+1) + " (1-Nam, 2-Nữ): ");
                            int sexInp = Integer.parseInt(sc.nextLine());
                            if(sexInp == 1){
                                sex = Sex.Nam;
                                checkSex = true;
                            }
                            else if (sexInp == 2){
                                sex = Sex.Nữ;
                                checkSex = true;
                            }
                            else
                                System.out.println("Giới tính không hợp lệ !");
                        } while (checkSex == false);
                        //phoneNumber
                        boolean checkPhone = false;
                        do {
                            System.out.println("Nhập số điện thoại nhân viên " + (i+1) + ": ");
                            String phoneInp = sc.nextLine();
                            String trimPhone = phoneInp.trim();
                            String standardPhone = trimPhone.replaceAll("\\s+", "");
                            if (standardPhone.length() == 10){
                                phoneNumber = standardPhone;
                                checkPhone = true;
                            }
                            else
                                System.out.println("Số điện thoại không hợp lệ !");
                        } while (checkPhone == false);
                        //email
                        System.out.println("Nhập email nhân viên " + (i+1) + ": ");
                        String emailInp = sc.nextLine();
                        email = emailInp.trim();
                        //address
                        System.out.println("Nhập địa chỉ nhân viên " + (i+1) + ": ");
                        String addressInp = sc.nextLine();
                        address = addressInp.trim();

                        arrEmp[i] = new Employee(id, name, birth, sex, phoneNumber, email, address);
                    }
                    break;
                case 2:
                    System.out.println("Nhập id: ");
                    String idFind = sc.nextLine();
                    boolean idFindCheck = false;
                    for (int i = 0; i < n; i++) {
                        if(arrEmp[i].getId().equalsIgnoreCase(idFind) == true){
                            System.out.println(arrEmp[i]);
                            idFindCheck = true; //Câu lệnh thực hiện mỗi lần lặp
                        }
                    }
                    if(idFindCheck == false){
                        System.out.println("Không tìm thấy nhân viên có id: " + idFind);
                    }
                    break;
                case 3:
                    System.out.println("Nhập giới tính (1 - Nam, 2 - Nữ): ");
                    int findSex = Integer.parseInt(sc.nextLine());
                    String isSex;
                    if(findSex == 1){
                        isSex = "Nam";
                    }
                    else {
                        isSex = "Nữ";
                    }
                    boolean sexFindCheck = false;
                    for (int i = 0; i < n; i++) {
                        if(arrEmp[i].getSex().equals(isSex)){
                            System.out.println(arrEmp[i]);
                            sexFindCheck = true;
                        }
                    }
                    if(sexFindCheck == false){
                        System.out.println("Không tìm thấy nhân viên nào");
                    }
                    break;
                case 4:
                    System.out.println("Nhập địa chỉ tìm kiếm: ");
                    String findAddress = sc.nextLine();
                    boolean addressFindCheck = false;
                    for (int i = 0; i < n; i++) {
                        if(arrEmp[i].getAddress().equalsIgnoreCase(findAddress)){
                            System.out.println(arrEmp[i]);
                            addressFindCheck = true;
                        }
                    }
                    if (addressFindCheck == false){
                        System.out.println("Không tìm thấy nhân viên nào");
                    }
                    break;
                case 5:
                    for (int i = 0; i < n; i++) {
                        System.out.println(arrEmp[i]);
                    }
                    break;
            }
        } while(!exit.equalsIgnoreCase("n"));
    }
}
