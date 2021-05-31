package model;

import java.io.Serializable;

public class CalCalculator implements Serializable{ /**     	// Calories Calculator
	 * 
	 */
	private static final long serialVersionUID = 3921001348348161791L;

	
	private double caloriesNeed; // count of calories need a day
	private double proteinsNeed; // count of proteins need a day
	private double fatNeed; // count of fats need a day
	private double carbohydratesNeed; // count of carbohydrates need a day

	public CalCalculator() {

	}

	public CalCalculator(double calories, double proteins, double fat, double hydrocarbonates) {
		this.caloriesNeed = calories;
		this.proteinsNeed = proteins;
		this.fatNeed = fat;
		this.carbohydratesNeed = hydrocarbonates;
	}

	public double caloriesEaten(Day day) {
		return (this.caloriesNeed / day.getCounter().getCalories()) * 100 ;
	}

	public double fatsEaten(Day day) {
		return (this.fatNeed / day.getCounter().getFat()) * 100 ;
	}

	public double proteinsEaten(Day day) {
		return (this.proteinsNeed / day.getCounter().getProteins()) * 100 ;
	}

	public double carbohydratesEaten(Day day) {
		return (this.carbohydratesNeed / day.getCounter().getCarbohydrates()) * 100 ;
	}

	public double getCaloriesNeed() {
		return caloriesNeed;
	}

	public void setCaloriesNeed(double caloriesNeed) {
		this.caloriesNeed = caloriesNeed;
	}

	public double getProteinsNeed() {
		return proteinsNeed;
	}

	public void setProteinsNeed(double proteinsNeed) {
		this.proteinsNeed = proteinsNeed;
	}

	public double getFatNeed() {
		return fatNeed;
	}

	public void setFatNeed(double fatNeed) {
		this.fatNeed = fatNeed;
	}

	public double getCarbohydratesNeed() {
		return carbohydratesNeed;
	}

	public void setCarbohydratesNeed(double carbohydratesNeed) {
		this.carbohydratesNeed = carbohydratesNeed;
	}

}
