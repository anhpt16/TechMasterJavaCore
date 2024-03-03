package entities;

public class Student {
    private int id;
    private String name;
    private String address;
    private static int autoIncrease = 1;

    public Student(String name, String address) {
        this.id = autoIncrease;
        this.name = name;
        this.address = address;
        autoIncrease++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\t" + ",Name: " + name + "\t" + ",Address: " + address;
    }
}
