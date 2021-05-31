package model.food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Calculating;

public class Meal implements Calculating, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6384809017792602982L;
	private List<Dish> dishes;
	private String name;
	private Counter counter;

	public Meal() {

	}

	public Meal(String name, Dish... dishes) {
		this.name = name;
		this.counter = new Counter();
		this.dishes = new ArrayList<Dish>();
		for (int i = 0; i < dishes.length; i++) {
			this.dishes.add(dishes[i]);
		}

	}
	
	
	
	/**
	 * @param dish new dish added to a meal, this method adds features of dish to sum of features in one meal
	 */
	public void addDish(Dish dish) {
		this.dishes.add(dish);
		this.counter.addCalories(dish.getCounter().getCalories());
		this.counter.addCarbons(dish.getCounter().getCarbohydrates());
		this.counter.addFat(dish.getCounter().getFat());
		this.counter.addProteins(dish.getCounter().getProteins());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void calculateFeatures() {
		for (Iterator<Dish> iterator = dishes.iterator(); iterator.hasNext();) {
			Dish dish = (Dish) iterator.next();
			this.counter.addCalories(dish.getCounter().getCalories());
			this.counter.addCarbons(dish.getCounter().getCarbohydrates());
			this.counter.addProteins(dish.getCounter().getProteins());
			this.counter.addFat(dish.getCounter().getFat());
		}

	}

}
