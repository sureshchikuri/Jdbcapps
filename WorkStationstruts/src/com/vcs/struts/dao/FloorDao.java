package com.vcs.struts.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vcs.struts.constants.WSContants;
import com.vcs.struts.floor.Floor;
import com.vcs.struts.util.ConnectionUtil;

public class FloorDao extends AbstractDao {
	
	String status = null;
	ConnectionUtil connectionUtil = null;
	
	@SuppressWarnings("unchecked")
	public String floorCreate(Floor floor) throws Exception {

		Connection connection = connectionUtil.getInstance().getConnetion();
		setConnection(connection);

		if (getFloors(floor.getFloorId()).size() < 1) {
			List floorData = new ArrayList();
			floorData.add(floor.getFloorId());
			floorData.add(floor.getFloorName());
			floorData.add(floor.getFloorDesc());
			execute(WSContants.FLOOR_INSERT_QUERY, floorData);
			status = "floor crated succesfully";
		} else {
			status = "floor alrady exists";
		}
		return status;
	}

	private List getFloors(int floorId) {

		List floorList = new ArrayList();
		Floor floor = null;
		String searchQuery = WSContants.GET_FLOOR_QUERY + WSContants.WHERE
				+ WSContants.FLOOR_ID;
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

	// Search Method

	public List<Floor> search(int floorId,int startRow,int endRow)
			throws Exception {

		Connection connection = ConnectionUtil.getInstance().getConnetion();
		setConnection(connection);

		List floorData = new ArrayList();
		String searchQuery = WSContants.GET_FLOOR_QUERY;

		if (floorId != 0) {
			searchQuery += WSContants.WHERE + WSContants.FLOOR_ID;
		} else {
			searchQuery += WSContants.WHERE + WSContants.GET_FLOOR_BETWEEN;
		}
		System.out.println(searchQuery);

		if (floorId != 0) {
			floorData.add(floorId);
		}  else {
			floorData.add(startRow);
			floorData.add(endRow);
		}
		
		List floorList = new ArrayList();
		floorList = (List) execute(searchQuery, floorData);
		return floorList;
	}

	public int getCount(int floorId) throws Exception {

		int count = 0;
		List floorData = new ArrayList();

		String searchQuery = WSContants.GET_FLOOR_QUERY;

		if (floorId != 0) {
			searchQuery += WSContants.WHERE + WSContants.FLOOR_ID;
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
