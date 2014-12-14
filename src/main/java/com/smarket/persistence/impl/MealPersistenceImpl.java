package com.smarket.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smarket.model.Meal;
import com.smarket.persistence.MealPersistence;

/**
 * 
 * @author anirudh
 *
 */
@Repository
@Transactional
public class MealPersistenceImpl extends GenericDAOImpl<Meal, Long> implements MealPersistence{

	@Override
	public List<Meal> getAllMeals(Long userId) {
		Session sess = getSession();
		List<Meal> meals = sess.createQuery(
			    "from Meal as meal where meal.createdBy = ?")
			    .setLong(0, userId).list();
		return meals;
	}

}
