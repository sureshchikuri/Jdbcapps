package com.vcs.wsconstants;

public interface WorkStationConstants {

	String FLOOR_INSERT_QUERY="INSERT INTO FLOOR(FLOOR_ID,FLOOR_NAME,FLOOR_DESC) VALUES(?,?,?)";
	String GET_FLOOR_QUERY =" SELECT F.* FROM(SELECT ROWNUM,FLOOR_ID,FLOOR_NAME,FLOOR_DESC FROM FLOOR) F";
	String GET_FLOOR_BETWEEN=" ROWNUM BETWEEN ?,?";
	String WHERE=" WHERE";
	String FLOOR_ID="FLOOR_ID";
	
}
