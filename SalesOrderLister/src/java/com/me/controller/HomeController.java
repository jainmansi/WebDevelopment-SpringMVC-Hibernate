/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.CsvDao;
import com.me.DAO.DAO;
import com.me.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
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

    CsvDao csvdao;
    Connection conn;
    DAO dao = new DAO();

    public HomeController(CsvDao csvdao) {
        this.csvdao = csvdao;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
//        SalesOrder salesOrder = new SalesOrder();
        ArrayList<SalesOrder> saleslist = new ArrayList<>();

        String action = request.getParameter("action");

        if (action.equals("sentFile")) {
            saleslist = csvdao.connect();

            mv.addObject("salesOrderList", saleslist);
            //           int n = salesList.size();
            HttpSession session = request.getSession();
//          session.setAttribute("flag", 1);
            //     session.setAttribute("salesOrderList", salesList);
            mv.setViewName("index");
        } else if (action.equalsIgnoreCase("batchInsert")) {

            Enumeration en = request.getParameterNames();
            ArrayList<SalesOrder> listsales = new ArrayList<>();
            
            while (en.hasMoreElements()) {
                Object obj = en.nextElement();
                SalesOrder so = new SalesOrder();
                String param;
                String value;
                
                param = (String) obj;
                
                if(param.equals("SalesOrderID")){
                    param = (String) obj;
                    value = request.getParameter(param);                    
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
                    so.setBillToAddressID(Integer.parseInt(value));
                    
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
                else{
                    
                    obj = en.nextElement();
                }
                
            }
                
                              
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
                    
                     mv.addObject("flag", 1);            
                     mv.setViewName("index");
                }
                
        return mv;
    
    }
}
