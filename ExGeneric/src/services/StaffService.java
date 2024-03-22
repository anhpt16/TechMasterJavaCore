package services;

import entities.Staff;
import iservices.IStaffService;
import utils.InputCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffService extends GeneralService implements IStaffService {
    private static StaffService instance;
    private StaffService(){}
    public static StaffService getInstance(){
        if (instance == null)
            instance = new StaffService();
        return instance;
    }

    public Staff inputInfo(){
        System.out.print("--Nhập họ tên: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("--Nhập địa chỉ: ");
        String address = new Scanner(System.in).nextLine();
        System.out.print("--Nhập số điện thoại: ");
        String phoneNumber = inputCheck.checkPhoneNumber();
        System.out.print("--Nhập mức lương: ");
        long salary = inputCheck.checkLongInput();
        return new Staff(name, address, phoneNumber, salary);
    }

    public void addStaff(ArrayList<Staff> staffs){
        inputCheck.checkNullArrayList(staffs, "Staff", "addStaff");
        System.out.print("Nhập số lượng nhân viên: ");
        int quantity = inputCheck.checkIntInput();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Nhập thông tin cho nhanh viên " + (i + 1));
            staffs.add(inputInfo());
        }
    }

    public Staff findStaffById(ArrayList<Staff> staffs, int id){
        inputCheck.checkNullArrayList(staffs, "Staff", "findStaffById");
        for (Staff s : staffs){
            if (s.getId() == id){
                //Nếu tồn tại thì trả về nhân viên
                return s;
            }
        }
        return null;
    }
}
