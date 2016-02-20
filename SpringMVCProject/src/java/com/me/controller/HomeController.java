/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.BookDAO;
import com.me.DAO.DAO;
import java.sql.Connection;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author user
 */
public class HomeController extends AbstractController {

    BookDAO bookDAO;
    Connection conn;
    DAO dao = new DAO();

    public HomeController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("numberEntered")) {
            try {
                int number = Integer.parseInt(request.getParameter("number"));
                session.setAttribute("number", number);
                mv.setViewName("bookentry");
            } catch (Exception e) {

            }
        } else if (action.equalsIgnoreCase("bookDetails")) {
            conn = dao.getConnection();

            Enumeration e = request.getParameterNames();
            int counter = 0;

            Object object;
            try {
                while (e.hasMoreElements()) {
                    object = e.nextElement();
                    if (request.getParameter((String) object).equals("bookDetails")
                            || request.getParameter((String) object).equals("")) {
                        mv.setViewName("success");
                    } else if (object != null) {
                        String isbn = request.getParameter((String) object);
                        object = e.nextElement();
                        String author = request.getParameter((String) object);
                        object = e.nextElement();
                        String title = request.getParameter((String) object);
                        object = e.nextElement();
                        Float price = Float.parseFloat(request.getParameter((String) object));
                        bookDAO.newBook(isbn, title, author, price);
                        counter++;
                    }
                }
                mv.addObject("count", counter);
                mv.setViewName("success");
            } catch (Exception ex) {
                mv.setViewName("reenter");
            }
        }

        return mv;

    }
}
