package entities;

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private double point;
    private String classroom;

    public Student(int id, String name, int age, String address, double point, String classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.point = point;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getPoint() {
        return point;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", classroom='" + classroom + '\'';
    }
}
