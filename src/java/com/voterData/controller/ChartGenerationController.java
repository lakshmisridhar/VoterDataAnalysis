/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.controller;

import com.voterData.db.ElectionsVotedDB;
import com.voterData.db.VoterDetailsDB;
import com.voterData.graph.Graph;
import com.voterData.model.VoterDetails;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Lakshmi Sridhar
 */
@WebServlet(name = "ChartGenerationController", urlPatterns = {"/ChartGenerationController"})
public class ChartGenerationController extends HttpServlet {

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
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        int width = 700;
        int height = 700;

        int width2 = 500;
        int height2 = 500;
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            url = "/home.jsp";  // default action
        } else {
            switch (action) {
                case "getPopulationDistribtn":
                    ArrayList<VoterDetails> voterDetList = new ArrayList<VoterDetails>();
                    voterDetList = VoterDetailsDB.getPopulationDist();
                    JFreeChart chart = Graph.getPopulationDistChart(voterDetList);

                    ChartUtilities.writeChartAsPNG(outputStream, chart, width2, height2);
                    break;

                case "getEthnicityDistribtn":
                    ArrayList<VoterDetails> voterDetList2 = new ArrayList<VoterDetails>();
                    voterDetList2 = VoterDetailsDB.getEthnicityDist();
                    for (VoterDetails voterDetObj : voterDetList2) {
                        System.out.println(voterDetObj.getEthnic_code() + " - " + Double.parseDouble(voterDetObj.getVoter_reg_num()));
                    }

                    JFreeChart chart2 = Graph.getEthnicityDistChart(voterDetList2);
                    ChartUtilities.writeChartAsPNG(outputStream, chart2, width2, height2);
                    break;

                case "getRaceDistribtn":
                    ArrayList<VoterDetails> voterDetList3 = new ArrayList<VoterDetails>();
                    voterDetList3 = VoterDetailsDB.getRaceDist();
                    JFreeChart chart3 = Graph.getRaceDistChart(voterDetList3);
                    ChartUtilities.writeChartAsPNG(outputStream, chart3, width2, height2);
                    break;

                case "getGenderDistribtn":

                    Map<String, Double> chartData = ElectionsVotedDB.getGenderDistbn();
                    JFreeChart genderDistChart = Graph.getGenderDistChart(chartData);
                    ChartUtilities.writeChartAsPNG(outputStream, genderDistChart, width, height);
                    break;

                case "getAgeDistribtn2008":

                    Map<String, Double> chartMap = ElectionsVotedDB.getAgeDistbn2008();
                    JFreeChart ageDistChart2008 = Graph.getAgeDistChart2008(chartMap);
                    ChartUtilities.writeChartAsPNG(outputStream, ageDistChart2008, width, height);
                    break;

                case "getAgeDistribtn2012":

                    Map<String, Double> chartMap2 = ElectionsVotedDB.getAgeDistbn2012();
                    JFreeChart ageDistChart2012 = Graph.getAgeDistChart2012(chartMap2);
                    ChartUtilities.writeChartAsPNG(outputStream, ageDistChart2012, width, height);
                    break;

                case "getEthnicityDistbn":
                    Map<String, Double> chartMap4 = (Map<String, Double>) session.getAttribute("ethnicityMap");
                    JFreeChart ethnicityChart = Graph.getEthnicityDistbn(chartMap4);
                    ChartUtilities.writeChartAsPNG(outputStream, ethnicityChart, width, height);
                    break;

                case "getHLEthnicityDistbn":
                    Map<String, Double> charMap5 = (Map<String, Double>) session.getAttribute("ethnicityMap");
                    JFreeChart hlethnicityChart = Graph.getHLEthnicityDistbn(charMap5);
                    ChartUtilities.writeChartAsPNG(outputStream, hlethnicityChart, width, height);
                    break;

                case "getRaceDistbn2008":
                    Map<String, Double> chartMap5 = (Map<String, Double>) session.getAttribute("raceMap");
                    JFreeChart raceChart2008 = Graph.getRaceDistbn2008(chartMap5);
                    ChartUtilities.writeChartAsPNG(outputStream, raceChart2008, width, height);
                    break;

                case "getRaceDistbn2012":
                    Map<String, Double> charMap6 = (Map<String, Double>) session.getAttribute("raceMap");
                    JFreeChart raceChart2012 = Graph.getRaceDistbn2012(charMap6);
                    ChartUtilities.writeChartAsPNG(outputStream, raceChart2012, width, height);
                    break;
            }
        }

    }

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

}
