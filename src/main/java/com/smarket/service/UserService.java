package com.smarket.service;

import java.util.List;

import com.smarket.model.Meal;
import com.smarket.model.User;

public interface UserService {
	
	List<User> getUsers();
	User getUserById(Long id);
	User getUserByEmail(String emailAddress);
	User createUser(User newUser);
	List<Meal> getAllMeals(Long userId);

}
