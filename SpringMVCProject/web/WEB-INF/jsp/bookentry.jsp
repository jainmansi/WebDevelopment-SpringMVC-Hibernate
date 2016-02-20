<%-- 
    Document   : bookentry
    Created on : 11 Feb, 2016, 1:26:46 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online books portal</title>
    </head>
    <body style="background-color: #95a5a6">
    <center>
        <h1><b><font style="font-family: monospace">&nbsp; Online Books Portal</font></b></h1>
        <form method="get" action="homeController.htm">
            <table style="background-color: #e6e6fa; border: 1px solid black; width: 60%">
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Authors</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="1" end="${sessionScope.number}">
                        <tr>
                            <td>
                                <div class="form-group" style="padding-top: .5em; padding-bottom: .5em">
                                    <div class='col-sm-2'>
                                        <input type='text' class='form-control' name='isbn${i}' placeholder='Enter isbn'/>
                                    </div>                        
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <div class='col-sm-2' style="padding-top: .5em; padding-bottom: .5em">
                                        <input type='text' class='form-control' name='title${i}' placeholder='Enter title'/>
                                    </div>                        
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <div class='col-sm-2' style="padding-top: .5em; padding-bottom: .5em">
                                        <input type='text' class='form-control' name='author${i}' placeholder='Enter author'/>
                                    </div>                        
                                </div>
                            </td>
                            <td>
                                <div class="form-group" style="padding-top: .5em; padding-bottom: .5em">
                                    <div class='col-sm-2'>
                                        <input type='text' class='form-control' name='price${i}' placeholder='Enter price'/>
                                    </div>                        
                                </div>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
                 <input type="hidden" name="action" value="bookDetails"/>
                <tr>
                    <td colspan="4" style="text-align: center" style="padding-top: .5em; padding-bottom: .5em">
                        <input type="submit" value="Submit" class="btn btn-default"/>
                    </td>
                </tr>
            </table>
            <br/>
            <c:set var="bookNumber" value="${sessionScope.number}"/>
        </form>
    </center>
</body>
</html>
