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
	private List<Ingredient> ingredients;
	private String name;
	private Counter counter;
	private double weight;
	
	public Dish() {
		
	}

	
	public Dish(String name, double weight, Ingredient... ingredients) {
		this.name = name;
		this.weight = weight;
		this.ingredients = new ArrayList<Ingredient>();
		for (int i = 0; i < ingredients.length; i++) {
			this.ingredients.add(ingredients[i]);
		}
	}
	
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
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
		for (Iterator iterator = ingredients.iterator(); iterator.hasNext();) {
			Ingredient ingredient = (Ingredient) iterator.next();
			this.counter.setCalories((ingredient.getFeature().getCaloriesContent() * this.weight) / 100);
			this.counter.setCarbohydrates((ingredient.getFeature().getHydrocarbonatesContent() * this.weight) / 100);
			this.counter.setFat((ingredient.getFeature().getFatContent() * this.weight) / 100);
			this.counter.setProteins((ingredient.getFeature().getProteinsContent() * this.weight) / 100);
		}

	}

}
