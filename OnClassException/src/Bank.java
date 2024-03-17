public class Bank {
    private int id;
    private String name;
    private double rate;
    private static int autoIncrease = 100;

    public Bank(String name, double rate) {
        this.id = autoIncrease;
        this.name = name;
        this.rate = rate;
        autoIncrease++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
