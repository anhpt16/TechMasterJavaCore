package services;

import IServices.IMinistrationService;
import entities.Ministration;
import utils.InputCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class MinistrationService implements IMinistrationService {
    private static MinistrationService instance;
    private MinistrationService(){}
    public static MinistrationService getInstance(){
        if (instance == null){
            instance = new MinistrationService();
        }
        return instance;
    }

    InputCheck inputCheck = InputCheck.getInstance();

    @Override
    public Ministration inputInfo() {
        System.out.print("--Nhập tên dịch vụ: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("--Nhập giá cước: ");
        long rate = inputCheck.checkLongInput();
        System.out.print("--Nhập đơn vị tính: ");
        String unit = new Scanner(System.in).nextLine();
        return new Ministration(name, rate, unit);
    }

    @Override
    public void displayList(ArrayList<Ministration> ministrations) {
        inputCheck.checkNullArrayList(ministrations, "Ministration", "displayList");
        System.out.println("-".repeat(71));
        System.out.printf("|%-6s|%-30s|%-20s|%-10s|\n", "ID", "Name", "Rate", "Unit");
        System.out.println("-".repeat(71));
        for (Ministration m : ministrations){
            m.display();
        }
    }

    @Override
    public void addMinistration(ArrayList<Ministration> ministrations) {
        inputCheck.checkNullArrayList(ministrations, "Ministration", "addMinistration");
        System.out.print("--Nhập số lượng dịch vụ muốn thêm: ");
        int count = inputCheck.checkIntInput();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho dịch vụ " + (i + 1));
            ministrations.add(inputInfo());
        }
    }

    @Override
    public Ministration findMinistrationById(ArrayList<Ministration> ministrations, int id) {
        if (inputCheck.checkNullArrayList(ministrations, "Ministration", "findMinistrationById") == false){
            return null;
        }
        for (Ministration m : ministrations){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

}
