package services;

import entities.Match;
import entities.Team;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchService {
    public Match inputInfo(Scanner sc){
        ArrayList<Team> teams = new ArrayList<>();
        TeamService teamService = new TeamService();

        System.out.println("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm:ss): ");
        String timeString = sc.nextLine();
        LocalDateTime timeStart = LocalDateTime.parse(timeString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        for (int i = 0; i < 2; i++) {
            System.out.println("Nhập thông tin cho đội " + (i + 1) + ": ");
            teams.add(teamService.inputInfo(sc));
        }
        return new Match(teams, timeStart);
    }

    public void outputInfo(Match match){
        System.out.println("Trận đấu: " + match.getTeams().get(0).getName() + " - " + match.getTeams().get(1).getName());
        System.out.println("Thời gian bắt đầu: " + match.getTimeStart());
        for (int i = 0; i < match.getTeams().size(); i++) {
            System.out.println("Thông tin đội " + (i + 1) + " - " + match.getTeams().get(i).getName());
            for (int j = 0; j < match.getTeams().get(i).getChampions().size(); j++) {
                System.out.println("-- Tướng " + (j + 1) + ": " + match.getTeams().get(i).getChampions().get(j).getName() + " - " + match.getTeams().get(i).getChampions().get(j).getPosition());
            }
        }
    }
}
