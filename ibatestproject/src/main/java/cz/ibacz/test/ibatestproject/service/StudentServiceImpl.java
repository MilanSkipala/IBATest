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
        students.put(id, newStudent);
        newStudent.setId(id);
        id++;
        return id - 1;
    }

    @Override
    public Student findStudentById(Long id) {
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
        students.remove(toRemove.getId());
    }

    @Override
    public void editStudent(Student newStudent) {
        students.put(newStudent.getId(), newStudent);
    }
    
}
