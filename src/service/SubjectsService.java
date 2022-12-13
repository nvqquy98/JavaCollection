package service;

import model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectsService implements BasicOperator<Subject> {
    public static SubjectsService INTANCE = new SubjectsService();
    private List<Subject> subjectList;

    private SubjectsService() {
        subjectList = new ArrayList<>();
    }

    @Override
    public List<Subject> getAllData() {
        return subjectList;
    }

    @Override
    public Subject getDataById(int id) {
        for (Subject subject : this.subjectList) {
            if (subject.getId() == id) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public Subject addData(Subject data) {
        if (getDataById(data.getId()) != null) {
            System.out.println("Da ton tai");
            return null;
        }
        this.subjectList.add(data);
        return data;
    }

    @Override
    public Subject updateData(Subject data) {
        Subject subject = getDataById(data.getId());
        if (subject == null) return null;

        boolean validationName = subject.getName() != null || !subject.getName().isBlank();
        boolean validationCurrentNumber = subject.getCurrentNumber() >= 0 && data.getCurrentNumber() <= subject.getMaxNumber();
        boolean validationMaxNumber = subject.getCurrentNumber() <= data.getMaxNumber();

        if (validationName) subject.setName(data.getName());
        if (validationCurrentNumber) subject.setCurrentNumber(data.getCurrentNumber());
        if (validationMaxNumber) subject.setMaxNumber(data.getMaxNumber());
        return subject;
    }

    @Override
    public Subject removeDataById(int id) {
        Subject subject = getDataById(id);
        if (subject == null) return null;

        this.subjectList.remove(subject);
        return subject;
    }
}
