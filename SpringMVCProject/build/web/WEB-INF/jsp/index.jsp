<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Portal</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>

    <body style="background-color: #95a5a6">
        <div class="container">
            <h1><b><font style="font-family: monospace">&nbsp; Online Books Portal</font></b></h1>
            <br/>
            <h4><b>How many books do you want to add?</b></h4>           
            <form method="post" action="homeController.htm">
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
