package model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private static final long serialVersionUID = -1416033834503068700L;
	private String name;
	private List<Day> days;
	private UserFeature feature;
	private double weight;

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

	public UserFeature getFeature() {
		return feature;
	}

	public void setFeature(UserFeature feature) {
		this.feature = feature;
	}

}
