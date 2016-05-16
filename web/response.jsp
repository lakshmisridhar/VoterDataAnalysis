<%-- 
    Document   : response
    Created on : Apr 13, 2016, 12:34:23 PM
    Author     : Lakshmi Sridhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Population Analysis</title>
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <div id="main">
            <center> <h1>Presidential Election Analysis of Mecklenburg County </h1> </center>
            <a href="home.jsp" id="back_to_page"> &laquo;Home Page</a> 
            <br>
            <br>
            <center>
                <img style ="float:start" src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getPopulationDistribtn">
                <img  style ="float:next"src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getEthnicityDistribtn">
                 <img style ="float:next" src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getRaceDistribtn">
                                
            </center>
        </div>
        <section class="copyright">
            &copy; All Rights Reserved
        </section>
    </body>
</html>
