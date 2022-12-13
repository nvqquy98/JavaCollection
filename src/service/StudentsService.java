package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsService {
    public static StudentsService INTANCE = new StudentsService();
    private List<Student> studentList;

    private StudentsService() {
        studentList = new ArrayList<>();
    }
}
