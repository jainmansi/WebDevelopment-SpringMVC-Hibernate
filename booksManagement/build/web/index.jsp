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
    <body style="background-color: #95a5a6">
        <div class="container">
            <h1><b><font style="font-family: monospace">&nbsp; Online Books Portal</font></b></h1>
            <br/>
            <h4><b>How many books do you want to add?</b></h4>           
            <form method="post" action="registerbook.htm">
                <div class="form-group">
                    <div class='col-sm-3' style="text-align: center">
                        <input type='text' class='form-control' name='number' id='number' placeholder='Enter a number'/>
                    </div>                        
                </div>
                
                        <input type="hidden" name="action" value="numberEntered"/>
                        <input type="submit" value="Submit" class="btn btn-default"/>
               
            </form>
        </div>

    </body>
</html>

