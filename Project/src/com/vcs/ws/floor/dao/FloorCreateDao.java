package com.vcs.ws.floor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vcs.ws.floor.java.Floor;
import com.vcs.ws.util.ConnectionUtil;
import com.vcs.ws.wsconstants.WSConstants;

public class FloorCreateDao extends AbstractDao {

	public String floorCreate(Floor floor) throws Exception {

		String status = null;
		ConnectionUtil connectionUtil = null;
		Connection connection = connectionUtil.getInstance().getConnetion();
		setConnection(connection);

		if (getFloors(floor.getFloorId()).size() < 1) {
			List floorData = new ArrayList();
			floorData.add(floor.getFloorId());
			floorData.add(floor.getFloorName());
			floorData.add(floor.getFloorDesc());
			execute(WSConstants.FLOOR_INSERT_QUERY, floorData);
			status = "floor crated succesfully";
		} else {
			status = "floor alrady exists";
		}
		return status;
	}

	private List getFloors( int floorId) {
	
		List floorList = new ArrayList();
		Floor floor = null;
		String searchQuery = WSConstants.GET_FLOOR_QUERY
				+ WSConstants.WHERE + WSConstants.FLOOR_ID;
		try {
			List floorData = new ArrayList();
			floorData.add(floorId);
			floorList = (List) execute(searchQuery, floorData);
		} catch (SQLException sql) {
		} finally {
		}
		
		return floorList;
	}
	
	protected List processResultSet(ResultSet resultSet) {
		List floorList = new ArrayList();
		Floor floor = null;
		try {
			while (resultSet.next()) {
				floor = new Floor();

				floor.setFloorId(resultSet.getInt("FLOOR_ID"));
				floor.setFloorName(resultSet.getString("FLOOR_NAME"));
				floor.setFloorDesc(resultSet.getString("FLOOR_DESC"));
				floorList.add(floor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return floorList;
	}
}
