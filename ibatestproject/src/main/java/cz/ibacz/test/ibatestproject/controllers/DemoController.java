/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Milan
 */
@Controller
public class DemoController {
    
    @RequestMapping(value = "/Hello")
    public ModelAndView hello(@RequestParam(value = "x", defaultValue = "1") String x) {
        Integer value;
        try {
            value = Integer.valueOf(x);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            value = 1;
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("var", value);

        return model;
    }
    
    
}
