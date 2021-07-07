package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.ultis.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		this.hibernateUtils = HibernateUtils.getInstance();
	}
	
	public List<Account> getAllAccount(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Account> query = session.createQuery("FROM Account ORDER BY AccountID");
			return query.list();
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	public Account Get_AccountByID(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			String hql = "FROM  Account As a WHERE  a.AccountID = :id";
			Query<Account> query = session.createQuery(hql,Account.class);
			query.setParameter("id", id);
			Account account = query.uniqueResult();
			return account;
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	
	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.query.Query;
	import com.vti.entity.Account;
	import com.vti.ultis.HibernateUtils;
	public class AccountRepository {
	private HibernateUtils hibernateUtils;
	public AccountRepository() {
	hibernateUtils = HibernateUtils.getInstance();
	} @
	SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {
	Session session = null;
	try {
	// get sessionsession = hibernateUtils.openSession();
	// create hql query
	Query<Account> query = session.createQuery("FROM Account
	order by id");
	return query.list();
	} finally {
	if (session != null) {
	session.close();
	}
	}
	}
}
