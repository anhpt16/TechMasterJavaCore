package services;

import Utils.Position;
import entities.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamService {
    public void buildTeam(Scanner sc, ArrayList<Player> players) {
        int choose = 0;
        ArrayList<Player> team = new ArrayList<>();

        ArrayList<Player> playerGKs = new ArrayList<>();
        ArrayList<Player> playerDFs = new ArrayList<>();
        ArrayList<Player> playerMFs = new ArrayList<>();
        ArrayList<Player> playerFWs = new ArrayList<>();
        for (Player p : players) {
            if (p.getPosition() == Position.GK)
                playerGKs.add(p);
            else if (p.getPosition() == Position.DF)
                playerDFs.add(p);
            else if (p.getPosition() == Position.MF)
                playerMFs.add(p);
            else
                playerFWs.add(p);
        }

        do {
            System.out.println("-------------------");
            System.out.println("1. 1GK - 4DF - 2MF - 2FW");
            System.out.println("2. 1GK - 4DF - 3MF - 3FW");
            System.out.println("3. 1GK - 3DF - 5MF - 2FW");
            System.out.println("0. Thoát");
            System.out.print("Hãy nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("---------------------");

            switch (choose) {
                case 1:
                    if (checkPlayerForTeam(playerGKs, playerDFs, playerMFs, playerFWs, 1, 4, 2, 2) == true) {
                        for (int i = 0; i < 11; i++) {
                            if(i == 0){

                            }
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choose != 0);

    }

    public boolean checkPlayerForTeam(ArrayList<Player> GKs, ArrayList<Player> DFs, ArrayList<Player> MFs, ArrayList<Player> FWs,
                                      int numberGK, int numberDF, int numberMF, int numberFW){
        if (GKs.size() < numberGK){
            System.out.println("Số lượng GK không đủ để xếp đội hình này !");
            return false;
        }
        if (DFs.size() < numberDF){
            System.out.println("Số lượng DF không đủ để xếp đội hình này !");
            return false;
        }
        if (MFs.size() < numberMF){
            System.out.println("Số lượng MF không đủ để xếp đội hình này !");
            return false;
        }
        if (FWs.size() < numberFW){
            System.out.println("Số lượng FW không đủ để xếp đội hình này !");
            return false;
        }
        return true;
    }

    public ArrayList<Player> chooseTeam(int numberGK, int numberDF, int numberMF, int numberFW){

        return null;
    }
}
