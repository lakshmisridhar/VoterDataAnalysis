// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.   
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html   
// Decompiler options: packimports(3) fieldsfirst ansi    
   
package com.voterData.graph;   
   
import java.awt.Color;   
import java.awt.Dimension;   
import javax.swing.JPanel;   
import org.jfree.chart.*;   
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;   
import org.jfree.chart.plot.CategoryPlot;   
import org.jfree.chart.plot.PlotOrientation;   
import org.jfree.chart.renderer.category.StackedBarRenderer;   
import org.jfree.data.category.CategoryDataset;   
import org.jfree.data.category.DefaultCategoryDataset;   
import org.jfree.ui.ApplicationFrame;   
import org.jfree.ui.RefineryUtilities;   
   
public class test extends ApplicationFrame   
{   
   
    /**  
     *   
     */   
    private static final long serialVersionUID = 1L;   
   
    public test(String s)   
    {   
        super(s);   
        JPanel jpanel = createDemoPanel();   
        jpanel.setPreferredSize(new Dimension(500, 270));   
        setContentPane(jpanel);   
    }   
   
    private static CategoryDataset createDataset()   
    {   
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();   
        defaultcategorydataset.addValue(32.399999999999999D, "REP", "Male_2008");   
        defaultcategorydataset.addValue(17.800000000000001D, "DEM", "Male_2008");   
        defaultcategorydataset.addValue(27.699999999999999D, "UNA", "Male_2008");   
        defaultcategorydataset.addValue(43.200000000000003D, "REP", "Male_2012");   
        defaultcategorydataset.addValue(15.6D, "DEM", "Male_2012");   
        defaultcategorydataset.addValue(18.300000000000001D, "UNA", "Male_2012");   
        defaultcategorydataset.addValue(23D, "REP", "Female_2008");   
        defaultcategorydataset.addValue(11.300000000000001D, "DEM", "Female_2008");   
        defaultcategorydataset.addValue(25.5D, "UNA", "Female_2008");   
        defaultcategorydataset.addValue(13D, "REP", "Female_2012");   
        defaultcategorydataset.addValue(11.800000000000001D, "DEM", "Female_2012");   
        defaultcategorydataset.addValue(29.5D, "UNA", "Female_2012");   
        return defaultcategorydataset;   
    }   
   
    private static JFreeChart createChart(CategoryDataset categorydataset)   
    {   
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Gender based DIstribution", "Gender_Year", "Total Count", categorydataset, PlotOrientation.VERTICAL, true, true, false);   
        jfreechart.setBackgroundPaint(Color.white);   
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();   
        categoryplot.setBackgroundPaint(Color.lightGray);   
        categoryplot.setRangeGridlinePaint(Color.white);   
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)categoryplot.getRenderer();   
        stackedbarrenderer.setDrawBarOutline(false);   
        stackedbarrenderer.setItemLabelsVisible(true);   
        stackedbarrenderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());   
        return jfreechart;   
    }   
   
    public static JPanel createDemoPanel()   
    {   
        JFreeChart jfreechart = createChart(createDataset());   
        return new ChartPanel(jfreechart);   
    }   
   
    public static void main(String args[])   
    {   
        test stackedbarchartdemo1 = new test("Gender based distribution");   
        stackedbarchartdemo1.pack();   
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo1);   
        stackedbarchartdemo1.setVisible(true);   
    }   
}   
