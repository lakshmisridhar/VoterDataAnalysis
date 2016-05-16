/***** ITIS 6120 Applied Databases Spring 2016 *****/
/*****       Project 3            			   *****/

-- Team Members - Lakshmi Sridhar, Swetha Kavattur, Ramya Teja Ghanta

USE project1b_db;

ALTER TABLE elections_voted MODIFY COLUMN election_id INT;

ALTER TABLE elections_voted ADD PRIMARY KEY(election_id, voter_reg_num);

SET SQL_SAFE_UPDATES = 0;
DELETE FROM elections_voted WHERE election_id NOT IN(86, 98);
DELETE FROM elections_voted WHERE election_id NOT IN('86', '98');

/*** FUNCTIONS ***/
-- function get total COUNT of voters in the COUNTy
DROP FUNCTION IF EXISTS getTotalPopulation;
DELIMITER //
CREATE FUNCTION getTotalPopulation()
RETURNS INT
BEGIN
 DECLARE total_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_population_var
 FROM voter_details;
 
 RETURN(total_population_var);
END//

-- function get total COUNT of male  voted in 2008 in the COUNTy
DROP FUNCTION IF EXISTS getVotedMalePopulation2008;
DELIMITER //
CREATE FUNCTION getVotedMalePopulation2008()
RETURNS INT
BEGIN
 DECLARE total_male_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_male_population_var
 FROM voter_details JOIN elections_voted USINg(voter_reg_num)
 WHERE sex_code = 'M' and party_cd IN('REP', 'DEM', 'UNA') AND election_id = 86;
 
 RETURN(total_male_population_var);
END//

-- function get total COUNT of male  voted in 2012 in the COUNTy
DROP FUNCTION IF EXISTS getVotedlMalePopulation2012;
DELIMITER //
CREATE FUNCTION getVotedMalePopulation2012()
RETURNS INT
BEGIN
 DECLARE total_male_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_male_population_var
 FROM voter_details JOIN elections_voted USINg(voter_reg_num)
 WHERE sex_code = 'M' and party_cd IN('REP', 'DEM', 'UNA') AND election_id = 98;
 
 RETURN(total_male_population_var);
END//

-- function get total COUNT of female  voted in 2008 in the COUNTy
DROP FUNCTION IF EXISTS getVotedFemalePopulation2008;
DELIMITER //
CREATE FUNCTION getVotedFemalePopulation2008()
RETURNS INT
BEGIN
 DECLARE total_female_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_female_population_var
 FROM voter_details JOIN elections_voted USINg(voter_reg_num)
 WHERE sex_code = 'F' and party_cd IN('REP', 'DEM', 'UNA') AND election_id = 86;
 
 RETURN(total_female_population_var);
END//

-- function get total COUNT of female  voted in 2008 in the COUNTy
DROP FUNCTION IF EXISTS getVotedFemalePopulation2012;
DELIMITER //
CREATE FUNCTION getVotedFemalePopulation2012()
RETURNS INT
BEGIN
 DECLARE total_female_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_female_population_var
 FROM voter_details JOIN elections_voted USINg(voter_reg_num)
 WHERE sex_code = 'F' and party_cd IN('REP', 'DEM', 'UNA') AND election_id = 98;
 
 RETURN(total_female_population_var);
 END//
 
 -- function to get total COUNT of population who voted for 2008 election
DROP FUNCTION IF EXISTS getTotalPopulation2008;
DELIMITER //
CREATE FUNCTION getTotalPopulation2008()
RETURNS INT
BEGIN
 DECLARE total_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_population_var
 FROM elections_voted
 WHERE party_cd IN('REP','DEM','UNA') AND election_id=86;
 
 RETURN(total_population_var);
END//

-- function to get total COUNT of population who voted for 2008 election
DROP FUNCTION IF EXISTS getTotalPopulation2012;
DELIMITER //
CREATE FUNCTION getTotalPopulation2012()
RETURNS INT
BEGIN
 DECLARE total_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_population_var
 FROM elections_voted
 WHERE party_cd IN('REP','DEM','UNA') AND election_id=98;
 
 RETURN(total_population_var);
