package com.vcs.ws.floor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vcs.ws.floor.java.Floor;
import com.vcs.ws.util.ConnectionUtil;
import com.vcs.ws.wsconstants.WSConstants;

public class FloorSearchDao extends AbstractDao {

	Connection connection = null;

	public List<Floor> Search(int floorId, int startRow, int endRow)
			throws Exception {

		connection = ConnectionUtil.getInstance().getConnetion();
		setConnection(connection);

		List floorData = new ArrayList();
		String searchQuery = WSConstants.GET_FLOOR_QUERY;

		if (floorId != 0) {
			searchQuery += WSConstants.WHERE + WSConstants.FLOOR_ID;
		} else {
			searchQuery += WSConstants.WHERE + WSConstants.GET_FLOOR_BETWEEN;
		}
		System.out.println(searchQuery);

		if (floorId != 0) {
			floorData.add(floorId);
		} else {
			floorData.add(startRow);
			floorData.add(endRow);
		}
		List floorList = new ArrayList();
		floorList = (List) execute(searchQuery, floorData);
		return floorList;
	}

	protected List processResultSet(ResultSet resultSet ) {
		List floorData = new ArrayList();
		Floor floor = null;
		try {
			
			while (resultSet.next()) {
				floor = new Floor();
				floor.setFloorId(resultSet.getInt("FLOOR_ID"));
				floor.setFloorName(resultSet.getString("FLOOR_NAME"));
				floor.setFloorDesc(resultSet.getString("FLOOR_DESC"));
				floorData.add(floor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return floorData;
	}

	public int getCount(int floorId) throws Exception {

		int count = 0;
		List floorData = new ArrayList();

		String searchQuery = WSConstants.GET_FLOOR_QUERY;

		if (floorId != 0) {
			searchQuery += WSConstants.WHERE + WSConstants.FLOOR_ID;
		}
		if (floorId != 0) {
			floorData.add(floorId);
		}

		List floorList = new ArrayList();
		floorList = (List) execute(searchQuery, floorData);

		//count = (Integer) floorList.get(0);
		count=floorList.size();
		System.out.println("count:"+count);
		return count;	
	}

}
