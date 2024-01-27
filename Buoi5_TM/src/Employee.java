public class Employee extends Person2{
    private double experience;
    private String placeWork;


    public Employee(int id, String name, String address, int age, double experience, String placeWork) {
        super(id, name, address, age);
        this.experience = experience;
        this.placeWork = placeWork;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", age='" + getAge() + '\'' +
                ", experience=" + experience +
                ", placeWork='" + placeWork + '\'' +
                '}';
    }
}
