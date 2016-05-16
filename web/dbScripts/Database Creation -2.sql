/***** ITIS 6120 Applied Databases Spring 2016 *****/
/*****       Project 1B            			   *****/

-- Team Members - Lakshmi Sridhar, Swetha Kavattur, Ramya Teja Ghanta

-- drop db if exists
DROP DATABASE IF EXISTS project1b_db;

-- create db if does not exists
CREATE DATABASE IF NOT EXISTS project1b_db;

-- use the db
USE project1b_db;

/*** a)create tables statements ***/

CREATE TABLE voter_details 
	AS SELECT voter_reg_num, first_name, middle_name, last_name, name_suffix_lbl, full_name_mail, age, sex_code, race_code, ethnic_code, 
    CONCAT(mail_addr1,' ',mail_addr2, ' ', mail_addr3, ' ', mail_addr4) AS mail_addr, res_city_desc, state_cd, zip_code
	FROM project1_db.voter_data; 

CREATE TABLE  voter_county_details 
	AS SELECT voter_reg_num, party_cd, CAST(registr_dt AS DATE) AS registr_dt, status_cd, pct_portion, precinct_desc, 
			  municipality_desc, ward_desc, cong_dist_desc, super_court_desc, judic_dist_desc, nc_senate_desc, nc_house_desc, 
              county_commiss_desc, school_dist_desc, dist_1_desc 
	FROM project1_db.voter_data;  

CREATE TABLE election_details
	(election_id INT PRIMARY KEY,
     election_date VARCHAR(15));
  
CREATE TABLE elections_voted 
	AS SELECT E1 as election_id, voter_reg_num,  E1_VotingMethod as voting_method, E1_PartyCd as party_cd 
	FROM project1_db.voter_data;

-- changing varchar column to date
SET SQL_SAFE_UPDATES=0;
UPDATE election_details
SET election_date = STR_TO_DATE(election_date,'%m/%d/%Y');    

-- constraints
ALTER TABLE voter_details 
ADD PRIMARY KEY voterDetails_pk (voter_reg_num);

ALTER TABLE voter_county_details
ADD CONSTRAINT voterCountyDetails_fk FOREIGN KEY(voter_reg_num) 
REFERENCES voter_details(voter_reg_num)
ON DELETE CASCADE;

ALTER TABLE elections_voted
ADD CONSTRAINT electionVoted__VoterDetails_fk FOREIGN KEY(voter_reg_num) 
REFERENCES voter_details(voter_reg_num)
ON DELETE CASCADE;

ALTER TABLE elections_voted
ADD CONSTRAINT electionVoted_eelctionDetails_fk FOREIGN KEY(election_id) 
REFERENCES election_details(election_id)
ON DELETE CASCADE;


/*** b) insert statements ***/
    
INSERT INTO elections_voted
	SELECT E2, voter_reg_num, E2_VotingMethod, E2_PartyCd 
	FROM project1_db.voter_data;

INSERT INTO elections_voted
	SELECT E3, voter_reg_num, E3_VotingMethod, E3_PartyCd 
	FROM project1_db.voter_data;

INSERT INTO elections_voted
	SELECT E4, voter_reg_num, E4_VotingMethod, E4_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E5, voter_reg_num, E5_VotingMethod , E5_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E6, voter_reg_num, E6_VotingMethod , E6_PartyCd 
	FROM project1_db.voter_data;

INSERT INTO elections_voted
	SELECT E7, voter_reg_num, E7_VotingMethod , E7_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E8, voter_reg_num, E8_VotingMethod , E8_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E9, voter_reg_num, E9_VotingMethod , E9_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E10, voter_reg_num, E10_VotingMethod , E10_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E11, voter_reg_num, E11_VotingMethod , E11_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E12, voter_reg_num, E12_VotingMethod , E12_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E13, voter_reg_num, E13_VotingMethod , E13_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E14, voter_reg_num, E14_VotingMethod , E14_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E15, voter_reg_num, E15_VotingMethod , E15_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E16, voter_reg_num, E16_VotingMethod , E16_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E17, voter_reg_num, E17_VotingMethod , E17_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E18, voter_reg_num, E18_VotingMethod , E18_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E19, voter_reg_num, E19_VotingMethod , E19_PartyCd 
	FROM project1_db.voter_data;
    