END//
DELIMITER ;

-- function to get total COUNT of population who voted for 2008 election HL
DROP FUNCTION IF EXISTS getTotalPopulation2012;
DELIMITER //
CREATE FUNCTION getEthnicTotalPopulation2012()
RETURNS INT
BEGIN
 DECLARE total_population_var INT;

 SELECT COUNT(voter_reg_num) INTO total_population_var
 FROM elections_voted
 WHERE party_cd IN('REP','DEM','UNA') AND election_id=98;
 
 RETURN(total_population_var);
END//
DELIMITER ;

/*** VIEW ***/

-- View which has 2008 AND 2012 election voting details 
DROP VIEW  IF EXISTS presidential_elections;
CREATE VIEW presidential_elections AS
SELECT * FROM elections_voted JOIN election_details USING(election_id)
WHERE election_date IN ('2008-11-04', '2012-11-06');

/*** TABLE IN PLACE OF MATERIALIZED VIEW ***/
DROP TABLE IF EXISTS analysis_view;
CREATE TABLE analysis_view AS
SELECT vd.voter_reg_num, age, sex_code, race_code, ethnic_code, ev.party_cd, election_date
from voter_details vd JOIN elections_voted ev USING(voter_reg_num)  
JOIN election_details ed USING(election_id)
WHERE election_date IN ('2008-11-04', '2012-11-06');
-- select count(*) from analysis_view;

/*** STORED PROCEDURE ***/
-- query for gender based distribution FROM presidential_elections view
DROP PROCEDURE IF EXISTS getGenderDistbnCounts;
DELIMITER //
CREATE PROCEDURE getGenderDistbnCounts(
	OUT count_male_REP_2008 	DECIMAL(9,2),
	OUT count_male_DEM_2008 	DECIMAL(9,2),
	OUT count_male_UNA_2008		DECIMAL(9,2),
	OUT count_female_REP_2008 	DECIMAL(9,2),
	OUT count_female_DEM_2008 	DECIMAL(9,2),
	OUT count_female_UNA_2008 	DECIMAL(9,2),
    OUT count_male_REP_2012 	DECIMAL(9,2),
	OUT count_male_DEM_2012 	DECIMAL(9,2),
	OUT count_male_UNA_2012 	DECIMAL(9,2),
	OUT count_female_REP_2012 	DECIMAL(9,2),
	OUT count_female_DEM_2012 	DECIMAL(9,2),
	OUT count_female_UNA_2012	DECIMAL(9,2)
)
BEGIN
	-- COUNT of male population voting for various parties in the year 2008
	SELECT ((COUNT(*)/getVotedMalePopulation2008())*100) INTO count_male_REP_2008 FROM analysis_view
	WHERE sex_code='M' AND party_cd='REP' AND election_date = '2008-11-04' ;

	SELECT((COUNT(*)/getVotedMalePopulation2008())*100) INTO count_male_DEM_2008 FROM analysis_view
	WHERE sex_code='M' AND party_cd='DEM' AND election_date= '2008-11-04' ;

	SELECT ((COUNT(*)/getVotedMalePopulation2008())*100) INTO count_male_UNA_2008 FROM analysis_view
	WHERE sex_code='M' AND party_cd='UNA' AND election_date= '2008-11-04' ;

	-- COUNT of female population voting for various parties in the year 2008
	SELECT ((COUNT(*)/getVotedFemalePopulation2008())*100) INTO count_female_REP_2008 FROM analysis_view
	WHERE sex_code='F' AND party_cd='REP' AND election_date= '2008-11-04' ;

	SELECT ((COUNT(*)/getVotedFemalePopulation2008())*100) INTO count_female_DEM_2008 FROM analysis_view
	WHERE sex_code='F' AND party_cd='DEM' AND election_date= '2008-11-04' ;

	SELECT ((COUNT(*)/getVotedFemalePopulation2008())*100) INTO count_female_UNA_2008 FROM analysis_view
	WHERE sex_code='F' AND party_cd='UNA' AND election_date= '2008-11-04' ;

	-- COUNT of male population voting for various parties in the year 2012
	SELECT ((COUNT(*)/getVotedMalePopulation2012())*100) INTO count_male_REP_2012 FROM analysis_view
	WHERE sex_code='M' AND party_cd='REP' AND election_date = '2012-11-06' ;

	SELECT ((COUNT(*)/getVotedMalePopulation2012())*100) INTO count_male_DEM_2012 FROM analysis_view
	WHERE sex_code='M' AND party_cd='DEM' AND election_date= '2012-11-06' ;

	SELECT ((COUNT(*)/getVotedMalePopulation2012())*100) INTO count_male_UNA_2012 FROM analysis_view
	WHERE sex_code='M' AND party_cd='UNA' AND election_date= '2012-11-06' ;

	-- COUNT of female population voting for various parties in the year 2012
	SELECT ((COUNT(*)/getVotedFemalePopulation2012())*100) INTO count_female_REP_2012 FROM analysis_view
	WHERE sex_code='F' AND party_cd='REP' AND election_date= '2012-11-06' ;

	SELECT ((COUNT(*)/getVotedFemalePopulation2012())*100) INTO count_female_DEM_2012 FROM analysis_view
	WHERE sex_code='F' AND party_cd='DEM' AND election_date= '2012-11-06' ;

	SELECT ((COUNT(*)/getVotedFemalePopulation2012())*100) INTO count_female_UNA_2012 FROM analysis_view
	WHERE sex_code='F' AND party_cd='UNA' AND election_date= '2012-11-06' ;
