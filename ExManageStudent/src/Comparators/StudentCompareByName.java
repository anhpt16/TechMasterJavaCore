package Comparators;

import entities.Student;

import java.util.Comparator;

public class StudentCompareByName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        String[] o1 = s1.getName().trim().split(" ");
        String[] o2 = s2.getName().trim().split(" ");
        return o1[o1.length - 1].compareTo(o2[o2.length - 1]);
    }
}