INSERT INTO elections_voted
	SELECT E20, voter_reg_num, E20_VotingMethod , E20_PartyCd 
	FROM project1_db.voter_data;
    

INSERT INTO election_details
	SELECT DISTINCT E1, E1_date  FROM project1_db.voter_data WHERE E1_date IS NOT NULL AND TRIM(E1_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E2, E2_date  FROM project1_db.voter_data WHERE E2_date IS NOT NULL AND TRIM(E2_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E3, E3_date  FROM project1_db.voter_data WHERE E3_date IS NOT NULL AND TRIM(E3_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E4, E4_date  FROM project1_db.voter_data WHERE E4_date IS NOT NULL AND TRIM(E4_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E5, E5_date  FROM project1_db.voter_data WHERE E5_date IS NOT NULL AND TRIM(E5_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E6, E6_date  FROM project1_db.voter_data WHERE E6_date IS NOT NULL AND TRIM(E6_date) <> '';
    
 INSERT INTO election_details
	SELECT DISTINCT E7, E7_date  FROM project1_db.voter_data WHERE E7_date IS NOT NULL AND TRIM(E7_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E8, E8_date  FROM project1_db.voter_data WHERE E8_date IS NOT NULL AND TRIM(E8_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E9, E9_date  FROM project1_db.voter_data WHERE E9_date IS NOT NULL AND TRIM(E9_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E10, E10_date  FROM project1_db.voter_data WHERE E10_date IS NOT NULL AND TRIM(E10_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E11, E11_date  FROM project1_db.voter_data WHERE E11_date IS NOT NULL AND TRIM(E11_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E12, E12_date  FROM project1_db.voter_data WHERE E12_date IS NOT NULL AND TRIM(E12_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E13, E13_date  FROM project1_db.voter_data WHERE E13_date IS NOT NULL AND TRIM(E13_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E14, E14_date  FROM project1_db.voter_data WHERE E14_date IS NOT NULL AND TRIM(E14_date) <> '';

INSERT INTO election_details
	SELECT DISTINCT E15, E15_date  FROM project1_db.voter_data WHERE E15_date IS NOT NULL AND TRIM(E15_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E16, E16_date  FROM project1_db.voter_data WHERE E16_date IS NOT NULL AND TRIM(E16_date) <> '';
    
 INSERT INTO election_details
	SELECT DISTINCT E17, E17_date  FROM project1_db.voter_data WHERE E17_date IS NOT NULL AND TRIM(E17_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E18, E18_date  FROM project1_db.voter_data WHERE E18_date IS NOT NULL AND TRIM(E18_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E19, E19_date  FROM project1_db.voter_data WHERE E19_date IS NOT NULL AND TRIM(E19_date) <> '';
    
INSERT INTO election_details
	SELECT DISTINCT E20, E20_date  FROM project1_db.voter_data WHERE E20_date IS NOT NULL AND TRIM(E20_date) <> '';

  

/*** c) join statemenets ***/
SELECT * FROM voter_details vd 
JOIN voter_county_details vcd 
ON vd.voter_reg_num = vcd.voter_reg_num;

SELECT * 
FROM voter_details vd 
JOIN voter_county_details vcd 
ON vd.voter_reg_num = vcd.voter_reg_num
JOIN elections_voted ev
ON vcd.voter_reg_num = ev.voter_reg_num
JOIN election_details ed
ON ed.election_id = ev.election_id;

SELECT vcd.voter_reg_num, vd.full_name_mail, ev.election_id, ev.voting_method, ed.election_date, ev.party_cd 
FROM voter_details vd 
JOIN voter_county_details vcd 
ON vd.voter_reg_num = vcd.voter_reg_num
JOIN elections_voted ev
ON vcd.voter_reg_num = ev.voter_reg_num
JOIN election_details ed
ON ed.election_id = ev.election_id
ORDER BY vd.full_name_mail;


/*** d) select count statements ***/
SELECT COUNT(*) FROM voter_details;
SELECT COUNT(*) FROM voter_county_details;
SELECT COUNT(*) FROM elections_voted;
SELECT COUNT(*) FROM election_details;



