<%-- 
    Document   : index
    Created on : 21 Feb, 2016, 10:21:17 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex" uri="/WEB-INF/tlds/display.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.flag == 1}">
                <c:remove var="flag" scope="session"/>
                <ex:csvTag>
                    
                </ex:csvTag>
            </c:when>

            <c:otherwise>
                <form method = "POST" action="homeController.htm">
                    Enter name of file: <input type="file" name="fileName" />
                    <input type="hidden" name="action" value="sentFile"/>
                    <input type="submit" value="submit" name="submit"/>
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
