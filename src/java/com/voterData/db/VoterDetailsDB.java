/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.db;

import com.voterData.model.VoterDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.apache.taglibs.standard.functions.Functions.trim;

/**
 *
 * @author Lakshmi Sridhar
 */
public class VoterDetailsDB {

    public static void main() {
        int countOfVd = getVoterDetailsCount();
        System.out.println(countOfVd);
    }

    public static int getVoterDetailsCount() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int count = 0;
        String query = "SELECT COUNT(voter_reg_num) AS count FROM voter_details ";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
             count = rs.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return count;
    }
    
    public static ArrayList<VoterDetails> getPopulationDist() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int count = 0;
        String query = "SELECT res_city_desc, ((COUNT(voter_reg_num)/getTotalPopulation()) * 100)as population FROM voter_details GROUP BY res_city_desc";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
             VoterDetails voterDetObj = null;
            ArrayList<VoterDetails> voterDetList = new ArrayList<VoterDetails>();
            while (rs.next()) {
                voterDetObj = new VoterDetails();
                voterDetObj.setRes_city_desc(rs.getString("res_city_desc"));
                voterDetObj.setVoter_reg_num(rs.getString("population"));
                voterDetList.add(voterDetObj);
            }
            return voterDetList;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
public static ArrayList<VoterDetails> getEthnicityDist() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int count = 0;
        String query = "SELECT ethnic_code, (COUNT(ethnic_code)/getTotalPopulation()) *100 AS ethnicDistbn FROM voter_details GROUP BY ethnic_code";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
             VoterDetails voterDetObj = null;
            ArrayList<VoterDetails> voterDetList = new ArrayList<VoterDetails>();
            while (rs.next()) {
                voterDetObj = new VoterDetails();
                if(trim(rs.getString("ethnic_code")).equalsIgnoreCase("HL")){
                voterDetObj.setEthnic_code("Hispanic/Latino");
                }else if(trim(rs.getString("ethnic_code")).equalsIgnoreCase("NL")){
                    voterDetObj.setEthnic_code("Not Hispanic/Latino");
                }else if (trim(rs.getString("ethnic_code")).equalsIgnoreCase("UN")){
                    voterDetObj.setEthnic_code("Unidentified");
                } 
                //voterDetObj.setEthnic_code(rs.getString("ethnic_code"));
                voterDetObj.setVoter_reg_num(rs.getString("ethnicDistbn"));
                voterDetList.add(voterDetObj);
            }
            return voterDetList;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }

public static ArrayList<VoterDetails> getRaceDist() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int count = 0;
        String query = "SELECT race_code, (COUNT(race_code)/getTotalPopulation()) *100 AS raceDitbn FROM voter_details GROUP BY race_code";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
             VoterDetails voterDetObj = null;
            ArrayList<VoterDetails> voterDetList = new ArrayList<VoterDetails>();
            while (rs.next()) {
                voterDetObj = new VoterDetails();
                if(trim(rs.getString("race_code")).equalsIgnoreCase("A")){
                voterDetObj.setRace_code("Asian");
                }else if(trim(rs.getString("race_code")).equalsIgnoreCase("B")){
                    voterDetObj.setRace_code("African American/Black");
                }else if (trim(rs.getString("race_code")).equalsIgnoreCase("I")){
                    voterDetObj.setRace_code("American Indian/Alaska Native");
                }else if(trim(rs.getString("race_code")).equalsIgnoreCase("M")){
                    voterDetObj.setRace_code("Multiracial");
                }else if (trim(rs.getString("race_code")).equalsIgnoreCase("O")){
                    voterDetObj.setRace_code("Other");
                }else if(trim(rs.getString("race_code")).equalsIgnoreCase("U")){
                    voterDetObj.setRace_code("Unidentified");
                }else if (trim(rs.getString("race_code")).equalsIgnoreCase("W")){
                    voterDetObj.setRace_code("White");
                } 
                //voterDetObj.setRace_code(rs.getString("race_code"));
                voterDetObj.setVoter_reg_num(rs.getString("raceDitbn"));
                voterDetList.add(voterDetObj);
            }
            return voterDetList;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }

}
