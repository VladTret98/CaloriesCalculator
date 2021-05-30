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
	private List<PartOfTheDish> ingredients;
	private String name;
	private Counter counter;

	public Meal() {

	}

	public Meal(String name, PartOfTheDish... ingredients) {
		this.name = name;
		this.counter = new Counter();
		this.ingredients = new ArrayList<PartOfTheDish>();
		for (int i = 0; i < ingredients.length; i++) {
			this.ingredients.add(ingredients[i]);
		}

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
		for (Iterator<PartOfTheDish> iterator = ingredients.iterator(); iterator.hasNext();) {
			PartOfTheDish partOfTheDish = (PartOfTheDish) iterator.next();
			this.counter.addCalories(partOfTheDish.getCounter().getCalories());
			this.counter.addCarbons(partOfTheDish.getCounter().getCarbohydrates());
			this.counter.addProteins(partOfTheDish.getCounter().getProteins());
			this.counter.addFat(partOfTheDish.getCounter().getFat());
		}

	}

}
