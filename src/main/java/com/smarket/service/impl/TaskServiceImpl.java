package com.smarket.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarket.common.CommonUtils;
import com.smarket.model.Task;
import com.smarket.model.User;
import com.smarket.persistence.TaskPersistence;
import com.smarket.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	
	//this is autowiring by Type, it just checks the implemented class of type
	@Autowired
	private TaskPersistence taskPersistence;
	
	public void saveTask(String name,String description,String date,String personName,User user) throws ParseException{
		Task task = new Task();
		task.setName(name);
		task.setDescription(description);
		task.setDate(CommonUtils.getFormattedDate(date));
		task.setCreatedBy(user);
		
		taskPersistence.makePersistant(task);
	}
	
	public List<Task> getTasksOfTheDay(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Task> getAllTasks() {
		return taskPersistence.getAllTasks();
	}
	@Override
	public List<Task> getAllTasks(String userName) {
		return taskPersistence.getAllTasks(userName);
	}
	@Override
	public void deleteTask(Long id) {
		Task task = taskPersistence.findById(id);
		taskPersistence.delete(task);
	}
	@Override
	public void saveTask(Task task) {
		taskPersistence.makePersistant(task);
	}
	@Override
	public Task getTask(Long id) {
		return taskPersistence.findById(id);
	}
	
	 public String getFirstNameOfTaskCreator(Long taskId){
		 return getTask(taskId).getCreatedBy().getFirstName();
	 }
	
}
