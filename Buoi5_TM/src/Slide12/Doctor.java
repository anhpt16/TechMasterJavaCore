package Slide12;

public class Doctor extends Person {
    private String specialist;
    private double hourWork;

    public Doctor(int id, String name, int age, String specialist, double hourWork) {
        super(id, name, age);
        this.specialist = specialist;
        this.hourWork = hourWork;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Id: " + getId() +
                ", Name: " + getName() +
                ", Age: " + getAge() +
                ", Specialist: " + specialist +
                ", HourWork: " + hourWork +
                '}';
    }
}
