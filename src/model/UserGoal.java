package model;

import java.io.Serializable;

import main.AppConstants;

public class UserGoal  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1729947881455592273L;
	private double caloriesNeed; // count of calories user need to take a day
	private double proteinsNeed; // count of proteins user need to take a day
	private double fatNeed; // count of fats user need to take a day
	private double carbohydratesNeed; // count of carbohydrates user need to take a day
	
	
	public UserGoal() {
		
	}
	

	public UserGoal(int goal, double weight, double lifeStyle) {
		double caloriesNeed = (0.55 * weight + 2.8) * 240 * lifeStyle;
		if(goal == AppConstants.LOSEWEIGHT) {
			this.caloriesNeed = caloriesNeed * 0.87;
			this.proteinsNeed = this.caloriesNeed * 0.3;
			this.fatNeed = this.caloriesNeed * 0.25;
			this.carbohydratesNeed = this.caloriesNeed * 0.45;
		} else if(goal == AppConstants.KEEPFIT) {
			this.caloriesNeed = caloriesNeed;
			this.proteinsNeed = this.caloriesNeed * 0.3;
			this.fatNeed = this.caloriesNeed * 0.3;
			this.carbohydratesNeed = this.caloriesNeed * 0.4;
		} else if(goal == AppConstants.GAINWEIGHT) {
			this.caloriesNeed = caloriesNeed * 1.15;
			this.proteinsNeed = this.caloriesNeed * 0.35;
			this.fatNeed = this.caloriesNeed * 0.30;
			this.carbohydratesNeed = this.caloriesNeed * 0.50;
		} 
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
