/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.service;

import cz.ibacz.test.ibatestproject.model.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author Milan
 */
@Service
public class StudentServiceImpl implements StudentService {
    private Map<Long, Student> students;
    private Long id;

    public StudentServiceImpl() {
        students = new HashMap<>();
        id = new Long(1);
    }

    @Override
    public Long newStudent(Student newStudent) {
        Objects.requireNonNull(newStudent, "Null student can't be created.");
        Objects.requireNonNull(newStudent.getDateOfBirth(), "Student with null date of birth can't be created.");
        Objects.requireNonNull(newStudent.getFirstName(), "Student with null first name can't be created.");
        Objects.requireNonNull(newStudent.getSurname(), "Student with null surname can't be created.");
        Objects.requireNonNull(newStudent.getGender(), "Student with null gender can't be created.");
        students.put(id, newStudent);
        newStudent.setId(id);
        id++;
        return id - 1;
    }

    @Override
    public Student findStudentById(Long id) {
        Objects.requireNonNull(id, "Student with null id can't be found");
        Student s = students.get(id);
        if (s == null)
            throw new NoSuchElementException("Student was not found");
        return s;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public void removeStudent(Student toRemove) {
        Objects.requireNonNull(toRemove, "Null student can't be removed.");
        Objects.requireNonNull(toRemove.getDateOfBirth(), "Student with null id can't be removed.");
        students.remove(toRemove.getId());
    }

    @Override
    public void editStudent(Student newStudent) {
        Objects.requireNonNull(newStudent, "Null student can't be created.");
        Objects.requireNonNull(newStudent.getDateOfBirth(), "Student with null date of birth can't be created.");
        Objects.requireNonNull(newStudent.getFirstName(), "Student with null first name can't be created.");
        Objects.requireNonNull(newStudent.getSurname(), "Student with null surname can't be created.");
        Objects.requireNonNull(newStudent.getGender(), "Student with null gender can't be created.");
        students.put(newStudent.getId(), newStudent);
    }
    
}
