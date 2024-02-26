package services;

import entities.Champion;

import java.util.Scanner;

public class ChampionService {
    public Champion inputInfo(Scanner sc){
        System.out.print("Nhập tên tướng: ");
        String name = sc.nextLine();
        System.out.print("Nhập vị trí: ");
        String position = sc.nextLine();
        return new Champion(name, position);
    }
}
