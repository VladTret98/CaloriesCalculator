package model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Владислав
 *	
 */
public class CalCalculator implements Serializable {
	
	private static final long serialVersionUID = 3921001348348161791L;
	
	

	private UserGoal userGoal;		//contains info about count of calories, proteins etc. user need to take a day
	
	

	public CalCalculator() {

	}
	
	public CalCalculator(UserGoal goal) {
		this.userGoal = goal;
	}
	
	
	public double caloriesEaten(Day day) {
		return (day.getCounter().getCalories()) / this.userGoal.getCaloriesNeed();
	}

	public double fatsEaten(Day day) {
		return (day.getCounter().getFat()) / this.userGoal.getFatNeed();
	}

	public double proteinsEaten(Day day) {
		return (day.getCounter().getProteins()) / this.userGoal.getProteinsNeed();
	}

	public double carbohydratesEaten(Day day) {
		return (day.getCounter().getCarbohydrates()) / this.userGoal.getCarbohydratesNeed();
	}

	public UserGoal getUserGoal() {
		return userGoal;
	}

	public void setUserGoal(UserGoal userGoal) {
		this.userGoal = userGoal;
	}

}