END //

DELIMITER ;
CALL getGenderDistbnCounts(@count_male_REP_2008, @count_male_DEM_2008, @count_male_UNA_2008, @count_female_REP_2008, @count_female_DEM_2008, @count_female_UNA_2008,
@count_male_REP_2012, @count_male_DEM_2012, @count_male_UNA_2012, @count_female_REP_2012, @count_female_DEM_2012, @count_female_UNA_2012);
SELECT  @count_male_REP_2008, @count_male_DEM_2008, @count_male_UNA_2008, @count_female_REP_2008, @count_female_DEM_2008, @count_female_UNA_2008,
@count_male_REP_2012, @count_male_DEM_2012, @count_male_UNA_2012, @count_female_REP_2012, @count_female_DEM_2012, @count_female_UNA_2012;

-- query for age based distrubution 
DROP PROCEDURE getAgeDistbnCounts2008;
DELIMITER //
CREATE PROCEDURE getAgeDistbnCounts2008(
	OUT age17_rep_2008 INT,
	OUT age17_dem_2008 INT,
	OUT age17_una_2008 INT,
	OUT age26_rep_2008 INT,
	OUT age26_dem_2008 INT,
	OUT age26_una_2008 INT,
	OUT age36_rep_2008 INT,
	OUT age36_dem_2008 INT,
	OUT age36_una_2008 INT,
	OUT age51_rep_2008 INT,
	OUT age51_dem_2008 INT,
	OUT age51_una_2008 INT,
	OUT age65_rep_2008 INT,
	OUT age65_dem_2008 INT,
	OUT age65_una_2008 INT)
BEGIN
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age17_rep_2008 FROM analysis_view 
	WHERE age BETWEEN 17 AND 25 AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age26_rep_2008 FROM analysis_view 
	WHERE age BETWEEN 26 AND 35 AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age36_rep_2008 FROM analysis_view 
	WHERE age BETWEEN 36 AND 50 AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age51_rep_2008 FROM analysis_view 
	WHERE age BETWEEN 51 AND 65 AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age65_rep_2008 FROM analysis_view 
	WHERE age >65 AND party_cd='REP' AND election_date= '2008-11-04';
	-- FOR PARTY DEMOCRATS
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age17_dem_2008 FROM analysis_view 
	WHERE age BETWEEN 17 AND 25 AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age26_dem_2008 FROM analysis_view 
	WHERE age BETWEEN 26 AND 35 AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO  age36_dem_2008 FROM analysis_view 
	WHERE age BETWEEN 36 AND 50 AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age51_dem_2008 FROM analysis_view 
	WHERE age BETWEEN 51 AND 65 AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age65_dem_2008 FROM analysis_view 
	WHERE age>65 AND party_cd='DEM' AND election_date= '2008-11-04';
	-- FOR UNA
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age17_una_2008 FROM analysis_view 
	WHERE age BETWEEN 17 AND 25 AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age26_una_2008 FROM analysis_view 
	WHERE age BETWEEN 26 AND 35 AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age36_una_2008 FROM analysis_view 
	WHERE age BETWEEN 36 AND 50 AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age51_una_2008 FROM analysis_view 
	WHERE age BETWEEN 51 AND 65 AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO age65_una_2008 FROM analysis_view 
	WHERE age>65 AND party_cd='UNA' AND election_date= '2008-11-04';
