package entities;

public class Ministration {
    private int id;
    private String name;
    private long rate;
    private String unit;
    private static int autoIncrease = 100;

    public Ministration(String name, long rate, String unit) {
        this.id = autoIncrease++;
        this.name = name;
        this.rate = rate;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void display(){
        System.out.printf("|%-6d|%-30s|%-20d|%-10s|\n", id, name, rate, unit);
    }
}
