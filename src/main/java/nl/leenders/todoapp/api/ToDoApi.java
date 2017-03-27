package nl.leenders.todoapp.api;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import nl.leenders.todoapp.models.TodoModel;


@Path("todo")
public class ToDoApi {
	
	static private ArrayList<TodoModel> todootjes = new ArrayList<TodoModel>();
	
	static  { 
		todootjes.add(new TodoModel(1, "boodschappen", "huishoudelijk", new Date()));
		todootjes.add(new TodoModel(2, "zitten", "chillen", new Date()));
		todootjes.add(new TodoModel(2, "in de zon zitten", "chillen", new Date()));
		
	}
	
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<TodoModel>  getTodoModel() { 
		
		todootjes.add(new TodoModel(1, "boodschappen", "huishoudelijk", new Date()));
		todootjes.add(new TodoModel(2, "zitten", "chillen", new Date()));
		todootjes.add(new TodoModel(2, "in de zon zitten", "chillen", new Date()));
		
		return todootjes;
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TodoModel getTodoModelById(@PathParam("id") int id){ 
		for (int i=0; i<todootjes.size(); i++) { 
			if (todootjes.get(i).getId() == id) { 
				return todootjes.get(i);
			}
		}
		
		// if not found -> return empty
		return new TodoModel();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addNewTodo(TodoModel newTodootje){ 
		
		todootjes.add(newTodootje); 
	}
	
	@PUT
	@Path("/complete/{id}")
	public void markTodoAsComplete(@PathParam("id") int id){ 
	// op zoek naar het todootje met id 'id' en markeer als compleet
		
		for (int i=0; i<todootjes.size(); i++) { 
			if (todootjes.get(i).getId() == id) { 
				todootjes.get(i).setCompleted(true);
				
			}
		
		} 
	
	}

	
	@DELETE
	@Path("/{id}")
	public void deleteTodo(@PathParam("id") int id){ 
		
		//op zoek naar id en delete deze
		for (int i=0; i<todootjes.size(); i++) { 
			if (todootjes.get(i).getId() == id) { 
				
				todootjes.remove(i);
			}
		
	}
	
} 
	
	@GET
	@Path("/filtered") 
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TodoModel> getFilteredTodos(@QueryParam("category") String category) { 
		
		
		
		ArrayList<TodoModel> filteredTodos = new ArrayList<TodoModel>();
		
		for (int i=0; i<todootjes.size(); i++) { 
			if (todootjes.get(i).getCategory().equals(category) ) { 
				 filteredTodos.add(todootjes.get(i));
			
			}
		
	}
		
		return filteredTodos;
	
		//Andere (en kortere, maar ingewikkeldere) manier van filteren:
		// return todootjes.stream().filter(todo -> todo.getCategory().
		//equalsIgnoreCase(category)).collect(Collectors.toList());
} 
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void changeTodo(@PathParam("id") int id, TodoModel aanTePassen){ 
		
		//op zoek naar id en pas aan
		for (int i=0; i<todootjes.size(); i++) { 
			if (todootjes.get(i).getId() == id) { 
				TodoModel oudModel = todootjes.get(i); 
				oudModel.setCategory(aanTePassen.getCategory());
				oudModel.setDescription(aanTePassen.getDescription());
				oudModel.setCompleted(aanTePassen.isCompleted());
				oudModel.setDueDate(aanTePassen.getDueDate());
				
			}
		}
	}	
}
	

	

	
	

