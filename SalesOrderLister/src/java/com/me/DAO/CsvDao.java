/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class CsvDao {

        ArrayList<SalesOrder> saleslist = new ArrayList<>();
    public ArrayList<SalesOrder> connect() {
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\user\\Documents\\NetBeansProjects\\Assignment4WebPart4\\web\\WEB-INF\\jsp");

      // create a scrollable Statement so we can move forwards and backwards
            // through ResultSets
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet result = stmt.executeQuery("SELECT * FROM Test");

            ResultSetMetaData meta = result.getMetaData();

            while (result.next()) {
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setSalesOrderID(result.getInt("SalesOrderID"));
                salesOrder.setRevisionNumber(result.getInt("RevisionNumber"));
                salesOrder.setOrderDate(result.getString("OrderDate"));
                salesOrder.setDueDate(result.getString("DueDate"));
                salesOrder.setShipDate(result.getString("ShipDate"));
                salesOrder.setStatus(result.getInt("Status"));
                salesOrder.setOnlineOrderFlag(result.getInt("OnlineOrderFlag"));
                salesOrder.setSalesOrderNumber(result.getString("SalesOrderNumber"));
                salesOrder.setPurchaseOrderNumber(result.getString("PurchaseOrderNumber"));
                salesOrder.setAccountNumber(result.getString("AccountNumber"));
                salesOrder.setCustomerID(result.getInt("CustomerID"));
                salesOrder.setSalesPersonID(result.getInt("SalesPersonID"));
                salesOrder.setTerritoryID(result.getInt("TerritoryID"));
                salesOrder.setBillToAddressID(result.getInt("BillToAddressID"));
                salesOrder.setShipToAddressID(result.getInt("ShipToAddressID"));
                salesOrder.setShipMethodID(result.getInt("ShipMethodID"));
                salesOrder.setCreditCardID(result.getInt("CreditCardID"));
                salesOrder.setCreditCardApprovalCode(result.getString("CreditCardApprovalCode"));
                salesOrder.setCurrencyRateID(result.getString("CurrencyRateID"));
                salesOrder.setSubTotal(result.getDouble("SubTotal"));
                salesOrder.setTaxAmt(result.getDouble("TaxAmt"));
                salesOrder.setFreight(result.getDouble("Freight"));
                salesOrder.setTotalDue(result.getDouble("TotalDue"));
                salesOrder.setComment(result.getString("Comment"));
                salesOrder.setModifiedDate(result.getString("ModifiedDate"));                
                saleslist.add(salesOrder);
            }
            System.out.println(saleslist.get(1).getSalesOrderID());
            System.out.println("I am here");
            conn.close();
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        return saleslist;
    }
}
