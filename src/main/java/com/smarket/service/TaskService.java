package com.smarket.service;

import java.text.ParseException;
import java.util.List;

import com.smarket.model.Task;
import com.smarket.model.User;

public interface TaskService {
	
	void saveTask(String name,String description,String date,String personName,User user)throws ParseException;
	List<Task> getTasksOfTheDay(String date);
	List<Task> getAllTasks();
	List<Task> getAllTasks(String email);
	void deleteTask(Long id);
	void saveTask(Task task);
	Task getTask(Long id);
	String getFirstNameOfTaskCreator(Long taskId);
}
