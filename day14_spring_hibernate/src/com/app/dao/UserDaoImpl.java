package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;

@Repository // mandatory to tell SC that following class is DAO n enables exc translation
			// mechanism
public class UserDaoImpl implements IUserDao {
	// dependency
	@Autowired // autowire=byType
	private SessionFactory sf;

	@Override
	public Vendor authenticateUser(String em, String pass) {
		String jpql = "select v from Vendor v where v.email = :em and v.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).
				setParameter("em", em).setParameter("pass", pass)
				.getSingleResult();
	}

}
