package services;

import entities.Champion;
import entities.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamService {
    public Team inputInfo(Scanner sc){
        ArrayList<Champion> champions = new ArrayList<>();
        ChampionService championService = new ChampionService();

        System.out.println("Nhập tên đội: ");
        String name = sc.nextLine();
        System.out.println("Nhập số lượng tướng: ");
        int numberChampion = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberChampion; i++) {
            System.out.println("Nhập thông tin cho tướng " + (i + 1) + ": ");
            champions.add(championService.inputInfo(sc));
        }
        return new Team(name, champions);
    }
}
