/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.graph;

import com.voterData.model.VoterDetails;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Lakshmi Sridhar
 */
public class Graph {

    public static JFreeChart getPopulationDistChart(ArrayList<VoterDetails> voterDetList) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (VoterDetails voterDetObj : voterDetList) {
            dataset.setValue(voterDetObj.getRes_city_desc(), Double.parseDouble(voterDetObj.getVoter_reg_num()));
        }
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createPieChart("Population Distribution of Mecklenburg County", dataset, legend, tooltips, urls);

        //chart.setBorderPaint(Color.GREEN);
        //chart.setBorderStroke(new BasicStroke(5.0f));
        //chart.setBorderVisible(true); 
               /* DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
         for(VoterDetails voterDetObj : voterDetList){
         bardataset.setValue(Double.parseDouble(voterDetObj.getVoter_reg_num()), "Population(%)", voterDetObj.getRes_city_desc());
         }
     
         JFreeChart barchart = ChartFactory.createBarChart3D(  
         "Population-Cities",      //Title  
         "Cities in Mecklenburg County",             // X-axis Label  
         "Population(%)",               // Y-axis Label  
         bardataset,             // Dataset  
         PlotOrientation.VERTICAL,      //Plot orientation  
         false,                // Show legend  
         true,                // Use tooltips  
         false                // Generate URLs  
         );  */
        return chart;

    }

    public static JFreeChart getEthnicityDistChart(ArrayList<VoterDetails> voterDetList) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (VoterDetails voterDetObj : voterDetList) {
            dataset.setValue(voterDetObj.getEthnic_code(), Double.parseDouble(voterDetObj.getVoter_reg_num()));
        }
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createPieChart("Ethnicity Distribution of Mecklenburg County", dataset, legend, tooltips, urls);

        //chart.setBorderPaint(Color.GREEN);
        //chart.setBorderStroke(new BasicStroke(5.0f));
        //chart.setBorderVisible(true); 
        return chart;

    }

    public static JFreeChart getRaceDistChart(ArrayList<VoterDetails> voterDetList) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (VoterDetails voterDetObj : voterDetList) {
            dataset.setValue(voterDetObj.getRace_code(), Double.parseDouble(voterDetObj.getVoter_reg_num()));
        }
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createPieChart("Race Distribution of Mecklenburg County", dataset, legend, tooltips, urls);

        //chart.setBorderPaint(Color.GREEN);
        //chart.setBorderStroke(new BasicStroke(5.0f));
        //chart.setBorderVisible(true); 
        return chart;

    }

    public static JFreeChart getGenderDistChart(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("Male_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "Male_2008");
            } else if (key.equals("Male_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "Male_2008");
            } else if (key.equals("Male_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "Male_2008");
            } else if (key.equals("Female_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "Female_2008");
            } else if (key.equals("Female_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "Female_2008");
            } else if (key.equals("Female_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "Female_2008");
            } else if (key.equals("Male_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "Male_2012");
            } else if (key.equals("Male_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "Male_2012");
            } else if (key.equals("Male_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "Male_2012");
            } else if (key.equals("Female_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "Female_2012");
            } else if (key.equals("Female_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "Female_2012");
            } else if (key.equals("Female_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "Female_2012");
            }
        }
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Gender based Distribution", "Gender_Year", "% of Votes", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer) categoryplot.getRenderer();
        stackedbarrenderer.setDrawBarOutline(false);
        stackedbarrenderer.setItemLabelsVisible(true);
        stackedbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        stackedbarrenderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        stackedbarrenderer.setSeriesPaint(0, Color.blue);
        stackedbarrenderer.setSeriesPaint(1, Color.red);
        stackedbarrenderer.setSeriesPaint(2, Color.green);
        return jfreechart;

    }

    public static JFreeChart getAgeDistChart2008(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("Age17_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "17-25 Yrs");
            } else if (key.equals("Age17_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "17-25 Yrs");
            } else if (key.equals("Age17_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "17-25 Yrs");
            } else if (key.equals("Age26_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "26-35 Yrs");
            } else if (key.equals("Age26_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "26-35 Yrs");
            } else if (key.equals("Age26_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "26-35 Yrs");
            } else if (key.equals("Age36_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "36-50 Yrs");
            } else if (key.equals("Age36_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "36-50 Yrs");
            } else if (key.equals("Age36_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "36-50 Yrs");
            } else if (key.equals("Age51_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "51-65 Yrs");
            } else if (key.equals("Age51_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "51-65 Yrs");
            } else if (key.equals("Age51_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "51-65 Yrs");
            } else if (key.equals("Age65_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", ">65 Yrs");
            } else if (key.equals("Age65_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", ">65 Yrs");
            } else if (key.equals("Age65_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", ">65 Yrs");
            }
        }
        JFreeChart jfreechart = ChartFactory.createBarChart("Age based Distribution - Year 2008", "Age in Years", " Votes in %", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot cplot = (CategoryPlot) jfreechart.getPlot();
        cplot.setBackgroundPaint(Color.lightGray);//change background color
        //set  bar chart color
        // ((BarRenderer) cplot.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer r = (BarRenderer) jfreechart.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, Color.green);
        r.setSeriesPaint(1, Color.red);
        r.setSeriesPaint(2, Color.blue);
        return jfreechart;

    }

    public static JFreeChart getAgeDistChart2012(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("Age17_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "17-25 Yrs");
            } else if (key.equals("Age17_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "17-25 Yrs");
            } else if (key.equals("Age17_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "17-25 Yrs");
            } else if (key.equals("Age26_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "26-35 Yrs");
            } else if (key.equals("Age26_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "26-35 Yrs");
            } else if (key.equals("Age26_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "26-35 Yrs");
            } else if (key.equals("Age36_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "36-50 Yrs");
            } else if (key.equals("Age36_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "36-50 Yrs");
            } else if (key.equals("Age36_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "36-50 Yrs");
            } else if (key.equals("Age51_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "51-65 Yrs");
            } else if (key.equals("Age51_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "51-65 Yrs");
            } else if (key.equals("Age51_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "51-65 Yrs");
            } else if (key.equals("Age65_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", ">65 Yrs");
            } else if (key.equals("Age65_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", ">65 Yrs");
            } else if (key.equals("Age65_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", ">65 Yrs");
            }
        }
        JFreeChart jfreechart = ChartFactory.createBarChart("Age based Distribution - Year 2012", "Age in Years", " Votes in %", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot cplot = (CategoryPlot) jfreechart.getPlot();
        cplot.setBackgroundPaint(Color.lightGray);//change background color
        //set  bar chart color
        // ((BarRenderer) cplot.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer r = (BarRenderer) jfreechart.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, Color.blue);
        r.setSeriesPaint(1, Color.green);
        r.setSeriesPaint(2, Color.red);
        return jfreechart;

    }

    public static JFreeChart getEthnicityDistbn(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("HL_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "HL_2008");
            } else if (key.equals("HL_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "HL_2008");
            } else if (key.equals("HL_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "HL_2008");
            } else if (key.equals("NL_Dem_2008")) {
             defaultcategorydataset.addValue(dataMap.get(key), "DEM", "NL_2008");
             } else if (key.equals("NL_Rep_2008")) {
             defaultcategorydataset.addValue(dataMap.get(key), "REP", "NL_2008");
             } else if (key.equals("NL_Una_2008")) {
             defaultcategorydataset.addValue(dataMap.get(key), "UNA", "NL_2008");
             } else if (key.equals("UN_Dem_2008")) {
             defaultcategorydataset.addValue(dataMap.get(key), "DEM", "UN_2008");
             } else if (key.equals("UN_Rep_2008")) {
             defaultcategorydataset.addValue(dataMap.get(key), "REP", "UN_2008");
             } else if (key.equals("UN_Una_2008")) {
             defaultcategorydataset.addValue(dataMap.get(key), "UNA", "UN_2008");
             }  else if (key.equals("HL_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "HL_2012");
            } else if (key.equals("HL_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "HL_2012");
            } else if (key.equals("HL_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "HL_2012");
            } else if (key.equals("NL_Dem_2012")) {
             defaultcategorydataset.addValue(dataMap.get(key), "DEM", "NL_2012");
             } else if (key.equals("NL_Rep_2012")) {
             defaultcategorydataset.addValue(dataMap.get(key), "REP", "NL_2012");
             } else if (key.equals("NL_Una_2012")) {
             defaultcategorydataset.addValue(dataMap.get(key), "UNA", "NL_2012");
             } else if (key.equals("UN_Dem_2012")) {
             defaultcategorydataset.addValue(dataMap.get(key), "DEM", "UN_2012");
             } else if (key.equals("UN_Rep_2012")) {
             defaultcategorydataset.addValue(dataMap.get(key), "REP", "UN_2012");
             } else if (key.equals("UN_Una_2012")) {
             defaultcategorydataset.addValue(dataMap.get(key), "UNA", "UN_2012");
             } 

        }

        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Ethnicity based Distribution", "Ethnicity_Year", "Total Count", defaultcategorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        StackedBarRenderer renderer = (StackedBarRenderer) categoryplot.getRenderer();

        renderer.setDrawBarOutline(false);
        renderer.setSeriesPaint(0, Color.green);
        renderer.setSeriesPaint(1, Color.blue);
        renderer.setSeriesPaint(2, Color.red);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        categoryplot.setRenderer(renderer);

        return jfreechart;

    }
    public static JFreeChart getHLEthnicityDistbn(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("HL_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "HL_2008");
            } else if (key.equals("HL_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "HL_2008");
            } else if (key.equals("HL_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "HL_2008");
            }  else if (key.equals("HL_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "DEM", "HL_2012");
            } else if (key.equals("HL_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "REP", "HL_2012");
            } else if (key.equals("HL_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "UNA", "HL_2012");
            }
        }

        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Hispanic/Latino Distribution", "Ethnicity_Year", "Total Count", defaultcategorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        StackedBarRenderer renderer = (StackedBarRenderer) categoryplot.getRenderer();

        renderer.setDrawBarOutline(false);
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);
        renderer.setSeriesPaint(2, Color.green);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        categoryplot.setRenderer(renderer);

        return jfreechart;

    }
    
    public static JFreeChart getRaceDistbn2008(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("A_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Asian", "REP");
            } else if (key.equals("B_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "African American/Black", "REP");
            } else if (key.equals("I_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "American Indian/Alaska Native", "REP");
            }  else if (key.equals("O_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Other", "REP");
            } else if (key.equals("M_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Multiracial", "REP");
            } else if (key.equals("U_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Undefined", "REP");
            }else if (key.equals("W_Rep_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "White", "REP");
            } else  if (key.equals("A_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Asian", "DEM");
            } else if (key.equals("B_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "African American/Black", "DEM");
            } else if (key.equals("I_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "American Indian/Alaska Native", "DEM");
            }  else if (key.equals("O_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Other", "DEM");
            } else if (key.equals("M_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Multiracial", "DEM");
            } else if (key.equals("U_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Undefined", "DEM");
            }else if (key.equals("W_Dem_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "White", "DEM");
            } else  if (key.equals("A_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Asian", "UNA");
            } else if (key.equals("B_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "African American/Black", "UNA");
            } else if (key.equals("I_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "American Indian/Alaska Native", "UNA");
            }  else if (key.equals("O_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Other", "UNA");
            } else if (key.equals("M_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Multiracial", "UNA");
            } else if (key.equals("U_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Undefined", "UNA");
            }else if (key.equals("W_Una_2008")) {
                defaultcategorydataset.addValue(dataMap.get(key), "White", "UNA");
            }
        }

        JFreeChart jfreechart = ChartFactory.createBarChart("Race Distribution - 2008", "Party", "% of votes", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        BarRenderer renderer = (BarRenderer) categoryplot.getRenderer();

        renderer.setDrawBarOutline(false);
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.MAGENTA);
        renderer.setSeriesPaint(2, Color.PINK);
        renderer.setSeriesPaint(3, Color.YELLOW);
        renderer.setSeriesPaint(4, Color.cyan);
        renderer.setSeriesPaint(5, Color.RED);
        renderer.setSeriesPaint(6, Color.green);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        categoryplot.setRenderer(renderer);

        return jfreechart;

    }
    public static JFreeChart getRaceDistbn2012(Map<String, Double> dataMap) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (String key : dataMap.keySet()) {
            if (key.equals("A_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Asian", "REP");
            } else if (key.equals("B_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "African American/Black", "REP");
            } else if (key.equals("I_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "American Indian/Alaska Native", "REP");
            }  else if (key.equals("O_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Other", "REP");
            } else if (key.equals("M_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Multiracial", "REP");
            } else if (key.equals("U_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Undefined", "REP");
            }else if (key.equals("W_Rep_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "White", "REP");
            } else  if (key.equals("A_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Asian", "DEM");
            } else if (key.equals("B_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "African American/Black", "DEM");
            } else if (key.equals("I_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "American Indian/Alaska Native", "DEM");
            }  else if (key.equals("O_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Other", "DEM");
            } else if (key.equals("M_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Multiracial", "DEM");
            } else if (key.equals("U_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Undefined", "DEM");
            }else if (key.equals("W_Dem_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "White", "DEM");
            } else  if (key.equals("A_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Asian", "UNA");
            } else if (key.equals("B_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "African American/Black", "UNA");
            } else if (key.equals("I_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "American Indian/Alaska Native", "UNA");
            }  else if (key.equals("O_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Other", "UNA");
            } else if (key.equals("M_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Multiracial", "UNA");
            } else if (key.equals("U_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "Undefined", "UNA");
            }else if (key.equals("W_Una_2012")) {
                defaultcategorydataset.addValue(dataMap.get(key), "White", "UNA");
            }
        }

        JFreeChart jfreechart = ChartFactory.createBarChart("Race Distribution - 2012", "Party", "% of votes", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        BarRenderer renderer = (BarRenderer) categoryplot.getRenderer();

        renderer.setDrawBarOutline(false);
        renderer.setSeriesPaint(0, Color.cyan);
        renderer.setSeriesPaint(1, Color.pink);
        renderer.setSeriesPaint(2, Color.red);
        renderer.setSeriesPaint(3, Color.orange);
        renderer.setSeriesPaint(4, Color.green);
        renderer.setSeriesPaint(5, Color.yellow);
        renderer.setSeriesPaint(6, Color.magenta);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        categoryplot.setRenderer(renderer);

        return jfreechart;

    }
}
