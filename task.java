package com.mindtree.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="content")
	private String content;
	@Column(name="date")
	private Timestamp date;
	@Column(name="priority")
	private String priority;
	@Column(name="project")
	private String project;
	
	/**
	 * 
	 */
	public Task() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param content
	 * @param date
	 * @param priority
	 * @param project
	 */
	public Task(String content, Timestamp date, String priority, String project) {
		super();
		this.content = content;
		this.date = date;
		this.priority = priority;
		this.project = project;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	
	
}
