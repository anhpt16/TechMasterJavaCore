package entities;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private LocalDate birth;
    private String job;

    public Person(int id, String name, LocalDate birth, String job) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.job = job;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", job='" + job + '\'';
    }
}
