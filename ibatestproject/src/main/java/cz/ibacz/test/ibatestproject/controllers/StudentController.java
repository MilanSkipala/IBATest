/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.controllers;

import cz.ibacz.test.ibatestproject.Gender;
import cz.ibacz.test.ibatestproject.model.Student;
import cz.ibacz.test.ibatestproject.service.StudentService;
import cz.ibacz.test.ibatestproject.service.StudentServiceDbImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Milan
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Resource(name = "studentServiceDbImpl")
    private StudentService studentService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
    @RequestMapping("")
    public String defaultPage(Model model) {
        return showStudents(model);
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addStudent(Model model) {
        model.addAttribute("newStudent", new Student());
        return "student/new";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "student/new";
        }
        Long id = studentService.newStudent(student);
        //redirectAttributes.addFlashAttribute("student", student);
        redirectAttributes.addFlashAttribute("alert_info", "Student " + student.getSurname() + " was created");
        return "redirect:" + uriBuilder.path("/student/detail/" + id).toUriString();
    }
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String showStudent(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        try {
            Student student = studentService.findStudentById(id);
            model.addAttribute("student", student);
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("alert_danger", "Student " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/student/list").toUriString();
        }
        return "student/detail";
    }
    
    @RequestMapping(value="/list") 
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }
    
    @RequestMapping(value="/remove/{id}") 
    public String removeStudent(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        studentService.removeStudent(studentService.findStudentById(id));
        redirectAttributes.addFlashAttribute("alert_info", "Student was removed");
        return "redirect:" + uriBuilder.path("/student/list").toUriString();
    }
    
    @RequestMapping(value="/editSave/{id}", method = RequestMethod.POST) 
    public String editStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, @PathVariable Long id) {
        if (student.getId() == null) {
            student.setId(id);
        }
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return  "student/edit";
        }
        studentService.editStudent(student);
        redirectAttributes.addFlashAttribute("alert_info", "Student " + student.getFirstName() + " " + student.getSurname() +  " was updated");
        return "redirect:" + uriBuilder.path("/student/list").toUriString();
    }
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET) 
    public String displayEditStudent(Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, @PathVariable Long id) {
        try {
            Student student = studentService.findStudentById(id);
            model.addAttribute("student", student);
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("alert_danger", "Student " + id + " was not found.");
            return "redirect:" + uriBuilder.path("/student/list").toUriString();
        }
        return "student/edit";
    }
    
    @ModelAttribute("genders")
    public Gender[] conditions() {
        return Gender.values();
    }
}
