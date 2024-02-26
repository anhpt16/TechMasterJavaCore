package entities;

import java.util.ArrayList;

public class Family {
    private int id;
    private String address;
    private ArrayList<Person> persons;

    public Family(int id, String address, ArrayList<Person> persons) {
        this.id = id;
        this.address = address;
        this.persons = persons;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", address='" + address + '\'' +
                ", persons=" + persons;
    }
}
