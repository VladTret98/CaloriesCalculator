package model.food;

import java.io.Serializable;

public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1857394288290210220L;

	private String name;

	private IngredientFeatures feature;

	public Ingredient() {

	}

	public Ingredient(String name, int calories, int proteins, int fat, int carbohydrates) {
		this.name = name;
		this.feature = new IngredientFeatures(calories, proteins, fat, carbohydrates);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IngredientFeatures getFeature() {
		return feature;
	}

	public void setFeature(IngredientFeatures kbju) {
		this.feature = kbju;
	}

}
