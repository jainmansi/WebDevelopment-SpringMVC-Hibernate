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
            <h1 style=" background-color: #fff;"><font style="color:#67809F; font-family: fantasy">&nbsp; Search Movies</font></h1>
            <br/>

            <form role="form" action="movie.htm" method="get">
                <div class="form-group">
                    <font style="color:#fff"><label class='control-label col-sm-2' for='keyword'>Keyword:</label></font>
                    <div class='col-sm-3'>
                        <input type='text' class='form-control' name='keyword' id='keyword' placeholder='Enter keyword'/>
                    </div>                        
                </div>
                <br/><br/><br/>
                <div class='form-group'>
                    <div class='col-sm-10'>
                        <div class='radio'>
                            <font style="color:#fff">
                                <label><input type='radio' name='search' value='title'>Search By Title</label><br/>
                                <label><input type='radio' name='search' value='actor'>Search By Actor</label><br/>
                                <label><input type='radio' name='search' value='actress'>Search By Actress</label>
                            </font>
                        </div>
                    </div>
                </div>


                <input type="hidden" name="action" value="browse"/>
                <div class='form-group'>
                    <div class='col-sm-offset-2 col-sm-10'>

                        <input type="submit" value="Submit" class="btn btn-default"/>  
                    </div>
                </div>          

            </form>

        </div>
    </body>
</html>