package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.food.Counter;
import model.food.Meal;

public class Day implements Serializable, Calculating {

	private static final long serialVersionUID = 1222525956495456690L;
	private List<Meal> meals;
	// private Date date;
	private Counter counter;
	
	public Day() {

	}
	
	public Day(Meal...meals) {
		this.counter = new Counter();
		this.meals = new ArrayList<Meal>();
		for (Meal meal : meals) {
			this.meals.add(meal);
		}
		calculateFeatures();
	}
	
	public void addMeal(Meal meal) {
		this.meals.add(meal);
		this.counter.addCalories(meal.getCounter().getCalories());
		this.counter.addCarbons(meal.getCounter().getCarbohydrates());
		this.counter.addFat(meal.getCounter().getFat());
		this.counter.addProteins(meal.getCounter().getProteins());
	}

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

	@Override
	public void calculateFeatures() {
		for (Iterator<Meal> iterator = this.meals.iterator(); iterator.hasNext();) {
			Meal meal = (Meal) iterator.next();
			this.counter.addCalories(meal.getCounter().getCalories());
			this.counter.addCarbons(meal.getCounter().getCarbohydrates());
			this.counter.addFat(meal.getCounter().getFat());
			this.counter.addProteins(meal.getCounter().getProteins());
		}
		
	}

}
