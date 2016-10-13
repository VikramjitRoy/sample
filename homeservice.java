package com.mindtree.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.mindtree.entity.Task;


public interface HomeService {
	
	public List<Task> getTaskInbox(String email,SessionFactory sessionFactory);
	public List<Task> getTaskToday(String email);
	public List<Task> getTaskWeekly(String email);
	public List<Task> getTaskByProjects(String email,String project);
	public List<Task> getTaskByPriority(String email,int priority); 
}
