/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ibacz.test.ibatestproject.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milan
 */
public class DemoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Try to convert parameter value to integer. If it fails (= exception is thrown), it means, that there 
        //is no parameter or it has non-number value. If the parameter value is less than zero, it is changed to x=1
        try {
            Integer value = Integer.valueOf(req.getParameter("x"));
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (NullPointerException | IllegalArgumentException e) {
            req.getRequestDispatcher("/index.jsp?x=1").forward(req, resp);
        }
    }
    
}
