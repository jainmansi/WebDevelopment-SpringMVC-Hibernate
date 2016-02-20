<%-- 
    Document   : UserView
    Created on : 6 Feb, 2016, 3:05:47 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Search Result</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body style="background-color: #67809F">
        <div class="container">
            <h1 style=" background-color: #fff;"><font style="color:#67809F; font-family: fantasy">&nbsp; Welcome to our movie store</font></h1>
            <br/>
            <h4><b><font style="color:#fff;" >Please make your selection below:</font></b></h4>           
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Actor</th>
                        <th>Actress</th>
                        <th>Genre</th>
                        <th>Year</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var = "movie" items="${sessionScope.movieList}">

                    <tr>
                        <td><c:out value="${movie.title}"></c:out></td>
                        <td><c:out value="${movie.actor}"></c:out></td>
                        <td><c:out value="${movie.actress}"></c:out></td>
                        <td><c:out value="${movie.genre}"></c:out></td>
                        <td><c:out value="${movie.year}"></c:out></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
            
            <font style="color:#fff"><a style="color: #fff" href="index.html">Click here to go back to the main page!</a></font>
        </div>

    </body>
</html>
