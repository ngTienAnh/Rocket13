package com.vti.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.vti.entity.Account;
import com.vti.entity.DetailDepartment;
import com.vti.ultis.HibernateUtils;

public class DetailDepartmentRepository {
	private HibernateUtils hibernateUtils;

	public DetailDepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<DetailDepartment> getDetailDepartment() {
		Session session = null;
		try {
// get session
			session = hibernateUtils.openSession();
// create hql query
			Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment", DetailDepartment.class);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
