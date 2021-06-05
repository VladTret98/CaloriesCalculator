package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import model.CalCalculator;
import model.Day;
import model.MainCalculator;
import model.User;
import model.UserGoal;
import model.food.Dish;
import model.food.Ingredient;
import model.food.PartOfTheDish;
import view.Frame;
import view.controller.MyActionListener;

public class Main {

	public static void main(String[] args) {
		MainCalculator calc = null;
		File file = new File(MainCalculator.getPATH());
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			calc = (MainCalculator) ois.readObject();
			ois.close();
			fis.close();
		} catch(IOException e) {
			//calc = init();											Расскомментируй строки 39,41,45 и удали 44
		} catch (ClassNotFoundException e) {						// и сможешь зайти под иенем влад и попереключать дни
			//calc = init();
		}
		MyActionListener lis = new MyActionListener();
		if(calc == null) {
			lis.setCalculator(new MainCalculator());
		} else {
			lis.setCalculator(calc);
		}
		Frame frame = new Frame();
		frame.init(lis);
		lis.setFrame(frame);
	}

	public static MainCalculator init() {

		Ingredient i1 = new Ingredient("Морковь", 15, 6, 3, 10);
		Ingredient i2 = new Ingredient("Лук", 13, 15, 0.9, 11);
		Ingredient i3 = new Ingredient("Куриное филе", 8, 12, 6, 4);

		PartOfTheDish p1 = new PartOfTheDish(i1, 120);
		PartOfTheDish p2 = new PartOfTheDish(i2, 100);
		PartOfTheDish p3 = new PartOfTheDish(i3, 120);

		Dish d = new Dish("Жаренкая грудка", p1, p2, p3);

		Ingredient i11 = new Ingredient("Сыр", 10, 8, 6, 11);
		Ingredient i21 = new Ingredient("Свинина", 8, 10, 5, 4);
		Ingredient i31 = new Ingredient("Картошка", 8, 5.6, 2, 4);

		PartOfTheDish p11 = new PartOfTheDish(i11, 100);
		PartOfTheDish p21 = new PartOfTheDish(i21, 900);
		PartOfTheDish p31 = new PartOfTheDish(i31, 150);

		Dish d1 = new Dish("Запеченая свинина", p11, p21, p31);

		Day day = new Day(d);
		
		day.setDate(new Date(1614121212121L));
		
		Day day2 = new Day(d1);
		day2.setDate(new Date(1614171212121L));

		UserGoal g = new UserGoal(3, 80, 1.3);
		List<Day> days = new ArrayList<>();
		days.add(day);
		days.add(day2);

		User user = new User("Владислав", 80, g);
		
		user.getDays().add(day);
		user.getDays().add(day2);
		user.setActiveDay(day2);
		user.getDays().sort(day.comp);
		
		MainCalculator calc2 = new MainCalculator(user);
		
		return calc2;
	}
	
	public static void saveProgram(MyActionListener listener) {
		try {
			File file = new File(MainCalculator.getPATH());
			FileOutputStream fos = new FileOutputStream(file, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);	
			oos.writeObject(listener.getCalculator());
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
