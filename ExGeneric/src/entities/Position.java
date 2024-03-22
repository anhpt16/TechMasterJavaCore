package entities;

public class Position {
    private int id;
    private String name;
    private long bonus;
    private static int autoIncrease = 100;

    public Position(String name, long bonus) {
        this.id = autoIncrease++;
        this.name = name;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return String.format("|%-5d|%-25s|%-10d|", id, name, bonus);
    }
}
