package entities;

import java.util.ArrayList;

public class Course {
    private String subject;
    private ArrayList<Student> students;

    public Course(String subject, ArrayList<Student> students) {
        this.subject = subject;
        this.students = students;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
