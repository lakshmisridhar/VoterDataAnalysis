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
public class ElectionDetails implements Serializable{
    private int election_id = 0;
    private String election_date ="";

    public int getElection_id() {
        return election_id;
    }

    public void setElection_id(int election_id) {
        this.election_id = election_id;
    }

    public String getElection_date() {
        return election_date;
    }

    public void setElection_date(String election_date) {
        this.election_date = election_date;
    }
    
}
