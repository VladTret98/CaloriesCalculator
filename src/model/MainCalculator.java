package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainCalculator {
	private final String PATH = "Data.txt";
	private List<User> users;
	private User activeUser;
	
	
	public MainCalculator() {
		
	}
	
	public MainCalculator(User...users) {
		if(users.length == 1) {
			this.users = new ArrayList<User>();
			this.users.add(users[0]);
			this.activeUser = users[0];
		} else {
			this.users = new ArrayList<User>();
			for (User user : users) {
				this.users.add(user);
			}
		}
	}
	
	public User findUser(String name) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(name.toLowerCase().equals(user.getName().toLowerCase())) {
				this.activeUser = user;
				return user;
			}
		}		
		return null;
	}
	
	public void addNewUser(String name, double weight, int goal, double lifeStyle) {
		UserGoal userGoal = new UserGoal(goal, weight, lifeStyle); 
		User user = new User(name, weight, userGoal);
		this.users.add(user);
	}
	
	public void changeActiveUser(User user) {
		this.activeUser = user;
	}
	
	
	
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

	public String getPATH() {
		return PATH;
	}

}
