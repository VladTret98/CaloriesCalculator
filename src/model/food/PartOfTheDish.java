package model.food;

import java.io.Serializable;

import model.Calculating;

public class PartOfTheDish implements Calculating, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779289714507075766L;

	private Ingredient ingredient;

	private Counter counter;

	private double mass;

	public PartOfTheDish() {

	}

	public PartOfTheDish(Ingredient ingredient, double mass) {
		this.counter = new Counter();
		this.ingredient = ingredient;
		this.mass = mass;
		calculateFeatures();
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void calculateFeatures() {
		this.counter.setCalories((this.ingredient.getFeature().getCaloriesContent() * this.mass) / 100);
		this.counter.setProteins((this.ingredient.getFeature().getProteinsContent() * this.mass) / 100);
		this.counter.setFat((this.ingredient.getFeature().getFatContent() * this.mass) / 100);
		this.counter.setCarbohydrates((this.ingredient.getFeature().getHydrocarbonatesContent() * this.mass) / 100);

	}

}