END //
DELIMITER ;
CALL getAgeDistbnCounts(@age17_rep_2008, @age17_dem_2008, @age17_una_2008, @age26_rep_2008 ,	 @age26_dem_2008,	 @age26_una_2008,	 @age36_rep_2008,	 @age36_dem_2008,
	 @age36_una_2008, @age51_rep_2008, @age51_dem_2008,	@age51_una_2008,	@age65_rep_2008,	@age65_dem_2008,	@age65_una_2008);	
    
SELECT @age17_rep_2008, @age17_dem_2008,	 @age17_una_2008 ,	 @age26_rep_2008,	 @age26_dem_2008,	 @age26_una_2008,	 @age36_rep_2008,	 @age36_dem_2008,
	 @age36_una_2008,	 @age51_rep_2008,	 @age51_dem_2008,	 @age51_una_2008,	@age65_rep_2008,	@age65_dem_2008,	@age65_una_2008;


DROP PROCEDURE getAgeDistbnCounts2012;
DELIMITER //
CREATE PROCEDURE getAgeDistbnCounts2012(
	OUT age17_rep_2012 INT,
	OUT age17_dem_2012 INT,
	OUT age17_una_2012 INT,
	OUT age26_rep_2012 INT,
	OUT age26_dem_2012 INT,
	OUT age26_una_2012 INT,
	OUT age36_rep_2012 INT,
	OUT age36_dem_2012 INT,
	OUT age36_una_2012 INT,
	OUT age51_rep_2012 INT,
	OUT age51_dem_2012 INT,
	OUT age51_una_2012 INT,
	OUT age65_rep_2012 INT,
	OUT age65_dem_2012 INT,
	OUT age65_una_2012 INT)
BEGIN
-- age based COUNT for 2012 elections
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age17_rep_2012 FROM analysis_view 
	WHERE age BETWEEN 17 AND 25 AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age26_rep_2012 FROM analysis_view 
	WHERE age BETWEEN 26 AND 35 AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age36_rep_2012 FROM analysis_view 
	WHERE age BETWEEN 36 AND 50 AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age51_rep_2012 FROM analysis_view 
	WHERE age BETWEEN 51 AND 65 AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age65_rep_2012 FROM analysis_view 
	WHERE age >65 AND party_cd='REP' AND election_date= '2012-11-06';
	-- FOR PARTY DEMOCRATS
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age17_dem_2012 FROM analysis_view 
	WHERE age BETWEEN 17 AND 25 AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age26_dem_2012 FROM analysis_view 
	WHERE age BETWEEN 26 AND 35 AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age36_dem_2012 FROM analysis_view 
	WHERE age BETWEEN 36 AND 50 AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age51_dem_2012 FROM analysis_view 
	WHERE age BETWEEN 51 AND 65 AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age65_dem_2012 FROM analysis_view 
	WHERE age>65 AND party_cd='DEM' AND election_date= '2012-11-06';
	-- FOR UNA
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age17_una_2012 FROM analysis_view 
	WHERE age BETWEEN 17 AND 25 AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age26_una_2012 FROM analysis_view 
	WHERE age BETWEEN 26 AND 35 AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age36_una_2012 FROM analysis_view 
	WHERE age BETWEEN 36 AND 50 AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age51_una_2012 FROM analysis_view 
	WHERE age BETWEEN 51 AND 65 AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO age65_una_2012 FROM analysis_view 
	WHERE age>65 AND party_cd='UNA' AND election_date= '2012-11-06';
