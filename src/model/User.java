package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	private static final long serialVersionUID = -1416033834503068700L;
	private String name;
	private List<Day> days;
	private CalCalculator calc;
	private double weight;

	public User() {

	}

	public User(String name, double weight, CalCalculator calc) {
		this.name = name;
		this.weight = weight;
		this.calc = calc;
		this.days = new ArrayList<Day>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public CalCalculator getFeature() {
		return calc;
	}

	public void setFeature(CalCalculator feature) {
		this.calc = feature;
	}

	public CalCalculator getCalc() {
		return calc;
	}

	public void setCalc(CalCalculator calc) {
		this.calc = calc;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
