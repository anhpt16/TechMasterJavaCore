package entities;

public class TaskTable {
    private Staff staff;
    private Position position;
    private int days;

    public TaskTable() {
    }

    public TaskTable(Staff staff, Position position, int days) {
        this.staff = staff;
        this.position = position;
        this.days = days;
    }

    public Staff getStaff() {
        return staff;
    }

    public Position getPosition() {
        return position;
    }

    public int getDays() {
        return days;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return String.format("|%-25s|%-25s|%-5d|", staff.getName(), position.getName(), days);
    }
}