END //
DELIMITER ;

CALL getAgeDistbnCounts2012 (@age17_rep_2012,	@age17_dem_2012, @age17_una_2012,@age26_rep_2012,@age26_dem_2012,	@age26_una_2012,	@age36_rep_2012,	@age36_dem_2012,	@age36_una_2012,	@age51_rep_2012,	@age51_dem_2012,
	@age51_una_2012, @age65_rep_2012,@age65_dem_2012,	@age65_una_2012 );
SELECT @age17_rep_2012,	@age17_dem_2012, @age17_una_2012,@age26_rep_2012,@age26_dem_2012,	@age26_una_2012,	@age36_rep_2012,	@age36_dem_2012,	@age36_una_2012,	@age51_rep_2012,	@age51_dem_2012,
	@age51_una_2012, @age65_rep_2012,@age65_dem_2012,	@age65_una_2012;

-- query for ethnicity based data
DROP PROCEDURE IF EXISTS getEthnicityCounts;
DELIMITER //
CREATE PROCEDURE getEthnicityCounts(
	OUT HL_rep_2012 DECIMAL(9, 2),
	OUT HL_dem_2012 DECIMAL(9, 2),
	OUT HL_una_2012 DECIMAL(9, 2),
	OUT NL_rep_2012 DECIMAL(9, 2),
	OUT NL_dem_2012 DECIMAL(9, 2),
	OUT NL_una_2012 DECIMAL(9, 2),
	OUT UN_rep_2012 DECIMAL(9, 2),
	OUT UN_dem_2012 DECIMAL(9, 2),
	OUT UN_una_2012 DECIMAL(9, 2),
    OUT HL_rep_2008 DECIMAL(9, 2),
	OUT HL_dem_2008 DECIMAL(9, 2),
	OUT HL_una_2008 DECIMAL(9, 2),
	OUT NL_rep_2008 DECIMAL(9, 2),
	OUT NL_dem_2008 DECIMAL(9, 2),
	OUT NL_una_2008 DECIMAL(9, 2),
	OUT UN_rep_2008 DECIMAL(9, 2),
	OUT UN_dem_2008 DECIMAL(9, 2),
	OUT UN_una_2008 DECIMAL(9, 2))
BEGIN
-- age based COUNT for 2012 elections
	SELECT COUNT(*) INTO HL_rep_2012 FROM analysis_view 
	WHERE ethnic_code ='HL' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT COUNT(*) INTO NL_rep_2012 FROM analysis_view 
	WHERE ethnic_code ='NL' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT COUNT(*) INTO UN_rep_2012 FROM analysis_view 
	WHERE ethnic_code ='UN' AND party_cd='REP' AND election_date= '2012-11-06';
    SELECT COUNT(*) INTO HL_dem_2012 FROM analysis_view 
	WHERE ethnic_code ='HL' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT COUNT(*) INTO NL_dem_2012 FROM analysis_view 
	WHERE ethnic_code ='NL' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT COUNT(*) INTO UN_dem_2012 FROM analysis_view 
	WHERE ethnic_code ='UN' AND party_cd='DEM' AND election_date= '2012-11-06';
    SELECT COUNT(*) INTO HL_una_2012 FROM analysis_view 
	WHERE ethnic_code ='HL' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT COUNT(*) INTO NL_una_2012 FROM analysis_view 
	WHERE ethnic_code ='NL' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT COUNT(*) INTO UN_una_2012 FROM analysis_view 
	WHERE ethnic_code ='UN' AND party_cd='UNA' AND election_date= '2012-11-06';
	
    -- 2008
    SELECT COUNT(*) INTO HL_rep_2008 FROM analysis_view 
	WHERE ethnic_code ='HL' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT COUNT(*) INTO NL_rep_2008 FROM analysis_view 
	WHERE ethnic_code ='NL' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT COUNT(*) INTO UN_rep_2008 FROM analysis_view 
	WHERE ethnic_code ='UN' AND party_cd='REP' AND election_date= '2008-11-04';
    SELECT COUNT(*) INTO HL_dem_2008 FROM analysis_view 
	WHERE ethnic_code ='HL' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT COUNT(*) INTO NL_dem_2008 FROM analysis_view 
	WHERE ethnic_code ='NL' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT COUNT(*) INTO UN_dem_2008 FROM analysis_view 
	WHERE ethnic_code ='UN' AND party_cd='DEM' AND election_date= '2008-11-04';
    SELECT COUNT(*) INTO HL_una_2008 FROM analysis_view 
	WHERE ethnic_code ='HL' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT COUNT(*) INTO NL_una_2008 FROM analysis_view 
	WHERE ethnic_code ='NL' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT COUNT(*) INTO UN_una_2008 FROM analysis_view 
	WHERE ethnic_code ='UN' AND party_cd='UNA' AND election_date= '2008-11-04';

