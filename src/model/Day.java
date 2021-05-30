package model;

import java.io.Serializable;
import java.util.List;

import model.food.Counter;
import model.food.Meal;

public class Day implements Serializable {

	private static final long serialVersionUID = 1222525956495456690L;
	private List<Meal> meals;
	// private Date date;
	private Counter counter;

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

}
