<%-- 
    Document   : ethnicityDistribtn
    Created on : Apr 23, 2016, 11:58:03 PM
    Author     : Lakshmi Sridhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ethnicity Based Analysis</title>
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <div id="main">
            <center> <h1>Presidential Election Analysis of Mecklenburg County </h1> </center>
            <a href="home.jsp" id="back_to_page"> &laquo;Home Page</a> 
            <center>
                <img  style ="float:start" src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getEthnicityDistbn">
                <img  style ="float:next" src="http://localhost:8080/VoterDataWebApp/ChartGenerationController?action=getHLEthnicityDistbn">
                
                
            </center>  
                 </div>
        <section class="copyright">
            &copy; All Rights Reserved
        </section>
    </body>
</html>
