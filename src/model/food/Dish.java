package model.food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Calculating;

public class Dish implements Calculating, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4863063280244027417L;
	private List<PartOfTheDish> ingredients;
	private String name;
	private Counter counter;
	private double weight;
	
	public Dish() {
		
	}

	
	public Dish(String name, PartOfTheDish... ingredients) {
		this.name = name;
		this.weight = 0;
		this.counter = new Counter();
		this.ingredients = new ArrayList<PartOfTheDish>();
		for (int i = 0; i < ingredients.length; i++) {
			this.ingredients.add(ingredients[i]);
			this.weight += ingredients[i].getMass();
		}
		calculateFeatures();
	}
	
	
	public List<PartOfTheDish> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<PartOfTheDish> ingredients) {
		this.ingredients = ingredients;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public void calculateFeatures() {
		for (Iterator<PartOfTheDish> iterator = ingredients.iterator(); iterator.hasNext();) {
			PartOfTheDish ingredient = (PartOfTheDish) iterator.next();
			this.counter.addCalories(ingredient.getCounter().getCalories());
			this.counter.addCarbons(ingredient.getCounter().getCarbohydrates());
			this.counter.addFat(ingredient.getCounter().getFat());
			this.counter.addProteins(ingredient.getCounter().getProteins());
		}

	}

}
