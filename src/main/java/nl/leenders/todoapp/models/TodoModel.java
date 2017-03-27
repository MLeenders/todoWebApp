package nl.leenders.todoapp.models;

import java.util.Date;

public class TodoModel {

	
	private int id;
	private String description;
	private String category;
	private Date dueDate;
	private boolean completed;
	
	//we need an empty constructor
	public TodoModel() { }
		
	public TodoModel(int id, String description, String category, Date dueDate) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
		this.dueDate = dueDate;
		
	}


	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
}
