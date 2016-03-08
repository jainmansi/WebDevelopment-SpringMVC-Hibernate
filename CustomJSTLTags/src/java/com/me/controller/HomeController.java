/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.CsvDao;
import com.me.DAO.DAO;
import com.me.pojo.SalesOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
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
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    CsvDao csvdao;
    Connection conn;
    DAO dao = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //ArrayList<SalesOrder> saleslist = new ArrayList<>();
            String action = request.getParameter("action");

            if (action.equals("sentFile")) {
                //saleslist = csvdao.connect();
                HttpSession session = request.getSession();
                session.setAttribute("flag", 1);
                session.setAttribute("filename", request.getParameter("fileName"));
                //session.setAttribute("salesOrderList", saleslist);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else if (action.equals("batchInsert")) {
                Enumeration en = request.getParameterNames();
                ArrayList<SalesOrder> listsales = new ArrayList<>();

                while (en.hasMoreElements()) {
                    Object obj = en.nextElement();

                    if (request.getParameter((String) obj).equals("batchInsert") 
                            && en.nextElement() == null) {

                        String query = "INSERT INTO sales(SalesOrderID, RevisionNumber, OrderDate, "
                                + "DueDate, ShipDate, Status, OnlineOrderFlag, SalesOrderNumber,"
                                + "PurchaseOrderNumber, AccountNumber, CustomerID, SalesPersonID,"
                                + "TerritoryID, BillToAddressID, ShipToAddressID, ShipMethodID, CreditCardID, "
                                + "CreditCardApprovalCode, CurrencyRateID, SubTotal, TaxAmt, Freight,"
                                + "TotalDue, Comment, ModifiedDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        conn = dao.getConnection();
                        PreparedStatement ps = conn.prepareStatement(query);

                        for (SalesOrder so : listsales) {
                            ps.setInt(1, so.getSalesOrderID());
                            ps.setInt(2, so.getRevisionNumber());
                            ps.setString(3, so.getOrderDate());
                            ps.setString(4, so.getDueDate());
                            ps.setString(5, so.getShipDate());
                            ps.setInt(6, so.getStatus());
                            ps.setInt(7, so.getOnlineOrderFlag());
                            ps.setString(8, so.getSalesOrderNumber());
                            ps.setString(9, so.getPurchaseOrderNumber());
                            ps.setString(10, so.getAccountNumber());
                            ps.setInt(11, so.getCustomerID());
                            ps.setInt(12, so.getSalesPersonID());
                            ps.setInt(13, so.getTerritoryID());
                            ps.setInt(14, so.getBillToAddressID());
                            ps.setInt(15, so.getShipToAddressID());
                            ps.setInt(16, so.getShipMethodID());
                            ps.setInt(17, so.getCreditCardID());
                            ps.setString(18, so.getCreditCardApprovalCode());
                            ps.setString(19, so.getCurrencyRateID());
                            ps.setDouble(20, so.getSubTotal());
                            ps.setDouble(21, so.getTaxAmt());
                            ps.setDouble(22, so.getFreight());
                            ps.setDouble(23, so.getTotalDue());
                            ps.setString(24, so.getComment());
                            ps.setString(25, so.getModifiedDate());

                            ps.addBatch();

                        }
                        ps.executeBatch();
                        ps.close();
                        conn.close();
                    }

                    else if (obj != null) {
                        String param = (String) obj;
                        String value = request.getParameter(param);
                        SalesOrder so = new SalesOrder();
                        so.setSalesOrderID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setRevisionNumber(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setOrderDate(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setDueDate(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setShipDate(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setStatus(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setOnlineOrderFlag(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setSalesOrderNumber(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setPurchaseOrderNumber(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setAccountNumber(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setCustomerID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setSalesPersonID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setTerritoryID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setBillToAddressID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setShipToAddressID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setShipMethodID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setCreditCardID(Integer.parseInt(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setCreditCardApprovalCode(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setCurrencyRateID(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setSubTotal(Double.parseDouble(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setTaxAmt(Double.parseDouble(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setFreight(Double.parseDouble(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setTotalDue(Double.parseDouble(value));

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setComment(value);

                        obj = en.nextElement();
                        param = (String) obj;
                        value = request.getParameter(param);
                        so.setModifiedDate(value);

                        listsales.add(so);
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("success.html");
                rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
