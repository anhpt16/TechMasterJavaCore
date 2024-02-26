package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Match {
    private ArrayList<Team> teams;
    private LocalDateTime timeStart;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public Match(ArrayList<Team> teams, LocalDateTime timeStart) {
        this.teams = teams;
        this.timeStart = timeStart;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teams=" + teams +
                ", timeStart=" + timeStart +
                '}';
    }
}
