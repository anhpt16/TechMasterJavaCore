package Comparators;

import entities.Student;

import java.util.Comparator;

public class StudentCompareByPoint implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getPoint() > s2.getPoint())
            return -1;
        else
            return 1;
    }
}
