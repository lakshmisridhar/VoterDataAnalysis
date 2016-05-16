/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lakshmi Sridhar
 */
public class ElectionsVotedDB {

    public static Map<String, Double> getGenderDistbn() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement callableStatement = null;
        Map<String, Double> countData = new HashMap<String, Double>();
        String query = "{CALL getGenderDistbnCounts(?,?,?,?,?,?,?,?,?,?,?,?)} ";
        try {
            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(2, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(4, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(5, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(6, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(7, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(8, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(9, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(10, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(11, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(12, java.sql.Types.DOUBLE);

            // execute getDBUSERByUserId store procedure
            callableStatement.executeUpdate();
            countData.put("Male_Rep_2008", Double.parseDouble(callableStatement.getString(1)));
            countData.put("Male_Dem_2008", Double.parseDouble(callableStatement.getString(2)));
            countData.put("Male_Una_2008", Double.parseDouble(callableStatement.getString(3)));
            countData.put("Female_Rep_2008", Double.parseDouble(callableStatement.getString(4)));
            countData.put("Female_Dem_2008", Double.parseDouble(callableStatement.getString(5)));
            countData.put("Female_Una_2008", Double.parseDouble(callableStatement.getString(6)));
            countData.put("Male_Rep_2012", Double.parseDouble(callableStatement.getString(7)));
            countData.put("Male_Dem_2012", Double.parseDouble(callableStatement.getString(8)));
            countData.put("Male_Una_2012", Double.parseDouble(callableStatement.getString(9)));
            countData.put("Female_Rep_2012", Double.parseDouble(callableStatement.getString(10)));
            countData.put("Female_Dem_2012", Double.parseDouble(callableStatement.getString(11)));
            countData.put("Female_Una_2012", Double.parseDouble(callableStatement.getString(12)));

        } catch (SQLException e) {
            System.out.println(e);
            return countData;
        } finally {
            DBUtil.closeCallableStatement(callableStatement);
            pool.freeConnection(connection);
        }
        return countData;
    }

    public static Map<String, Double> getAgeDistbn2008() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement callableStatement = null;
        Map<String, Double> countData = new HashMap<String, Double>();
        String query = "{CALL getAgeDistbnCounts2008(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ";
        try {
            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(2, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(4, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(5, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(6, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(7, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(8, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(9, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(10, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(11, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(12, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(13, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(14, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(15, java.sql.Types.DOUBLE);

            // execute getDBUSERByUserId store procedure
            callableStatement.executeUpdate();
            countData.put("Age17_Rep_2008", Double.parseDouble(callableStatement.getString(1)));
            countData.put("Age17_Dem_2008", Double.parseDouble(callableStatement.getString(2)));
            countData.put("Age17_Una_2008", Double.parseDouble(callableStatement.getString(3)));
            countData.put("Age26_Rep_2008", Double.parseDouble(callableStatement.getString(4)));
            countData.put("Age26_Dem_2008", Double.parseDouble(callableStatement.getString(5)));
            countData.put("Age26_Una_2008", Double.parseDouble(callableStatement.getString(6)));
            countData.put("Age36_Rep_2008", Double.parseDouble(callableStatement.getString(7)));
            countData.put("Age36_Dem_2008", Double.parseDouble(callableStatement.getString(8)));
            countData.put("Age36_Una_2008", Double.parseDouble(callableStatement.getString(9)));
            countData.put("Age51_Rep_2008", Double.parseDouble(callableStatement.getString(10)));
            countData.put("Age51_Dem_2008", Double.parseDouble(callableStatement.getString(11)));
            countData.put("Age51_Una_2008", Double.parseDouble(callableStatement.getString(12)));
            countData.put("Age65_Rep_2008", Double.parseDouble(callableStatement.getString(13)));
            countData.put("Age65_Dem_2008", Double.parseDouble(callableStatement.getString(14)));
            countData.put("Age65_Una_2008", Double.parseDouble(callableStatement.getString(15)));

        } catch (SQLException e) {
            System.out.println(e);
            return countData;
        } finally {
            DBUtil.closeCallableStatement(callableStatement);
            pool.freeConnection(connection);
        }
        return countData;
    }

    public static Map<String, Double> getAgeDistbn2012() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement callableStatement = null;
        Map<String, Double> countData = new HashMap<String, Double>();
        String query = "{CALL getAgeDistbnCounts2012(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ";
        try {
            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(2, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(4, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(5, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(6, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(7, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(8, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(9, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(10, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(11, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(12, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(13, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(14, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(15, java.sql.Types.DOUBLE);

            // execute getDBUSERByUserId store procedure
            callableStatement.executeUpdate();
            countData.put("Age17_Rep_2012", Double.parseDouble(callableStatement.getString(1)));
            countData.put("Age17_Dem_2012", Double.parseDouble(callableStatement.getString(2)));
            countData.put("Age17_Una_2012", Double.parseDouble(callableStatement.getString(3)));
            countData.put("Age26_Rep_2012", Double.parseDouble(callableStatement.getString(4)));
            countData.put("Age26_Dem_2012", Double.parseDouble(callableStatement.getString(5)));
            countData.put("Age26_Una_2012", Double.parseDouble(callableStatement.getString(6)));
            countData.put("Age36_Rep_2012", Double.parseDouble(callableStatement.getString(7)));
            countData.put("Age36_Dem_2012", Double.parseDouble(callableStatement.getString(8)));
            countData.put("Age36_Una_2012", Double.parseDouble(callableStatement.getString(9)));
            countData.put("Age51_Rep_2012", Double.parseDouble(callableStatement.getString(10)));
            countData.put("Age51_Dem_2012", Double.parseDouble(callableStatement.getString(11)));
            countData.put("Age51_Una_2012", Double.parseDouble(callableStatement.getString(12)));
            countData.put("Age65_Rep_2012", Double.parseDouble(callableStatement.getString(13)));
            countData.put("Age65_Dem_2012", Double.parseDouble(callableStatement.getString(14)));
            countData.put("Age65_Una_2012", Double.parseDouble(callableStatement.getString(15)));

        } catch (SQLException e) {
            System.out.println(e);
            return countData;
        } finally {
            DBUtil.closeCallableStatement(callableStatement);
            pool.freeConnection(connection);
        }
        return countData;
    }

    public static Map<String, Double> getEthnicityDistbn() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement callableStatement = null;
        Map<String, Double> countData = new HashMap<String, Double>();
        String query = "{CALL getEthnicityCounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ";
        try {
            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(2, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(4, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(5, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(6, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(7, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(8, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(9, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(10, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(11, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(12, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(13, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(14, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(15, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(16, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(17, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(18, java.sql.Types.DOUBLE);

            // execute getDBUSERByUserId store procedure
            callableStatement.executeUpdate();
            countData.put("HL_Rep_2012", Double.parseDouble(callableStatement.getString(1)));
            countData.put("HL_Dem_2012", Double.parseDouble(callableStatement.getString(2)));
            countData.put("HL_Una_2012", Double.parseDouble(callableStatement.getString(3)));
            countData.put("NL_Rep_2012", Double.parseDouble(callableStatement.getString(4)));
            countData.put("NL_Dem_2012", Double.parseDouble(callableStatement.getString(5)));
            countData.put("NL_Una_2012", Double.parseDouble(callableStatement.getString(6)));
            countData.put("UN_Rep_2012", Double.parseDouble(callableStatement.getString(7)));
            countData.put("UN_Dem_2012", Double.parseDouble(callableStatement.getString(8)));
            countData.put("UN_Una_2012", Double.parseDouble(callableStatement.getString(9)));
            countData.put("HL_Rep_2008", Double.parseDouble(callableStatement.getString(10)));
            countData.put("HL_Dem_2008", Double.parseDouble(callableStatement.getString(11)));
            countData.put("HL_Una_2008", Double.parseDouble(callableStatement.getString(12)));
            countData.put("NL_Rep_2008", Double.parseDouble(callableStatement.getString(13)));
            countData.put("NL_Dem_2008", Double.parseDouble(callableStatement.getString(14)));
            countData.put("NL_Una_2008", Double.parseDouble(callableStatement.getString(15)));
            countData.put("UN_Rep_2008", Double.parseDouble(callableStatement.getString(16)));
            countData.put("UN_Dem_2008", Double.parseDouble(callableStatement.getString(17)));
            countData.put("UN_Una_2008", Double.parseDouble(callableStatement.getString(18)));

        } catch (SQLException e) {
            System.out.println(e);
            return countData;
        } finally {
            DBUtil.closeCallableStatement(callableStatement);
            pool.freeConnection(connection);
        }
        return countData;
    }
    
    public static Map<String, Double> getRaceDistbn() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement callableStatement = null;
        Map<String, Double> countData = new HashMap<String, Double>();
        String query = "{CALL getRaceDistbnCounts(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ";
        try {
            callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(2, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(4, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(5, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(6, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(7, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(8, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(9, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(10, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(11, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(12, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(13, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(14, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(15, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(16, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(17, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(18, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(19, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(20, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(21, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(22, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(23, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(24, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(25, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(26, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(27, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(28, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(29, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(30, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(31, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(32, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(33, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(34, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(35, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(36, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(37, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(38, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(39, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(40, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(41, java.sql.Types.DOUBLE);
            callableStatement.registerOutParameter(42, java.sql.Types.DOUBLE);

            // execute getDBUSERByUserId store procedure
            callableStatement.executeUpdate();
            countData.put("A_Rep_2008", Double.parseDouble(callableStatement.getString(1)));
            countData.put("B_Rep_2008", Double.parseDouble(callableStatement.getString(2)));
            countData.put("I_Rep_2008", Double.parseDouble(callableStatement.getString(3)));
            countData.put("O_Rep_2008", Double.parseDouble(callableStatement.getString(4)));
            countData.put("M_Rep_2008", Double.parseDouble(callableStatement.getString(5)));
            countData.put("U_Rep_2008", Double.parseDouble(callableStatement.getString(6)));
            countData.put("W_Rep_2008", Double.parseDouble(callableStatement.getString(7)));
            countData.put("A_Dem_2008", Double.parseDouble(callableStatement.getString(8)));
            countData.put("B_Dem_2008", Double.parseDouble(callableStatement.getString(9)));
            countData.put("I_Dem_2008", Double.parseDouble(callableStatement.getString(10)));
            countData.put("O_Dem_2008", Double.parseDouble(callableStatement.getString(11)));
            countData.put("M_Dem_2008", Double.parseDouble(callableStatement.getString(12)));
            countData.put("U_Dem_2008", Double.parseDouble(callableStatement.getString(13)));
            countData.put("W_Dem_2008", Double.parseDouble(callableStatement.getString(14)));
            countData.put("A_Una_2008", Double.parseDouble(callableStatement.getString(15)));
            countData.put("B_Una_2008", Double.parseDouble(callableStatement.getString(16)));
            countData.put("I_Una_2008", Double.parseDouble(callableStatement.getString(17)));
            countData.put("O_Una_2008", Double.parseDouble(callableStatement.getString(18)));
            countData.put("M_Una_2008", Double.parseDouble(callableStatement.getString(19)));
            countData.put("U_Una_2008", Double.parseDouble(callableStatement.getString(20)));
            countData.put("W_Una_2008", Double.parseDouble(callableStatement.getString(21)));
            
            countData.put("A_Rep_2012", Double.parseDouble(callableStatement.getString(22)));
            countData.put("B_Rep_2012", Double.parseDouble(callableStatement.getString(23)));
            countData.put("I_Rep_2012", Double.parseDouble(callableStatement.getString(24)));
            countData.put("O_Rep_2012", Double.parseDouble(callableStatement.getString(25)));
            countData.put("M_Rep_2012", Double.parseDouble(callableStatement.getString(26)));
            countData.put("U_Rep_2012", Double.parseDouble(callableStatement.getString(27)));
            countData.put("W_Rep_2012", Double.parseDouble(callableStatement.getString(28)));
            countData.put("A_Dem_2012", Double.parseDouble(callableStatement.getString(29)));
            countData.put("B_Dem_2012", Double.parseDouble(callableStatement.getString(30)));
            countData.put("I_Dem_2012", Double.parseDouble(callableStatement.getString(31)));
            countData.put("O_Dem_2012", Double.parseDouble(callableStatement.getString(32)));
            countData.put("M_Dem_2012", Double.parseDouble(callableStatement.getString(33)));
            countData.put("U_Dem_2012", Double.parseDouble(callableStatement.getString(34)));
            countData.put("W_Dem_2012", Double.parseDouble(callableStatement.getString(35)));
            countData.put("A_Una_2012", Double.parseDouble(callableStatement.getString(36)));
            countData.put("B_Una_2012", Double.parseDouble(callableStatement.getString(37)));
            countData.put("I_Una_2012", Double.parseDouble(callableStatement.getString(38)));
            countData.put("O_Una_2012", Double.parseDouble(callableStatement.getString(39)));
            countData.put("M_Una_2012", Double.parseDouble(callableStatement.getString(40)));
            countData.put("U_Una_2012", Double.parseDouble(callableStatement.getString(41)));
            countData.put("W_Una_2012", Double.parseDouble(callableStatement.getString(42)));
            

        } catch (SQLException e) {
            System.out.println(e);
            return countData;
        } finally {
            DBUtil.closeCallableStatement(callableStatement);
            pool.freeConnection(connection);
        }
        return countData;
    }

}
