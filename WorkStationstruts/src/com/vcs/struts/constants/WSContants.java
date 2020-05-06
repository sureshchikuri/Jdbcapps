package com.vcs.struts.constants;

public interface WSContants {
	
	int RECORDS_PER_PAGE=2;
	String FLOOR_CREATE_SUCCESS="Floor has been created successsfully";
	String FLOOR_CREATE_FAILED="Floor is not Created";
	String FLOOR_SEARCH_FAILED="No Records are found for given Criteria";
	String FLOOR_INSERT_QUERY="INSERT INTO FLOOR(FLOOR_ID,FLOOR_NAME,FLOOR_DESC) VALUES(?,?,?)";
	String GET_FLOOR_QUERY =" SELECT A.* FROM(SELECT ROWNUM AS ROW_NUM,F.* FROM(SELECT FLOOR_ID,FLOOR_NAME,FLOOR_DESC FROM FLOOR) F)A";
	String GET_FLOOR_BETWEEN=" ROW_NUM BETWEEN ? AND ?";
	String WHERE=" WHERE";
	String FLOOR_ID=" FLOOR_ID=?";
    String GET_FLOOR_COUNT = "SELECT COUNT(*) TOTAL_COUNT FROM FLOOR";

	
}
