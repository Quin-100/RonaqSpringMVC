<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="../fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->    
    <!--  --><link rel="stylesheet" href="../styles/register.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/> 

    <script>
        $(document).ready(function(){
            $( "#dob" ).datepicker({
                dateFormat : 'mm/dd/yy',
                changeMonth : true,
                changeYear : true,
                yearRange: '-100y:c+nn',
                maxDate: '-1d'
            });
        });
        </script>
</head>
<body>

    <div class="main">

        <section class="signup">
            <!-- <img src="images/image2.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">Create account</h2>
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="name" id="name" placeholder="Your Name"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="pan" id="pan" placeholder="Pan card no."/>
                                </div>
                            </div>
                        </div> 
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="aadhar" id="aadhar" placeholder="Aadhar no."/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="date" class="form-input" name="dob" id="dob" placeholder="Age"/>
                                </div>
                                <!-- <div class="form-group"> Date input
                                    <label class="control-label" for="date">Date</label>
                                    <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
                                </div> -->
                                
                                <!-- <div class='col-sm-6'>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker1'>
                                            <input type='text' class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    $(function () {
                                        $('#datetimepicker1').datetimepicker();
                                    });
                                </script> -->
                            </div>
                        </div>  
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="address" id="address" placeholder="Address Details"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="branch" id="branch" placeholder="Branch"/>
                                </div>
                            </div>
                        </div> 
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="state" id="state" placeholder="State"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="accType" id="accType" placeholder="Account Type"/>
                                </div>
                            </div>
                        </div> 
                        <div class="row">                        
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-input" name="password" id="password" placeholder="Password"/>
                                    <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password"/>
                                </div>
                            </div>
                        </div>     
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="#" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>