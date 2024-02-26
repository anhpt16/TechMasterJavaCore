package entities;

public class Center {
    private String manager;
    private String teacher;
    private Course course;

    public Center(String manager, String teacher, Course course) {
        this.manager = manager;
        this.teacher = teacher;
        this.course = course;
    }

    public String getManager() {
        return manager;
    }

    public String getTeacher() {
        return teacher;
    }

    public Course getCourse() {
        return course;
    }
}
