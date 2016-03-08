/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.CustomTag;

import com.me.DAO.CsvDao;
import com.me.pojo.SalesOrder;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author user
 */
public class CsvTag extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            CsvDao csvdao = new CsvDao();

            ArrayList<SalesOrder> salesList = csvdao.connect();

            out.println("<form method='post' action='homeController.htm'>");
            out.println("<input type='submit' value='submit' />");
            out.println("<table>");
            out.println("<th>");
            out.println("<td>SalesOrderID</td>");
            out.println("<td>RevisionNumber</td>");
            out.println("<td>OrderDate</td>");
            out.println("<td>DueDate</td>");
            out.println("<td>ShipDate</td>");
            out.println("<td>Status</td>");
            out.println("<td>OnlineOrderFlag</td>");
            out.println("<td>SalesOrderNumber</td>");
            out.println("<td>PurchaseOrderNumber</td>");
            out.println("<td>AccountNumber</td>");
            out.println("<td>CustomerID</td>");
            out.println("<td>SalesPersonID</td>");
            out.println("<td>TerritoryID</td>");
            out.println("<td>BillToAddressID</td>");
            out.println("<td>ShipToAddressID</td>");
            out.println("<td>ShipMethodID</td>");
            out.println("<td>CreditCardID</td>");
            out.println("<td>CreditCardApprovalCode</td>");
            out.println("<td>CurrencyRateID</td>");
            out.println("<td>SubTotal</td>");
            out.println("<td>TaxAmt</td>");
            out.println("<td>Freight</td>");
            out.println("<td>TotalDue</td>");
            out.println("<td>Comment</td>");
            out.println("<td>ModifiedDate</td>");
            out.println("</th>");

            for (SalesOrder so : salesList) {
                out.println("<tr>");
                out.println("<td><input type='text' name='SalesOrderID' size='6' value=" + so.getSalesOrderNumber() + "></td>");
                out.println("<td><input type='text' name='RevisionNumber' size='6' value=" + so.getRevisionNumber() + "></td>");
                out.println("<td><input type='text' name='OrderDate' size='6' value=" + so.getOrderDate() + "></td>");
                out.println("<td><input type='text' name='DueDate' size='6' value=" + so.getDueDate() + "></td>	");
                out.println("<td><input type='text' name='ShipDate' size='6' value=" + so.getShipDate() + "></td>	");
                out.println("<td><input type='text' name='Status' size='6' value=" + so.getStatus() + "></td>	");
                out.println("<td><input type='text' name='OnlineOrderFlag' size='6' value=" + so.getOnlineOrderFlag() + "></td>");
                out.println("<td><input type='text' name='SalesOrderNumber' size='6' value=" + so.getSalesOrderNumber() + "></td>");
                out.println("<td><input type='text' name='PurchaseOrderNumber' size='6' value=" + so.getPurchaseOrderNumber() + "></td>	");
                out.println("<td><input type='text' name='AccountNumber' size='6' value=" + so.getAccountNumber() + "></td>	");
                out.println("<td><input type='text' name='CustomerID' size='6' value=" + so.getCustomerID() + "></td>	");
                out.println("<td><input type='text' name='SalesPersonID' size='6' value=" + so.getSalesPersonID() + "></td>	");
                out.println("<td><input type='text' name='TerritoryID' size='6' value=" + so.getTerritoryID() + "></td>	");
                out.println("<td><input type='text' name='BillToAddressID' size='6' value=" + so.getBillToAddressID() + "></td>");
                out.println("<td><input type='text' name='ShipToAddressID' size='6' value=" + so.getShipToAddressID() + "></td>");
                out.println("<td><input type='text' name='ShipMethodID' size='6' value=" + so.getShipMethodID() + "></td>	");
                out.println("<td><input type='text' name='CreditCardID' size='6' value=" + so.getCreditCardID() + "></td>	");
                out.println("<td><input type='text' name='CreditCardApprovalCode' size='6' value=" + so.getCreditCardApprovalCode() + "></td>");
                out.println("<td><input type='text' name='CurrencyRateID' size='6' value=" + so.getCurrencyRateID() + "></td>	");
                out.println("<td><input type='text' name='SubTotal' size='6' value=" + so.getSubTotal() + "></td>	");
                out.println("<td><input type='text' name='TaxAmt' size='6' value=" + so.getTaxAmt() + "></td>	");
                out.println("<td><input type='text' name='Freight' size='6' value=" + so.getFreight() + "></td>	");
                out.println("<td><input type='text' name='TotalDue' size='6' value=" + so.getTotalDue() + "></td>	");
                out.println("<td><input type='text' name='Comment' size='6' value=" + so.getComment() + "></td>	");
                out.println("<td><input type='text' name='ModifiedDate' size='6' value=" + so.getModifiedDate() + "></td>");
                out.println("</tr>");
            }
                out.println("</table>");
                out.println("<input type='hidden' name='action' value='batchInsert'/>");
                out.println("</form>");
            }
         catch (java.io.IOException ex) {
            throw new JspException("Error in NewTagHandler tag", ex);
        }
    
    }
}
