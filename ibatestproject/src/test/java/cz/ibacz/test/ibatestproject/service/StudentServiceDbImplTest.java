/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.service;

import cz.ibacz.test.ibatestproject.Gender;
import cz.ibacz.test.ibatestproject.config.DbConfig;
import cz.ibacz.test.ibatestproject.config.SpringConfig;
import cz.ibacz.test.ibatestproject.model.Student;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 *
 * @author Milan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DbConfig.class, StudentServiceDbImpl.class})
@Transactional
public class StudentServiceDbImplTest {
    
    @PersistenceContext
    public EntityManager em;
    
    @Autowired
    @Resource(name = "studentServiceDbImpl")
    public StudentService studentService;
    
    private Student studentA;
    private Student studentB;
    
    
    @Before
    public void setUp() {
        em.createQuery("delete from Student").executeUpdate();
        studentA = new Student();
        studentA.setFirstName("Student");
        studentA.setSurname("AA");
        studentA.setGender(Gender.MALE);
        Calendar c = Calendar.getInstance();
        c.set(1991, 1, 1);
        studentA.setDateOfBirth(c.getTime());
        c.set(1995, 1, 1);
        
        studentB = new Student();
        studentB.setFirstName("Studentt");
        studentB.setSurname("BB");
        studentB.setGender(Gender.FEMALE);
        studentB.setDateOfBirth(c.getTime());
    }
    
    @Test(expected = NullPointerException.class)
    public void createNullStudentTest() {
        studentService.newStudent(null);
    }
    @Test(expected = NullPointerException.class)
    public void createStudentWithNullFirstNameTest() {
        studentA.setFirstName(null);
        studentService.newStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void createStudentWithNullSurnameTest() {
        studentA.setSurname(null);
        studentService.newStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void createStudentWithNullDateOfBirthTest() {
        studentA.setDateOfBirth(null);
        studentService.newStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void createStudentWithNullGender() {
        studentA.setGender(null);
        studentService.newStudent(studentA);
    }
    @Test
    public void createValidStudentTest() {
        studentService.newStudent(studentA);
        assertNotNull(studentA.getId());
    }
    
    @Test(expected = NullPointerException.class)
    public void findNullStudentTest() {
        studentService.findStudentById(null);
    }
    @Test(expected = NoSuchElementException.class)
    //@Test(expected = NullPointerException.class)
    public void findNonExistentStudentTest() {
        studentService.findStudentById(new Long(1));
    }
    @Test
    public void findValidStudentTest() {
        Long id = studentService.newStudent(studentA);
        assertEquals(studentService.findStudentById(id), studentA);
        studentService.newStudent(studentB);
        assertEquals(studentService.findStudentById(id), studentA);        
    }
    @Test
    public void getAllStudentsTest() {
        assertEquals(studentService.getAllStudents().size(), 0);
        studentService.newStudent(studentA);
        assertEquals(studentService.getAllStudents().size(), 1);
        studentService.newStudent(studentB);
        assertEquals(studentService.getAllStudents().size(), 2);
    }
    @Test(expected = NullPointerException.class)
    public void updateNullStudentTest() {
        studentService.editStudent(null);
    }
    @Test(expected = NullPointerException.class)
    public void updateStudentWithNullFirstNameTest() {
        studentService.newStudent(studentA);
        studentA.setFirstName(null);
        studentService.editStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void updateStudentWithNullSurnameTest() {
        studentService.newStudent(studentA);
        studentA.setSurname(null);
        studentService.editStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void updateStudentWithNullDateOfBirthTest() {
        studentService.newStudent(studentA);
        studentA.setDateOfBirth(null);
        studentService.editStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void updateStudentWithNullGender() {
        studentService.newStudent(studentA);
        studentA.setGender(null);
        studentService.editStudent(studentA);
    }
    @Test
    public void updateValidStudentTest() {
        studentService.newStudent(studentA);
        assertNotNull(studentA.getId());
        studentA.setFirstName("Update");
        studentService.editStudent(studentA);
    }
    @Test(expected = NullPointerException.class)
    public void removeNullStudent() {
        studentService.removeStudent(null);
    }
    @Test(expected = NoSuchElementException.class)
    public void removeValidStudent() {
        studentService.newStudent(studentA);
        assertNotNull(studentA.getId());
        studentService.removeStudent(studentService.findStudentById(studentA.getId()));
        studentService.findStudentById(studentA.getId());
    }
    
}
