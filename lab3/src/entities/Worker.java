package entities;

import java.math.BigDecimal;

public class Worker {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String workPlace;
    private static int autoIncrease = 1;

    public Worker(String name, int age, long salary, String workPlace) {
        this.id = autoIncrease;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workPlace = workPlace;
        autoIncrease++;
    }


}
