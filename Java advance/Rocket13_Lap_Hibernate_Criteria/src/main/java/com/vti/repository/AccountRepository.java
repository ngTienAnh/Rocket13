package com.vti.repository;

import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.vti.entity.Account;
import com.vti.ultis.HibernateUtils;

import javassist.expr.NewArray;

public class AccountRepository {
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		this.hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Account> Get_From() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root);
			List<Account> listAccount = session.createQuery(query).list();

			return listAccount;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account Get_From_id(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root);
			query.where(builder.equal(root.get("AccountID"), id));
			Account account = session.createQuery(query).uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public String Get_From_Fullname(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<String> query = builder.createQuery(String.class);
			Root<Account> root = query.from(Account.class);
			query.multiselect(root.get("FullName"));
			query.where(builder.equal(root.get("AccountID"), id));
			String FullName = session.createQuery(query).uniqueResult();

			return FullName;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Account> Get_From_Month() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account>  query = builder.createQuery(Account.class);
			Root<Account>  root = query.from(Account.class);
			query.select(root);
			
			Expression<Integer> month = builder.function("month", Integer.class, root.get("createDate"));
			Expression<Integer> monthcurrent = builder.function("month", Integer.class, builder.currentDate());
			query.where(builder.equal(month,monthcurrent));		
			List<Account> listAccount = session.createQuery(query).setFirstResult(2).list();
			return listAccount;
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
