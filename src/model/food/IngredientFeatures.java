package model.food;

public class IngredientFeatures {
	private double caloriesContent;
	private double proteinsContent;
	private double fatContent;
	private double carbohydratesContent;

	public IngredientFeatures() {

	}

	public IngredientFeatures(double calories, double proteins, double fat, double hydrocarbonates) {
		this.caloriesContent = calories;
		this.proteinsContent = proteins;
		this.fatContent = fat;
		this.carbohydratesContent = hydrocarbonates;
	}

	public double getCaloriesContent() {
		return caloriesContent;
	}

	public void setCaloriesContent(double caloriesContent) {
		this.caloriesContent = caloriesContent;
	}

	public double getProteinsContent() {
		return proteinsContent;
	}

	public void setProteinsContent(double proteinsContent) {
		this.proteinsContent = proteinsContent;
	}

	public double getFatContent() {
		return fatContent;
	}

	public void setFatContent(double fatContent) {
		this.fatContent = fatContent;
	}

	public double getHydrocarbonatesContent() {
		return carbohydratesContent;
	}

	public void setHydrocarbonatesContent(double hydrocarbonatesContent) {
		this.carbohydratesContent = hydrocarbonatesContent;
	}

}
