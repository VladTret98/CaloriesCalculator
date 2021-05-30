package model;

public class UserFeature {
	private double caloriesNeed;
	private double proteinsNeed;
	private double fatNeed;
	private double carbohydratesNeed;

	public UserFeature() {

	}

	public UserFeature(double calories, double proteins, double fat, double hydrocarbonates) {
		this.caloriesNeed = calories;
		this.proteinsNeed = proteins;
		this.fatNeed = fat;
		this.carbohydratesNeed = hydrocarbonates;
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
