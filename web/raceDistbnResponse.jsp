<%-- 
    Document   : raceDistbnResponse
    Created on : Apr 26, 2016, 11:11:05 AM
    Author     : Lakshmi Sridhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Race Distribution Analysis</title>
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
         <div id="main">
            <center> <h1>Presidential Election Analysis of Mecklenburg County </h1> </center>
            <a href="home.jsp" id="back_to_page"> &laquo;Home Page</a> 
            <center>
                <img  style ="float:start" src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getRaceDistbn2008">
                <img  style ="float:next" src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getRaceDistbn2012">
             
            </center>  
                 </div>
        <section class="copyright">
            &copy; All Rights Reserved
        </section>

    </body>
</html>
