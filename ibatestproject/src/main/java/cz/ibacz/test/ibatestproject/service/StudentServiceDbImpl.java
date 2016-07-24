/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.service;

import cz.ibacz.test.ibatestproject.model.Student;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milan
 */
@Service("studentServiceDbImpl")
@Transactional
@Repository
public class StudentServiceDbImpl implements StudentService {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long newStudent(Student newStudent) {
        Objects.requireNonNull(newStudent, "Null student can't be created.");
        Objects.requireNonNull(newStudent.getDateOfBirth(), "Student with null date of birth can't be created.");
        Objects.requireNonNull(newStudent.getFirstName(), "Student with null first name can't be created.");
        Objects.requireNonNull(newStudent.getSurname(), "Student with null surname can't be created.");
        Objects.requireNonNull(newStudent.getGender(), "Student with null gender can't be created.");
        em.persist(newStudent);
        return newStudent.getId();
    }

    @Override
    public Student findStudentById(Long id) {
        Objects.requireNonNull(id, "Student with null id can't be found");
        Student s = em.find(Student.class, id);
        if (s == null)
            throw new NoSuchElementException("Student was not found");
        return s;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return em.createQuery("select s from Student s", Student.class).getResultList();
    }

    @Override
    public void removeStudent(Student toRemove) {
        Objects.requireNonNull(toRemove, "Null student can't be removed.");
        Objects.requireNonNull(toRemove.getDateOfBirth(), "Student with null id can't be removed.");
        em.remove(toRemove);
    }

    @Override
    public void editStudent(Student newStudent) {
        Objects.requireNonNull(newStudent, "Null student can't be created.");
        Objects.requireNonNull(newStudent.getDateOfBirth(), "Student with null date of birth can't be created.");
        Objects.requireNonNull(newStudent.getFirstName(), "Student with null first name can't be created.");
        Objects.requireNonNull(newStudent.getSurname(), "Student with null surname can't be created.");
        Objects.requireNonNull(newStudent.getGender(), "Student with null gender can't be created.");
        em.merge(newStudent);
    }
    
    
}