END //
DELIMITER ;

CALL getEthnicityCounts (@HL_rep_2012,	@HL_dem_2012 ,	@HL_una_2012 ,	@NL_rep_2012 ,	@NL_dem_2012 ,	@NL_una_2012 ,	@UN_rep_2012 ,	@UN_dem_2012 ,	@UN_una_2012 ,
    @HL_rep_2008 ,	@HL_dem_2008 ,	@HL_una_2008 ,	@NL_rep_2008 ,	@NL_dem_2008 ,	@NL_una_2008 ,	@UN_rep_2008 ,	@UN_dem_2008 ,	@UN_una_2008 );
    
SELECT @HL_rep_2012,	@HL_dem_2012 ,	@HL_una_2012 ,	@NL_rep_2012 ,	@NL_dem_2012 ,	@NL_una_2012 ,	@UN_rep_2012 ,	@UN_dem_2012 ,	@UN_una_2012 ,
    @HL_rep_2008 ,	@HL_dem_2008 ,	@HL_una_2008 ,	@NL_rep_2008 ,	@NL_dem_2008 ,	@NL_una_2008 ,	@UN_rep_2008 ,	@UN_dem_2008 ,	@UN_una_2008;


-- race based analysis
DROP PROCEDURE IF EXISTS getRaceDistbnCounts;
DELIMITER //

CREATE PROCEDURE getRaceDistbnCounts(
	OUT race_a_REP2008 DECIMAL(9,2),
	OUT race_b_REP2008 DECIMAL(9,2),
	OUT race_i_REP2008 DECIMAL(9,2),
	OUT race_o_REP2008 DECIMAL(9,2),
	OUT race_m_REP2008 DECIMAL(9,2),
	OUT race_u_REP2008 DECIMAL(9,2),
    OUT race_w_REP2008 DECIMAL(9,2),
	OUT race_a_DEM2008 DECIMAL(9,2),
	OUT race_b_DEM2008 DECIMAL(9,2),
	OUT race_i_DEM2008 DECIMAL(9,2),
	OUT race_o_DEM2008 DECIMAL(9,2),
	OUT race_m_DEM2008 DECIMAL(9,2),
	OUT race_u_DEM2008 DECIMAL(9,2),
    OUT race_w_DEM2008 DECIMAL(9,2),
	OUT race_a_UNA2008 DECIMAL(9,2),
	OUT race_b_UNA2008 DECIMAL(9,2),
	OUT race_i_UNA2008 DECIMAL(9,2),
	OUT race_o_UNA2008 DECIMAL(9,2),
	OUT race_m_UNA2008 DECIMAL(9,2),
	OUT race_u_UNA2008 DECIMAL(9,2),
    OUT race_w_UNA2008 DECIMAL(9,2),
	OUT race_a_REP2012 DECIMAL(9,2),
	OUT race_b_REP2012 DECIMAL(9,2),
	OUT race_i_REP2012 DECIMAL(9,2),
	OUT race_o_REP2012 DECIMAL(9,2),
	OUT race_m_REP2012 DECIMAL(9,2),
	OUT race_u_REP2012 DECIMAL(9,2),
    OUT race_w_REP2012 DECIMAL(9,2),
	OUT race_a_DEM2012 DECIMAL(9,2),
	OUT race_b_DEM2012 DECIMAL(9,2),
	OUT race_i_DEM2012 DECIMAL(9,2),
	OUT race_o_DEM2012 DECIMAL(9,2),
	OUT race_m_DEM2012 DECIMAL(9,2),
	OUT race_u_DEM2012 DECIMAL(9,2),
    OUT race_w_DEM2012 DECIMAL(9,2),
	OUT race_a_UNA2012 DECIMAL(9,2),
	OUT race_b_UNA2012 DECIMAL(9,2),
	OUT race_i_UNA2012 DECIMAL(9,2),
	OUT race_o_UNA2012 DECIMAL(9,2),
	OUT race_m_UNA2012 DECIMAL(9,2),
	OUT race_u_UNA2012 DECIMAL(9,2),
    OUT race_w_UNA2012 DECIMAL(9,2))
