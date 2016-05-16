/***** ITIS 6120 Applied Databases Spring 2016 *****/
/*****       Project 1A            			   *****/

-- Team Members - Lakshmi Sridhar, Swetha Kavattur, Ramya Teja Ghanta

-- drop db if exists
DROP DATABASE IF EXISTS project1_db;

-- create db if does not exists
CREATE DATABASE IF NOT EXISTS project1_db;

-- use the db
USE project1_db;

-- create table for voter data
CREATE TABLE voter_data (
precinct_desc VARCHAR(8),
party_cd VARCHAR(3),
race_code VARCHAR(3),
ethnic_code VARCHAR(3),
sex_code CHAR(3),
age INT,
pct_portion VARCHAR(20) ,
first_name VARCHAR(25),
middle_name VARCHAR(25),
last_name VARCHAR(25),
name_suffix_lbl VARCHAR(5),
full_name_mail VARCHAR(50),
mail_addr1 VARCHAR(40),
mail_addr2 VARCHAR(40),
mail_addr3 VARCHAR(30),
mail_addr4 VARCHAR(30),
mail_city_state_zip VARCHAR(45),
house_num VARCHAR(10) ,
half_code VARCHAR(15),
street_dir VARCHAR(15),
street_name VARCHAR(35),
street_type_cd VARCHAR(15),
street_sufx_cd VARCHAR(15),
unit_designator VARCHAR(15),
unit_num VARCHAR(15),
res_city_desc VARCHAR(25),
state_cd CHAR(2),
zip_code INT,
registr_dt VARCHAR(19),
voter_reg_num CHAR(12),
status_cd CHAR(1),
municipality_desc VARCHAR(25),
ward_desc VARCHAR(25),
cong_dist_desc VARCHAR(30),
super_court_desc VARCHAR(30),
judic_dist_desc VARCHAR(30),
nc_senate_desc VARCHAR(30),
nc_house_desc VARCHAR(30),
county_commiss_desc VARCHAR(50),
school_dist_desc VARCHAR(25),
dist_1_desc VARCHAR(20),
E1 CHAR(4) ,
E1_date VARCHAR(10),
E1_VotingMethod VARCHAR(10),
E1_PartyCd VARCHAR(4),
E2 CHAR(4),
E2_Date VARCHAR(10),
E2_VotingMethod VARCHAR(10),
E2_PartyCd VARCHAR(4),
E3 CHAR(4),
E3_Date VARCHAR(10),
E3_VotingMethod VARCHAR(10),
E3_PartyCd VARCHAR(4),
E4 CHAR(4),
E4_Date VARCHAR(10),
E4_VotingMethod VARCHAR(10),
E4_PartyCd VARCHAR(4),
E5 CHAR(4),
E5_Date VARCHAR(10),
E5_VotingMethod VARCHAR(10),
E5_PartyCd VARCHAR(4),
E6 CHAR(4),
E6_Date VARCHAR(10),
E6_VotingMethod VARCHAR(10),
E6_PartyCd VARCHAR(4),
E7 CHAR(4),
E7_Date VARCHAR(10),
E7_VotingMethod VARCHAR(10),
E7_PartyCd VARCHAR(4),
E8 CHAR(4),
E8_Date VARCHAR(10),
E8_VotingMethod VARCHAR(10),
E8_PartyCd VARCHAR(4),
E9 CHAR(4),
E9_Date VARCHAR(10) ,
E9_VotingMethod VARCHAR(10),
E9_PartyCd VARCHAR(4),
E10 CHAR(4),
E10_Date VARCHAR(10),
E10_VotingMethod VARCHAR(10),
E10_PartyCd VARCHAR(4),
E11 CHAR(4),
E11_Date VARCHAR(10),
E11_VotingMethod VARCHAR(10),
E11_PartyCd VARCHAR(4),
E12 CHAR(4),
E12_Date VARCHAR(10),
E12_VotingMethod VARCHAR(10),
E12_PartyCd VARCHAR(4),
E13 CHAR(4),
E13_Date VARCHAR(10),
E13_VotingMethod VARCHAR(10),
E13_PartyCd VARCHAR(4),
E14 CHAR(4),
E14_Date VARCHAR(10),
E14_VotingMethod VARCHAR(10),
E14_PartyCd VARCHAR(4),
E15 CHAR(4),
E15_Date VARCHAR(10),
E15_VotingMethod VARCHAR(10),
E15_PartyCd VARCHAR(4),
E16 CHAR(4),
E16_Date VARCHAR(10),
E16_VotingMethod VARCHAR(10),
E16_PartyCd VARCHAR(4),
E17 CHAR(4),
E17_Date VARCHAR(10),
E17_VotingMethod VARCHAR(10),
E17_PartyCd VARCHAR(4),
E18 CHAR(4),
E18_Date VARCHAR(10),
E18_VotingMethod VARCHAR(10),
E18_PartyCd VARCHAR(4),
E19 CHAR(4),
E19_Date VARCHAR(10),
E19_VotingMethod VARCHAR(10),
E19_PartyCd VARCHAR(4),
E20 CHAR(4),
E20_Date VARCHAR(10),
E20_VotingMethod VARCHAR(10),
E20_PartyCd VARCHAR(4)
);

-- Load data from txt file
LOAD DATA LOCAL INFILE 'C:/Users/Gopinath N/Documents/Lakshmi/UNCC MSIT/Spring 2016 Courses/AD/Project 1A/VoterDataFile/voterdatafile.txt'
INTO TABLE voter_data
FIELDS TERMINATED BY ',';

-- select query for count of entries
SELECT COUNT(*) FROM voter_data;