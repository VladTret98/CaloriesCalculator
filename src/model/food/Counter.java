package model.food;

import java.io.Serializable;

public class Counter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6553702589490237240L;
	private double caloriesCount;
	private double fatCount;
	private double proteinsCount;
	private double carbohydratesCount;

	public Counter() {
		super();
		this.caloriesCount = 0d;
		this.fatCount = 0d;
		this.proteinsCount = 0d;
		this.carbohydratesCount = 0d;
	}

	public Counter(double caloriesCount, double fatCount, double proteinsCount, double carbohydratesCount) {
		super();
		this.caloriesCount = caloriesCount;
		this.fatCount = fatCount;
		this.proteinsCount = proteinsCount;
		this.carbohydratesCount = carbohydratesCount;
	}

	public void addCalories(double calories) {
		this.caloriesCount += calories;
	}

	public void addProteins(double proteins) {
		this.proteinsCount += proteins;
	}

	public void addFat(double fat) {
		this.fatCount += fat;
	}

	public void addCarbons(double Carb) {
		this.carbohydratesCount += Carb;
	}

	public double getCalories() {
		return caloriesCount;
	}

	public void setCalories(double calories) {
		this.caloriesCount = calories;
	}

	public double getFat() {
		return fatCount;
	}

	public void setFat(double fat) {
		this.fatCount = fat;
	}

	public double getProteins() {
		return proteinsCount;
	}

	public void setProteins(double proteins) {
		this.proteinsCount = proteins;
	}

	public double getCarbohydrates() {
		return carbohydratesCount;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydratesCount = carbohydrates;
	}

}
