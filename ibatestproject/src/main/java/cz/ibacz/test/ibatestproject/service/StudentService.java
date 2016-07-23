/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.service;

import cz.ibacz.test.ibatestproject.model.Student;
import java.util.Collection;

/**
 *
 * @author Milan
 */
public interface StudentService {
    public Long newStudent(Student newStudent);
    public Student findStudentById(Long id);
    public Collection<Student> getAllStudents();
    public void removeStudent(Student toRemove);
    public void editStudent(Student newStudent);
}
