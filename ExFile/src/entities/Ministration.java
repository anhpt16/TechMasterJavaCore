package entities;

import java.io.Serializable;

public class Ministration implements Serializable {
    private int id;
    private String description;
    private long rate;
    private static int autoIncrease = 100;

    public Ministration(String description, long rate) {
        this.id = autoIncrease++;
        this.description = description;
        this.rate = rate;
    }

}
