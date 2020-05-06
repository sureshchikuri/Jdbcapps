package com.vcs.struts.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.vcs.hibernate.Floor;
import com.vcs.hibernate.Zone;
import com.vcs.struts.util.HibernateUtil;

public class ZoneDao {

	Session session = null;
	Transaction tx = null;

	public List floorData(Floor floor) {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		List<Floor> floorList = session.createCriteria(Floor.class).list();

		tx.commit();

		return floorList;
	}

	public String zoneCreate(Zone zone) {

		String status = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		session.save(zone);

		tx.commit();

		return status;
	}

	public List search(int zoneId, int startRow, int endRow) {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		List zoneList = null;

		if (zoneId != 0) {

			zoneList = (List) session.createCriteria(Zone.class).add(
					Restrictions.eq("zoneId", zoneId)).list();
		} else {

			String qry = "SELECT A.* FROM(SELECT ROWNUM AS ROW_NUM,F.* FROM(SELECT ZONE_ID,ZONE_NAME,ZONE_DESC FROM ZONE) F)A WHERE ROW_NUM BETWEEN ? AND ?";
			SQLQuery query = session.createSQLQuery(qry);
			query.setInteger(0, startRow);
			query.setInteger(1, endRow);
			query.addEntity(Zone.class);

			zoneList = query.list();

		}

		return zoneList;

	}

	public int getCount(int zoneId) {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		int count = 0;

		String qry = "SELECT COUNT(ZONE_ID) AS COUNT FROM ZONE";
		SQLQuery query = session.createSQLQuery(qry);
		query.addScalar("COUNT", Hibernate.INTEGER);

		count = (Integer) query.uniqueResult();

		return count;
	}
}
