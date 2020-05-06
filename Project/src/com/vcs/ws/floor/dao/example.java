package com.vcs.ws.floor.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.vcs.ws.util.ConnectionUtil;
import com.vcs.ws.wsconstants.WSConstants;

public class example extends AbstractDao {

	@SuppressWarnings("unchecked")
	public int floorsize() throws Exception {

		int count = 0;
		int floorId = 0;
		Connection con = ConnectionUtil.getInstance().getConnetion();
		setConnection(con);
		List floorData = new ArrayList();

		String searchQuery = WSConstants.GET_FLOOR_COUNT;
		floorData.add(floorId);

		List<Object> floorList = new ArrayList<Object>();
		floorList = (List) execute(searchQuery, floorData);

		count = floorList.size();
		System.out.println("count:" + count);
		return count;
	}

}
