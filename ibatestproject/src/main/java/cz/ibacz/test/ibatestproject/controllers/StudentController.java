/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.controllers;

import cz.ibacz.test.ibatestproject.Gender;
import cz.ibacz.test.ibatestproject.model.Student;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
    @RequestMapping("")
    public String defaultPage(Model model) {
        return "student/home";
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
        redirectAttributes.addFlashAttribute("student", student);
        redirectAttributes.addFlashAttribute("alert_info", "Student " + student.getSurname() + " was created");
        return "redirect:" + uriBuilder.path("/student/detail").toUriString();
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String showStudent(Model model) {
        Student student = (Student) model.asMap().get("student");
        if (student == null) {
            return "student/home";
        }
        model.addAttribute("student", student);
        return "student/detail";
    }
    
    @ModelAttribute("genders")
    public Gender[] conditions() {
        return Gender.values();
    }
}
