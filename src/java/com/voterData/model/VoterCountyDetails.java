/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Lakshmi Sridhar
 */
public class VoterCountyDetails implements Serializable {

    private String voter_reg_num = "";
    private String party_cd = "";
    private Date registr_dt = null;
    private String status_cd = "";
    private String pct_portion = "";
    private String precinct_desc = "";
    private String municipality_desc = "";
    private String ward_desc = "";
    private String cong_dist_desc = "";
    private String super_court_desc = "";
    private String judic_dist_desc = "";
    private String nc_senate_desc = "";
    private String nc_house_desc = "";
    private String county_commiss_desc = "";
    private String school_dist_desc = "";
    private String dist_1_desc = "";

    public String getVoter_reg_num() {
        return voter_reg_num;
    }

    public void setVoter_reg_num(String voter_reg_num) {
        this.voter_reg_num = voter_reg_num;
    }

    public String getParty_cd() {
        return party_cd;
    }

    public void setParty_cd(String party_cd) {
        this.party_cd = party_cd;
    }

    public Date getRegistr_dt() {
        return registr_dt;
    }

    public void setRegistr_dt(Date registr_dt) {
        this.registr_dt = registr_dt;
    }

    public String getStatus_cd() {
        return status_cd;
    }

    public void setStatus_cd(String status_cd) {
        this.status_cd = status_cd;
    }

    public String getPct_portion() {
        return pct_portion;
    }

    public void setPct_portion(String pct_portion) {
        this.pct_portion = pct_portion;
    }

    public String getPrecinct_desc() {
        return precinct_desc;
    }

    public void setPrecinct_desc(String precinct_desc) {
        this.precinct_desc = precinct_desc;
    }

    public String getMunicipality_desc() {
        return municipality_desc;
    }

    public void setMunicipality_desc(String municipality_desc) {
        this.municipality_desc = municipality_desc;
    }

    public String getWard_desc() {
        return ward_desc;
    }

    public void setWard_desc(String ward_desc) {
        this.ward_desc = ward_desc;
    }

    public String getCong_dist_desc() {
        return cong_dist_desc;
    }

    public void setCong_dist_desc(String cong_dist_desc) {
        this.cong_dist_desc = cong_dist_desc;
    }

    public String getSuper_court_desc() {
        return super_court_desc;
    }

    public void setSuper_court_desc(String super_court_desc) {
        this.super_court_desc = super_court_desc;
    }

    public String getJudic_dist_desc() {
        return judic_dist_desc;
    }

    public void setJudic_dist_desc(String judic_dist_desc) {
        this.judic_dist_desc = judic_dist_desc;
    }

    public String getNc_senate_desc() {
        return nc_senate_desc;
    }

    public void setNc_senate_desc(String nc_senate_desc) {
        this.nc_senate_desc = nc_senate_desc;
    }

    public String getNc_house_desc() {
        return nc_house_desc;
    }

    public void setNc_house_desc(String nc_house_desc) {
        this.nc_house_desc = nc_house_desc;
    }

    public String getCounty_commiss_desc() {
        return county_commiss_desc;
    }

    public void setCounty_commiss_desc(String county_commiss_desc) {
        this.county_commiss_desc = county_commiss_desc;
    }

    public String getSchool_dist_desc() {
        return school_dist_desc;
    }

    public void setSchool_dist_desc(String school_dist_desc) {
        this.school_dist_desc = school_dist_desc;
    }

    public String getDist_1_desc() {
        return dist_1_desc;
    }

    public void setDist_1_desc(String dist_1_desc) {
        this.dist_1_desc = dist_1_desc;
    }

}
