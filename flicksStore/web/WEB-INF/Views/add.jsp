<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Online Movie Store</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


    </head>

    <body style="background-color: #67809F">
        <div class="container">
            <h1 style=" background-color: #fff;"><font style="color:#67809F; font-family: fantasy">&nbsp; Add New Movies To The Portal</font></h1>
            <br/>
            <h4><b><font style="color:#fff;" >Please enter the details below:</font></b></h4>
            <br/>
            <form role="form" action="movie.htm" method="get">
                <div class="form-group">
                    <font style="color:#fff"><label class='control-label col-sm-2' for='title'>Movie Title:</label></font>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' name='title' id='title' placeholder='Enter movie title'/>
                    </div>                        
                </div>
                <br/><br/><br/>
                <div class="form-group">
                    <font style="color:#fff"><label class='control-label col-sm-2' for='actor'>Lead Actor:</label></font>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' name='actor' id='actor' placeholder='Enter name of lead actor'/>
                    </div>                        
                </div>
                <br/><br/>
                <div class="form-group">
                    <font style="color:#fff"><label class='control-label col-sm-2' for='actress'>Lead Actress:</label></font>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' name='actress' id='actress' placeholder='Enter name of lead actress'/>
                    </div>                        
                </div>
                <br/><br/>
                <div class="form-group">
                    <font style="color:#fff"><label class='control-label col-sm-2' for='genre'>Genre:</label></font>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' name='genre' id='genre' placeholder='Enter genre of the movie'/>
                    </div>                        
                </div>
                <br/><br/>
                <div class="form-group">
                    <font style="color:#fff"><label class='control-label col-sm-2' for='year'>Year:</label></font>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' name='year' id='year' placeholder='Enter year in which movie was released'/>
                    </div>                        
                </div>
                <br/><br/><br/>

                <input type="hidden" name="action" value="addNew"/>
                <div class="form-group">
                    <label class='control-label col-sm-3' for='submit'></label>

                    <input type="submit" value="Submit" class="btn btn-default"/>                        
                </div>                        



            </form>

        </div>
    </body>
</html>