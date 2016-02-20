/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class bookRegistration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAO dao = new DAO();
    Connection conn;
    PreparedStatement ps;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();

            try {
                String actionValue = request.getParameter("action");
                if (actionValue.equals("numberEntered")) {
                    try {
                        int number = Integer.parseInt(request.getParameter("number"));

                        session.setAttribute("number", number);

                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/bookentry.jsp");
                        rd.forward(request, response);
                    } catch (Exception e) {
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/reenter.html");
                        rd.forward(request, response);
                    }
                } else if (actionValue.equals("bookDetails")) {

                    conn = dao.getConnection();
//                    Integer n = Integer.parseInt(session.getAttribute("bookNumber").toString()); 
//                    
//                    out.println(n);

                    Enumeration e = request.getParameterNames();
                    int counter = 0;

                    Object object;
                    while (e.hasMoreElements()) {
                        object = e.nextElement();
                        if (request.getParameter((String) object).equals("bookDetails") 
                                || request.getParameter((String) object).equals("")) {
                            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/success.jsp");
                            rd.forward(request, response);
                        }
                        if (object != null) {
                            String isbn = request.getParameter((String) object);
                            object = e.nextElement();
                            String author = request.getParameter((String) object);
                            object = e.nextElement();
                            String title = request.getParameter((String) object);
                            object = e.nextElement();
                            Float price = Float.parseFloat(request.getParameter((String) object));
                            String messageQuery = "INSERT INTO books(isbn, title, authors, price)" + "values(?,?,?,?);";

                            ps = conn.prepareStatement(messageQuery);
                            ps.setString(1, isbn);
                            ps.setString(2, title);
                            ps.setString(3, author);
                            ps.setFloat(4, price);

                            int result = ps.executeUpdate();

                            if (result > 0) {
                                counter++;
                            }
                            session.setAttribute("counter", counter);
                        }
                        else{
                            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/success.jsp");
                            rd.forward(request, response);
                        }
                    }
                }
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/reenter.html");
                rd.forward(request, response);
            } finally {
                dao.close(conn);
                dao.close(ps);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
