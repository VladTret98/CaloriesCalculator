package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.food.Counter;
import model.food.Dish;
import model.food.Ingredient;
import model.food.PartOfTheDish;
import view.panels.addingfood.IngredientPanel;
import view.panels.addingfood.NewDishPanel;

public class MainCalculator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7392222132375229520L;
	private final static String PATH = "Data.txt";
	private List<User> users;
	private User activeUser;
	private Set<Ingredient> ingredientsData;

	public MainCalculator() {
		this.users = new ArrayList<User>();
	}

	public MainCalculator(User... users) {
		if (users.length == 1) {
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
			if (name.toLowerCase().equals(user.getName().toLowerCase())) {
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

	public boolean addNewDish(NewDishPanel panel) {
		String dishName = panel.getNameField().getText();
		PartOfTheDish[] ingredients = new PartOfTheDish[panel.getIngredientsPanels().size()];
		for (int i = 0; i < ingredients.length; i++) {
			String nameOfIngredient = panel.getIngredientsPanels().get(i).getNameField().getText();
			if (this.ingredientsData != null) {
				if (findIngredient(nameOfIngredient) == null) {
					Ingredient ingr = createIngredient(panel.getIngredientsPanels().get(i));
					this.ingredientsData.add(ingr);
					double mass = Double.valueOf(panel.getIngredientsPanels().get(i).getMassField().getText());
					ingredients[i] = new PartOfTheDish(ingr, mass);
				} else {
					double mass = Double.valueOf(panel.getIngredientsPanels().get(i).getMassField().getText());
					ingredients[i] = new PartOfTheDish(findIngredient(nameOfIngredient), mass);
				}
			} else {
				this.ingredientsData = new HashSet<Ingredient>();
				this.ingredientsData.add(createIngredient(panel.getIngredientsPanels().get(i)));
				double mass = Double.valueOf(panel.getIngredientsPanels().get(i).getMassField().getText());
				ingredients[i] = new PartOfTheDish(createIngredient(panel.getIngredientsPanels().get(i)), mass);
			}
		}
		if (this.activeUser.getActiveDay().getDishes() != null) {
			if(this.activeUser.getActiveDay().getCounter() == null) {
				this.activeUser.getActiveDay().setCounter(new Counter());
			}
			this.activeUser.getActiveDay().addDish(new Dish(dishName, ingredients));
		} else {
			if(this.activeUser.getActiveDay().getCounter() == null) {
				this.activeUser.getActiveDay().setCounter(new Counter());
			}
			this.activeUser.getActiveDay().setDishes(new ArrayList<Dish>());
			Dish dish = new Dish(dishName, ingredients);
			this.activeUser.getActiveDay().addDish(dish);
		}
		return true;
	}

	public void changeActiveUser(User user) {
		this.activeUser = user;
	}

	private Ingredient findIngredient(String name) {
		for (Iterator<Ingredient> iterator = ingredientsData.iterator(); iterator.hasNext();) {
			Ingredient ingredient = (Ingredient) iterator.next();
			if (name.equalsIgnoreCase(ingredient.getName())) {
				return ingredient;
			}
		}
		return null;
	}

	private Ingredient createIngredient(IngredientPanel panel) {
		String name = panel.getNameField().getText();
		double calories = Double.valueOf(panel.getCaloriesfield().getText());
		double proteins = Double.valueOf(panel.getProteinsField().getText());
		double fats = Double.valueOf(panel.getFatField().getText());
		double carbons = Double.valueOf(panel.getCarbonsField().getText());
		Ingredient ingr = new Ingredient(name, calories, proteins, fats, carbons);
		return ingr;
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

	public static String getPATH() {
		return PATH;
	}

}
