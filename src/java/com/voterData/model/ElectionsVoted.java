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
public class ElectionsVoted implements Serializable {

    private String election_id = "";
    private String voter_reg_num = "";
    private String voting_method = "";
    private String party_cd = "";

    public String getElection_id() {
        return election_id;
    }

    public void setElection_id(String election_id) {
        this.election_id = election_id;
    }

    public String getVoter_reg_num() {
        return voter_reg_num;
    }

    public void setVoter_reg_num(String voter_reg_num) {
        this.voter_reg_num = voter_reg_num;
    }

    public String getVoting_method() {
        return voting_method;
    }

    public void setVoting_method(String voting_method) {
        this.voting_method = voting_method;
    }

    public String getParty_cd() {
        return party_cd;
    }

    public void setParty_cd(String party_cd) {
        this.party_cd = party_cd;
    }

}
