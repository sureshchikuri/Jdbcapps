package com.vcs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vcs.floor.Floor;
import com.vcs.wsconstants.WorkStationConstants;

public class FloorCreateDao extends AbstractDao {

	public String insertFloor(Floor floor) throws Exception {

		String status = null;
		if (getFloors().size() < 1) {
			List floorData = new ArrayList();
			floorData.add(floor.getFloorId());
			floorData.add(floor.getFloorName());
			floorData.add(floor.getFloorDesc());
			execute(WorkStationConstants.FLOOR_INSERT_QUERY, floorData);
			status = "floor crated succesfully";
		} else {
			status = "floor alrady exists";
		}
		return status;
	}

	public List getFloors() {

		List floorList = new ArrayList();
		Floor floor = null;
		String searchQuery = WorkStationConstants.GET_FLOOR_QUERY
				+ WorkStationConstants.WHERE + WorkStationConstants.FLOOR_ID;
		try {
			List floorData = new ArrayList();
			floorData.add(floor.getFloorId());
			floorList = (List) execute(searchQuery, floorData);
		} catch (SQLException sql) {
		} finally {
		}
		return floorList;
	}

	protected List ProcessResultSet(ResultSet resultSet) throws SQLException {
		List floorList = new ArrayList();
		Floor floor = null;
		while (resultSet.next()) {
			floor = new Floor();

			floor.setFloorId(resultSet.getInt("FLOOR_ID"));
			floor.setFloorName(resultSet.getString("FLOOR_ID"));
			floor.setFloorDesc(resultSet.getString("FLOOR_ID"));
			floorList.add(floor);
		}
		return floorList;
	}
}
