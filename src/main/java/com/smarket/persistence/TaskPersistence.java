package com.smarket.persistence;

import java.util.List;

import com.smarket.model.Task;

public interface TaskPersistence extends GenericDAO<Task, Long>{

	List<Task> getAllTasks();
	List<Task> getAllTasks(String userName);
}