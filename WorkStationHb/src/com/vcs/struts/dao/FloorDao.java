package com.vcs.struts.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.vcs.hibernate.Floor;
import com.vcs.struts.util.HibernateUtil;

public class FloorDao {

	Session session = null;
	Transaction tx = null;

	public String floorCreate(Floor floor) throws Exception {

		String status = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		if (getFloors(floor.getFloorId()).size() < 1) {

			session.save(floor);

			tx.commit();
			status = "floor crated succesfully";
		} else {
			status = "floor alrady exists";
		}
		return status;

	}

	@SuppressWarnings("unchecked")
	private List getFloors(int floorId) {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		List floorList = session.createCriteria(Floor.class).add(
				Restrictions.eq("floorId", floorId)).list();

		// int listSize=floorList.size();

		return floorList;
	}

	@SuppressWarnings("unchecked")
	public List<Floor> search(int floorId, int startRow, int endRow)
			throws Exception {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		List floorList = null;

		if (floorId != 0) {

			floorList = (List) session.createCriteria(Floor.class).add(
					Restrictions.eq("floorId", floorId)).list();
		} else {

			String qry = "SELECT A.* FROM(SELECT ROWNUM AS ROW_NUM,F.* FROM(SELECT FLOOR_ID,FLOOR_NAME,FLOOR_DESC FROM FLOOR) F)A WHERE ROW_NUM BETWEEN ? AND ?";
			SQLQuery query = session.createSQLQuery(qry);
			query.setInteger(0, startRow);
			query.setInteger(1, endRow);
			query.addEntity(Floor.class);

			floorList = query.list();

		}

		return floorList;
	}

	public int getCount(int floorId) throws Exception {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		int count = 0;

		String qry = "SELECT COUNT(FLOOR_ID) AS COUNT FROM FLOOR";
		SQLQuery query = session.createSQLQuery(qry);
		query.addScalar("COUNT", Hibernate.INTEGER);

		count = (Integer) query.uniqueResult();

		return count;
	}

}
