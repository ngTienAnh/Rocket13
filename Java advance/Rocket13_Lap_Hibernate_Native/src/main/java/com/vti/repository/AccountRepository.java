package com.vti.repository;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Position.positionName;
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

			NativeQuery query = session.createNativeQuery("SELECT a.AccountID, a.Email, a.Username,"
					+ "a.FullName, d.DepartmentName, p.PositionName FROM account a \r\n"
					+ "INNER JOIN department d ON a.DepartmentID = d.DepartmentID\r\n"
					+ "INNER JOIN position p ON a.PositionID = p.PositionID;");

			List<Account> listAccount = new ArrayList<Account>();
			List<Object[]> listOpject = query.getResultList();
			for (Object opject[] : listOpject) {
				Account account = new Account();
				account.setAccountID(Short.parseShort(opject[0].toString()));
				account.setEmail(opject[1].toString());
				account.setUsername(opject[2].toString());
				account.setFullName(opject[3].toString());
				account.setDepartment(new Department(opject[4].toString()));
				account.setPosition(new Position(positionName.valueOf(opject[5].toString())));
				listAccount.add(account);
			}

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

			NativeQuery query = session.createNativeQuery("SELECT a.AccountID, a.Email, a.Username,"
					+ "a.FullName, d.DepartmentName, p.PositionName FROM account a \r\n"
					+ "INNER JOIN department d ON a.DepartmentID = d.DepartmentID\r\n"
					+ "INNER JOIN position p ON a.PositionID = p.PositionID; where a.AccountID = ?");

			query.setParameter(1, id);
			Object[] opject = (Object[]) query.getSingleResult();
			Account account = new Account();
			account.setAccountID(Short.parseShort(opject[0].toString()));
			account.setEmail(opject[1].toString());
			account.setUsername(opject[2].toString());
			account.setFullName(opject[3].toString());
			account.setDepartment(new Department(opject[4].toString()));
			account.setPosition(new Position(positionName.valueOf(opject[5].toString())));

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
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			query.select(root);

			Expression<Integer> month = builder.function("month", Integer.class, root.get("createDate"));
			Expression<Integer> monthcurrent = builder.function("month", Integer.class, builder.currentDate());
			query.where(builder.equal(month, monthcurrent));
			List<Account> listAccount = session.createQuery(query).setFirstResult(2).list();
			return listAccount;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
