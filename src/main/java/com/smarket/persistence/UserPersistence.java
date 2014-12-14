package com.smarket.persistence;

import java.util.List;

import com.smarket.model.User;

public interface UserPersistence extends GenericDAO<User, Long>{
	List<User> getAllUsers();
	User getUserByEmail(String email);
}
