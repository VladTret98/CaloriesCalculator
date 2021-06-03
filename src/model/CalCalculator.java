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
		return (this.userGoal.getCaloriesNeed() / day.getCounter().getCalories()) * 100 ;
	}

	public double fatsEaten(Day day) {
		return (this.userGoal.getFatNeed() / day.getCounter().getFat()) * 100 ;
	}

	public double proteinsEaten(Day day) {
		return (this.userGoal.getProteinsNeed() / day.getCounter().getProteins()) * 100 ;
	}

	public double carbohydratesEaten(Day day) {
		return (this.userGoal.getCarbohydratesNeed() / day.getCounter().getCarbohydrates()) * 100 ;
	}

	public UserGoal getUserGoal() {
		return userGoal;
	}

	public void setUserGoal(UserGoal userGoal) {
		this.userGoal = userGoal;
	}

}
