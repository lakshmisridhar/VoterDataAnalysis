/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.controller;

import com.voterData.db.ElectionsVotedDB;
import com.voterData.db.VoterDetailsDB;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lakshmi Sridhar
 */
@WebServlet(name = "VoterDataController", urlPatterns = {"/VoterDataController"})
public class VoterDataController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String url = "/home.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            url = "/home.jsp";  // default action
        } else {
            switch (action) {
                case "countofVoterDetails":
                    int countofVoters = VoterDetailsDB.getVoterDetailsCount();
                    request.setAttribute("countofVoters", countofVoters);
                    url = "/home.jsp";
                    break;
                case "populationDistribtn":
                    url = "/response.jsp";
                    break;
                case "genderDistribtn":
                    url = "/genderDistbnResponse.jsp";
                    break;
                case "ageDistribtn":
                    url = "/ageDistbnResponse.jsp";
                    break;
                case "ethnicityDistribtn":
                    Map<String, Double> chartMap4 = ElectionsVotedDB.getEthnicityDistbn();
                    session.setAttribute("ethnicityMap", chartMap4);
                    url = "/ethicityDistbnResponse.jsp";
                    break;

                case "raceDistribtn":
                    Map<String, Double> chartMap5 = ElectionsVotedDB.getRaceDistbn();
                    session.setAttribute("raceMap", chartMap5);
                    url = "/raceDistbnResponse.jsp";
                    break;

            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

}
