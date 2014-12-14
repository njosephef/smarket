package com.smarket.persistence;

import java.util.List;

import com.smarket.model.Meal;

public interface MealPersistence extends GenericDAO<Meal, Long> {
	List<Meal> getAllMeals(Long userId);
}