BEGIN
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_a_REP2008 FROM analysis_view WHERE  race_code='A' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_b_REP2008 FROM analysis_view WHERE  race_code='B' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_i_REP2008 FROM analysis_view WHERE  race_code='I' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_o_REP2008 FROM analysis_view WHERE  race_code='O' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_m_REP2008 FROM analysis_view WHERE  race_code='M' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_u_REP2008 FROM analysis_view WHERE  race_code='U' AND party_cd='REP' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_w_REP2008 FROM analysis_view WHERE  race_code='W' AND party_cd='REP' AND election_date= '2008-11-04';

	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_a_DEM2008 FROM analysis_view WHERE  race_code='A' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_b_DEM2008 FROM analysis_view WHERE  race_code='B' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_i_DEM2008 FROM analysis_view WHERE  race_code='I' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_o_DEM2008 FROM analysis_view WHERE  race_code='O' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_m_DEM2008 FROM analysis_view WHERE  race_code='M' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_u_DEM2008 FROM analysis_view WHERE  race_code='U' AND party_cd='DEM' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_w_DEM2008 FROM analysis_view WHERE  race_code='W' AND party_cd='DEM' AND election_date= '2008-11-04';

	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_a_UNA2008 FROM analysis_view WHERE  race_code='A' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_b_UNA2008 FROM analysis_view WHERE  race_code='B' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_i_UNA2008 FROM analysis_view WHERE  race_code='I' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_o_UNA2008 FROM analysis_view WHERE  race_code='O' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_m_UNA2008 FROM analysis_view WHERE  race_code='M' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_u_UNA2008 FROM analysis_view WHERE  race_code='U' AND party_cd='UNA' AND election_date= '2008-11-04';
	SELECT (COUNT(*)/getTotalPopulation2008())*100 INTO race_w_UNA2008 FROM analysis_view WHERE  race_code='W' AND party_cd='UNA' AND election_date= '2008-11-04';

	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_a_REP2012 FROM analysis_view WHERE  race_code='A' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_b_REP2012 FROM analysis_view WHERE  race_code='B' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_i_REP2012 FROM analysis_view WHERE  race_code='I' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_o_REP2012 FROM analysis_view WHERE  race_code='O' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_m_REP2012 FROM analysis_view WHERE  race_code='M' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_u_REP2012 FROM analysis_view WHERE  race_code='U' AND party_cd='REP' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_w_REP2012 FROM analysis_view WHERE  race_code='W' AND party_cd='REP' AND election_date= '2012-11-06';

	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_a_DEM2012 FROM analysis_view WHERE  race_code='A' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_b_DEM2012 FROM analysis_view WHERE  race_code='B' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_i_DEM2012 FROM analysis_view WHERE  race_code='I' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_o_DEM2012 FROM analysis_view WHERE  race_code='O' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_m_DEM2012 FROM analysis_view WHERE  race_code='M' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_u_DEM2012 FROM analysis_view WHERE  race_code='U' AND party_cd='DEM' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_w_DEM2012 FROM analysis_view WHERE  race_code='W' AND party_cd='DEM' AND election_date= '2012-11-06';

	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_a_UNA2012 FROM analysis_view WHERE  race_code='A' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_b_UNA2012 FROM analysis_view WHERE  race_code='B' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_i_UNA2012 FROM analysis_view WHERE  race_code='I' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_o_UNA2012 FROM analysis_view WHERE  race_code='O' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_m_UNA2012 FROM analysis_view WHERE  race_code='M' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_u_UNA2012 FROM analysis_view WHERE  race_code='U' AND party_cd='UNA' AND election_date= '2012-11-06';
	SELECT (COUNT(*)/getTotalPopulation2012())*100 INTO race_w_UNA2012 FROM analysis_view WHERE  race_code='W' AND party_cd='UNA' AND election_date= '2012-11-06';

