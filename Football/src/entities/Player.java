package entities;

public class Player {
    private int number;
    private String name;
    private Enum position;

    public Player(int number, String name, Enum position) {
        this.number = number;
        this.name = name;
        this.position = position;
    }

    public Enum getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
