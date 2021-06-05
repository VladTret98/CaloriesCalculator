package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.food.Counter;
import model.food.Dish;

public class Day implements Serializable, Calculating {

	private static final long serialVersionUID = 1222525956495456690L;
	private List<Dish> dishes;
	private Date date;
	private Counter counter;
	public DayComparator comp;

	public Day() {
		this.date = new Date();
		DayComparator comp = new DayComparator();
		this.comp = comp;
		this.counter = new Counter();
	}

	public Day(Dish... dishes) {
		DayComparator comp = new DayComparator();
		this.comp = comp;
		this.counter = new Counter();
		this.date = new Date();
		this.dishes = new ArrayList<Dish>();
		for (Dish dish : dishes) {
			this.dishes.add(dish);
		}
		calculateFeatures();
	}

	public void addDish(Dish dish) {
		this.dishes.add(dish);
		this.counter.addCalories(dish.getCounter().getCalories());
		this.counter.addCarbons(dish.getCounter().getCarbohydrates());
		this.counter.addFat(dish.getCounter().getFat());
		this.counter.addProteins(dish.getCounter().getProteins());
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void calculateFeatures() {
		for (Iterator<Dish> iterator = this.dishes.iterator(); iterator.hasNext();) {
			Dish dish = (Dish) iterator.next();
			this.counter.addCalories(dish.getCounter().getCalories());
			this.counter.addCarbons(dish.getCounter().getCarbohydrates());
			this.counter.addFat(dish.getCounter().getFat());
			this.counter.addProteins(dish.getCounter().getProteins());
		}

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

class DayComparator implements Comparator<Day>, Serializable {

	@Override
	public int compare(Day o1, Day o2) {
		return o1.getDate().getDate() - o2.getDate().getDate();
	}

}
