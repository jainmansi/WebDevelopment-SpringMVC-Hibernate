/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.DAO;
import com.me.bean.movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SelectionController extends HttpServlet {

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
    ResultSet resultMessages;
    ResultSet resultSet;
    PreparedStatement messageStatement;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String actionValue = request.getParameter("action");

            if (actionValue.equals("selection")) {

                String value = request.getParameter("selectValue");

                if (value.equals("browse")) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/browse.jsp");
                    rd.forward(request, response);
                } else if (value.equals("add")) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/add.jsp");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("index.html");
                }
            } 
            
            else if (actionValue.equals("addNew")) {

                conn = dao.getConnection();

                String title1 = request.getParameter("title");
                String actor1 = request.getParameter("actor");
                String actress1 = request.getParameter("actress");
                String genre1 = request.getParameter("genre");
                String year1 = request.getParameter("year");

                String messageQuery = "INSERT INTO movies(title, actor, actress, genre, year)" + "values(?,?,?,?,?)";

                ps = conn.prepareStatement(messageQuery);
                ps.setString(1, title1);
                ps.setString(2, actor1);
                ps.setString(3, actress1);
                ps.setString(4, genre1);
                ps.setString(5, year1);

                int result = ps.executeUpdate();

                if (result > 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/success.jsp");
                    rd.forward(request, response);
                }
            } 
            
            else if (actionValue.equals("browse")) {
                conn = dao.getConnection();

                String select = request.getParameter("search");
                String keyword = request.getParameter("keyword");
                String messageQuery = "";
                if (select.equals("title")) {
                    messageQuery = "SELECT * FROM movies WHERE title like ?";
                } else if (select.equals("actor")) {
                    messageQuery = "SELECT * FROM movies WHERE actor like ?";
                } else if (select.equals("actress")) {
                    messageQuery = "SELECT * FROM movies WHERE actress like ?";
                }

                ps = conn.prepareStatement(messageQuery);
                ps.setString(1, "%"+keyword+"%");
                resultMessages = ps.executeQuery();

                ArrayList<movie> movieList = new ArrayList<>();
                HttpSession session = request.getSession();

                while (resultMessages.next()) {
                    movie movieBean = new movie();
                    movieBean.setActor(resultMessages.getString("actor"));
                    movieBean.setActress(resultMessages.getString("actress"));
                    movieBean.setGenre(resultMessages.getString("genre"));
                    movieBean.setTitle(resultMessages.getString("title"));
                    movieBean.setYear(resultMessages.getString("year"));
                    movieList.add(movieBean);
                }

                session.setAttribute("movieList", movieList);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/searchresult.jsp");
                rd.forward(request, response);
            }

        } finally {
            dao.close(conn);
            dao.close(ps);
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelectionController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelectionController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
