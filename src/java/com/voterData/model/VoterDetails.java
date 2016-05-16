/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voterData.model;

import java.io.Serializable;

/**
 *
 * @author Lakshmi Sridhar
 */
public class VoterDetails implements Serializable{

    private String first_name;
    private String middle_name;
    private String last_name;
    private String name_suffix_lbl;
    private String age;
    private String sex_code;
    private String ethnic_code;
    private String race_code;
    private String mail_addr;
    private String res_city_desc;
    private String state_cd;
    private String zip_code;
    private String voter_reg_num;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName_suffix_lbl() {
        return name_suffix_lbl;
    }

    public void setName_suffix_lbl(String name_suffix_lbl) {
        this.name_suffix_lbl = name_suffix_lbl;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEthnic_code() {
        return ethnic_code;
    }

    public void setEthnic_code(String ethnic_code) {
        this.ethnic_code = ethnic_code;
    }

    public String getRace_code() {
        return race_code;
    }

    public void setRace_code(String race_code) {
        this.race_code = race_code;
    }

    public String getMail_addr() {
        return mail_addr;
    }

    public void setMail_addr(String mail_addr) {
        this.mail_addr = mail_addr;
    }

    public String getRes_city_desc() {
        return res_city_desc;
    }

    public void setRes_city_desc(String res_city_desc) {
        this.res_city_desc = res_city_desc;
    }

    public String getState_cd() {
        return state_cd;
    }

    public void setState_cd(String state_cd) {
        this.state_cd = state_cd;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getVoter_reg_num() {
        return voter_reg_num;
    }

    public void setVoter_reg_num(String voter_reg_num) {
        this.voter_reg_num = voter_reg_num;
    }

    public String getSex_code() {
        return sex_code;
    }

    public void setSex_code(String sex_code) {
        this.sex_code = sex_code;
    }

}
