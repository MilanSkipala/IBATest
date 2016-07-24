/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.rest;

import cz.ibacz.test.ibatestproject.model.Student;
import cz.ibacz.test.ibatestproject.service.StudentService;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Milan
 */
@RestController
@RequestMapping("/rest/student")
public class StudentServiceRest {
    @Autowired
    @Resource(name = "studentServiceDbImpl")
    private StudentService studentService;
            

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response getAllStudents() {
        return Response.status(Response.Status.OK).entity(studentService.getAllStudents()).build();
        //return Response.status(Response.Status.OK).entity("HELLO").build();
    }
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Response findStudentById(@PathVariable Long id) {
        return Response.status(Response.Status.OK).entity(studentService.findStudentById(id)).build();
    }
    
    @RequestMapping(value="/remove/{id}") 
    public Response removeStudent(@PathVariable Long id) {
        studentService.removeStudent(studentService.findStudentById(id));
        return Response.status(Response.Status.OK).entity("Student with id " + id + " was successfully removed.").build();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response addBook(@RequestBody Student student) {
        Long id = studentService.newStudent(student);
        return Response.status(Response.Status.OK).entity("Student with id " + id + " was successfully added.").build();
    }
    
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Requested student was not found")
    @ExceptionHandler(Exception.class)
    public void notFound() {
    }
}
