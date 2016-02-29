<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <c:choose>
            <c:when test="${requestScope.salesOrderList != null}">
                <form method="post" action="homeController.htm">
                    <input type="submit"  />
                    <table>                
                        <th>
                        <td>SalesOrderID</td>
                        <td>RevisionNumber</td>	
                        <td>OrderDate</td>	
                        <td>DueDate</td>	
                        <td>ShipDate</td>	
                        <td>Status</td>	
                        <td>OnlineOrderFlag</td>	
                        <td>SalesOrderNumber</td>	
                        <td>PurchaseOrderNumber</td>	
                        <td>AccountNumber</td>	
                        <td>CustomerID</td>	
                        <td>SalesPersonID</td>	
                        <td>TerritoryID</td>	
                        <td>BillToAddressID</td>	
                        <td>ShipToAddressID</td>	
                        <td>ShipMethodID</td>	
                        <td>CreditCardID</td>	
                        <td>CreditCardApprovalCode</td>	
                        <td>CurrencyRateID</td>	
                        <td>SubTotal</td>	
                        <td>TaxAmt</td>	
                        <td>Freight</td>	
                        <td>TotalDue</td>	
                        <td>Comment</td>	
                        <td>ModifiedDate</td>
                        </th>

                        <c:forEach items="${requestScope.salesOrderList}" var="sales">
                            <tr>
                                <td><input type="text" name="SalesOrderID" size="6" value="${sales.salesOrderID}"/></td>
                                <td><input type="text" name="RevisionNumber" size="6" value="${sales.revisionNumber}"/></td>
                                <td><input type="text" name="OrderDate" size="6" value="${sales.orderDate}"/></td>
                                <td><input type="text" name="DueDate" size="6" value="${sales.dueDate}"/></td>	
                                <td><input type="text" name="ShipDate" size="6" value="${sales.shipDate}"/></td>	
                                <td><input type="text" name="Status" size="6" value="${sales.status}"/></td>	
                                <td><input type="text" name="OnlineOrderFlag" size="6" value="${sales.onlineOrderFlag}"/></td>	
                                <td><input type="text" name="SalesOrderNumber" size="6" value="${sales.salesOrderNumber}"/></td>	
                                <td><input type="text" name="PurchaseOrderNumber" size="6" value="${sales.purchaseOrderNumber}"/></td>	
                                <td><input type="text" name="AccountNumber" size="6" value="${sales.accountNumber}"/></td>	
                                <td><input type="text" name="CustomerID" size="6" value="${sales.customerID}"/></td>	
                                <td><input type="text" name="SalesPersonID" size="6" value="${sales.salesPersonID}"/></td>	
                                <td><input type="text" name="TerritoryID" size="6" value="${sales.territoryID}"/></td>	
                                <td><input type="text" name="BillToAddressID" size="6" value="${sales.billToAddressID}"/></td>	
                                <td><input type="text" name="ShipToAddressID" size="6" value="${sales.shipToAddressID}"/></td>	
                                <td><input type="text" name="ShipMethodID" size="6" value="${sales.shipMethodID}"/></td>	
                                <td><input type="text" name="CreditCardID" size="6" value="${sales.creditCardID}"/></td>	
                                <td><input type="text" name="CreditCardApprovalCode" size="6" value="${sales.creditCardApprovalCode}"/></td>	
                                <td><input type="text" name="CurrencyRateID" size="6" value="${sales.currencyRateID}"/></td>	
                                <td><input type="text" name="SubTotal" size="6" value="${sales.subTotal}"/></td>	
                                <td><input type="text" name="TaxAmt" size="6" value="${sales.taxAmt}"/></td>	
                                <td><input type="text" name="Freight" size="6" value="${sales.freight}"/></td>	
                                <td><input type="text" name="TotalDue" size="6" value="${sales.totalDue}"/></td>	
                                <td><input type="text" name="Comment" size="6" value="${sales.comment}"/></td>	
                                <td><input type="text" name="ModifiedDate" size="6" value="${sales.modifiedDate}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="hidden" name="action" value="batchInsert"/>
                </form>
            </c:when>

            <c:otherwise>
                <form method = "POST" action="homeController.htm">
                    Enter name of file: <input type="text" name="fileName" />
                    <input type="hidden" name="action" value="sentFile"/>
                    <input type="submit" value="submit" name="submit"/>
                </form>

            </c:otherwise>
        </c:choose>
    </body>
</html>