END //
DELIMITER ;
CALL getRaceDistbnCounts (@race_a_REP2008 , @race_b_REP2008 , @race_i_REP2008 , @race_o_REP2008 , @race_m_REP2008 , @race_u_REP2008 ,@race_w_REP2008 ,
	 @race_a_DEM2008 , @race_b_DEM2008 , @race_i_DEM2008 , @race_o_DEM2008 , @race_m_DEM2008 , @race_u_DEM2008 ,    @race_w_DEM2008 ,
	 @race_a_UNA2008 , @race_b_UNA2008 ,@race_i_UNA2008 ,	 @race_o_UNA2008 , @race_m_UNA2008 , @race_u_UNA2008 ,   @race_w_UNA2008 ,
	 @race_a_REP2012 , @race_b_REP2012 , @race_i_REP2012 , @race_o_REP2012 , @race_m_REP2012 , @race_u_REP2012 ,    @race_w_REP2012 ,
	 @race_a_DEM2012 , @race_b_DEM2012 , @race_i_DEM2012 , @race_o_DEM2012 , @race_m_DEM2012 ,@race_u_DEM2012 ,    @race_w_DEM2012 ,
	 @race_a_UNA2012 , @race_b_UNA2012 , @race_i_UNA2012 , @race_o_UNA2012 , @race_m_UNA2012 , @race_u_UNA2012 ,    @race_w_UNA2012 );
     
SELECT @race_a_REP2008 , @race_b_REP2008 , @race_i_REP2008 , @race_o_REP2008 , @race_m_REP2008 , @race_u_REP2008 ,@race_w_REP2008 ,
	 @race_a_DEM2008 , @race_b_DEM2008 , @race_i_DEM2008 , @race_o_DEM2008 , @race_m_DEM2008 , @race_u_DEM2008 ,    @race_w_DEM2008 ,
	 @race_a_UNA2008 , @race_b_UNA2008 ,@race_i_UNA2008 ,	 @race_o_UNA2008 , @race_m_UNA2008 , @race_u_UNA2008 ,   @race_w_UNA2008 ,
	 @race_a_REP2012 , @race_b_REP2012 , @race_i_REP2012 , @race_o_REP2012 , @race_m_REP2012 , @race_u_REP2012 ,    @race_w_REP2012 ,
	 @race_a_DEM2012 , @race_b_DEM2012 , @race_i_DEM2012 , @race_o_DEM2012 , @race_m_DEM2012 ,@race_u_DEM2012 ,    @race_w_DEM2012 ,
	 @race_a_UNA2012 , @race_b_UNA2012 , @race_i_UNA2012 , @race_o_UNA2012 , @race_m_UNA2012 , @race_u_UNA2012 ,    @race_w_UNA2012;
 
-- query poupulation analysis
SELECT ethnic_code, (COUNT(ethnic_code)/getTotgetEthnicityCountsalPopulation()) *100 AS ethnicDistbn FROM voter_details GROUP BY ethnic_code;
SELECT race_code, (COUNT(race_code)/getTotalPopulation()) *100 AS raceDitbn FROM voter_details GROUP BY race_code;
SELECT res_city_desc, ((COUNT(voter_reg_num)/getTotalPopulation()) * 100)as population FROM voter_details GROUP BY res_city_desc;

/*** INDEX ***/
CREATE INDEX voterDetails_city_ix ON voter_details(res_city_desc);
CREATE INDEX voterDetails_sexCode_ix ON voter_details(sex_code);
CREATE INDEX electionsVoted_partyCd_ix ON elections_Voted(party_cd);
CREATE INDEX analysisView_composite_ix ON analysis_view(voter_reg_num, age, sex_code, race_code, ethnic_code, party_cd, election_date);

