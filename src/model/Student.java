package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private final List<Subject> subjects;

    public Student(String name, int age) {
        super(name, age);
        subjects = new ArrayList<>();
    }

    public void submitSubject(List<Subject> subjects){
        this.subjects.clear();
        this.subjects.addAll(subjects);
    }
}
