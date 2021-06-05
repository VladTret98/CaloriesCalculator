package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.food.Dish;

public class User implements Serializable {
	private static final long serialVersionUID = -1416033834503068700L;

	private String name;

	private double weight;
	
	private Day activeDay;

	private List<Day> days;
	
	private CalCalculator calc;

	public User() {

	}

	public User(String name, double weight, UserGoal goal) {
		this.name = name;
		this.weight = weight;
		this.calc = new CalCalculator(goal);
		this.days = new ArrayList<Day>();
		this.activeDay = new Day();
		this.days.add(activeDay);
	}

	public Day getPreviousDay() {
		for (Iterator<Day> iterator = days.iterator(); iterator.hasNext();) {
			Day day = (Day) iterator.next();
			if (day.getDate().getDate() == this.activeDay.getDate().getDate()) {
				if (this.days.indexOf(day) == 0) {
					return this.days.get(this.days.size() - 1);
				} else {
					return this.days.get(days.indexOf(day) - 1);
				}
			}
		}
		return this.activeDay;
	}

	public Day getNextDay() {
		for (Iterator<Day> iterator = days.iterator(); iterator.hasNext();) {
			Day day = (Day) iterator.next();
			if (day.getDate().getDate() == this.activeDay.getDate().getDate()) {
				if (this.days.indexOf(day) == this.days.size() - 1) {
					return this.days.get(0);
				} else {
					return this.days.get(days.indexOf(day) + 1);
				}
			}
		}
		return this.activeDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public CalCalculator getCalc() {
		return calc;
	}

	public void setCalc(CalCalculator calc) {
		this.calc = calc;
	}

	public Day getActiveDay() {
		return activeDay;
	}

	public void setActiveDay(Day activeDay) {
		this.activeDay = activeDay;
	}

}
