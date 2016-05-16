<%-- 
    Document   : home
    Created on : Apr 10, 2016, 6:21:54 PM
    Author     : Lakshmi Sridhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mecklenburg County Election Analysis</title>
        <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <div id="main">
           <center> <h1>Presidential Election Analysis of Mecklenburg County </h1>
               <h2>  Year 2008 and 2012</h2>     
                <br>
                <br>
           </center>
                <img id= "img1"src ="images/ad_pic.jpeg" height="300" width="500" alt ="left pic">
                <img id= "img2"src ="images/ad_pic3.jpg" height="300" width="500" alt ="right pic">
               <form action="VoterDataController" method="post">
                    <input type="hidden" name="action" value="populationDistribtn">
                   &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<button class="button button1" type="submit" >Population Analysis</button>
                    <br>
                </form>
                
                <br>
                <br>
                <br>
                <form action="VoterDataController" method="post">
                    <input type="hidden" name="action" value="ageDistribtn">
                    &emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <button class="button button1" type="submit" >Age Based Analysis</button>
                    <br>
                </form>
                <br>
                <br>
                <br>
                <center>
                <form action="VoterDataController" method="post">
                    <input type="hidden" name="action" value="genderDistribtn">
                  <button class="button button1" type="submit" > Gender Based Analysis </button>
                    <br>
                </form>
                <br>
                <br>
                <br>
              
                <form action="VoterDataController" method="post">
                    <input type="hidden" name="action" value="raceDistribtn">
                    <button class="button button1" type="submit" >Race Based Analysis</button>
                    <br>
                </form>
                <br>
                <br>
                <br>
                <form action="VoterDataController" method="post">
                    <input type="hidden" name="action" value="ethnicityDistribtn">
                    <button class="button button1" type="submit" >Ethnicity Based Analysis</button>
                    <br>
                </form>
                <br>
                <br>
                <br>
                
                
                <p>${countofVoters}</p>
                
                <section class="copyright">
                    &copy; All Rights Reserved
                </section>
               </center>
        </div>
    </body>
</html>
