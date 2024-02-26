package entities;

public class Student {
    private int id;
    private String name;
    private int age;
    private String level;

    public Student(int id, String name, int age, String level) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level='" + level + '\'';
    }
}
