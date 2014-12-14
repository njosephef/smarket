package com.smarket.persistence.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.smarket.model.User;
import com.smarket.persistence.UserPersistence;

@Repository
public class UserPersistenceImpl extends GenericDAOImpl<User, Long> implements UserPersistence{
	
	

	public List<User> getAllUsers() {
	    Query q = getSession().createQuery("from User");
	    List<User> allUsers = (List<User>) q.list();
	    return allUsers;
	}

	@Override
	public User getUserByEmail(String email) {
		Session sess = getSession();
		User user = (User) sess.createQuery(
			    "from User as user where user.email = ?")
			    .setString(0, email).uniqueResult();
		return user;
	}


}
