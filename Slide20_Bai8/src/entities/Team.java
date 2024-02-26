package entities;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Champion> champions;

    public String getName() {
        return name;
    }

    public ArrayList<Champion> getChampions() {
        return champions;
    }

    public Team(String name, ArrayList<Champion> champions) {
        this.name = name;
        this.champions = champions;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", champions=" + champions +
                '}';
    }
}
