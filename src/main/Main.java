package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.CalCalculator;
import model.Day;
import model.MainCalculator;
import model.User;
import model.UserGoal;
import model.food.Dish;
import model.food.Ingredient;
import model.food.Meal;
import model.food.PartOfTheDish;
import view.Frame;
import view.controller.MyActionListener;

public class Main {

	public static void main(String[] args) {
//		try {
//			File file = new File("Data.txt");
//			
//		} catch(IOException e) {
//			
//		} finally {
//			
//		}
		MainCalculator calc = init();
		MyActionListener lis = new MyActionListener();
		lis.setCalculator(calc);
		Frame frame = new Frame();
		frame.init(lis, calc.getUsers().get(0));
		lis.setFrame(frame);
		int x = 5;
	}

	public static MainCalculator init() {

		Ingredient i1 = new Ingredient("Морковь", 85, 15, 3, 32);
		Ingredient i2 = new Ingredient("Лук", 58, 25, 0.9, 30);
		Ingredient i3 = new Ingredient("Куриное филе", 135, 32, 13, 45);

		PartOfTheDish p1 = new PartOfTheDish(i1, 120);
		PartOfTheDish p2 = new PartOfTheDish(i2, 100);
		PartOfTheDish p3 = new PartOfTheDish(i3, 120);

		Dish d = new Dish("Жаренкая грудка", p1, p2, p3);

		Ingredient i11 = new Ingredient("Сыр", 110, 25, 38, 12);
		Ingredient i21 = new Ingredient("Свинина", 153, 25, 43, 45);
		Ingredient i31 = new Ingredient("Картошка", 320, 5.6, 25, 53);

		PartOfTheDish p11 = new PartOfTheDish(i11, 100);
		PartOfTheDish p21 = new PartOfTheDish(i21, 900);
		PartOfTheDish p31 = new PartOfTheDish(i31, 150);

		Dish d1 = new Dish("Запеченая свинина", p11, p21, p31);

		Meal meal = new Meal("Завтрак", d, d1);

		Day day = new Day(meal);

		UserGoal g = new UserGoal(3, 80, 1.3);
		List<Day> days = new ArrayList<>();
		days.add(day);
		CalCalculator calc = new CalCalculator(g);

		User user = new User("Владислав", 80, g);
		user.getDays().add(day);
		
		MainCalculator calc2 = new MainCalculator(user);
		
		return calc2;
	}

}
