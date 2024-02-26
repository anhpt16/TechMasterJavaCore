import entities.Match;
import services.MatchService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatchService matchService = new MatchService();

        Match match = matchService.inputInfo(sc);
        matchService.outputInfo(match);
    }
}
