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

	public Ingredient(String name, double calories, double proteins, double fat, double carbohydrates) {
		this.name = name;
		this.feature = new IngredientFeatures(calories, proteins, fat, carbohydrates);
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", feature=" + feature + "]";
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
