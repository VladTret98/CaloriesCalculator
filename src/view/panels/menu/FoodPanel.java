package view.panels.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.food.Dish;
import model.food.Meal;

public class FoodPanel extends JPanel {
	private Meal meal;

	public FoodPanel() {
		super();
		this.setLayout(new BorderLayout());
		JLabel lab = new JLabel("Ничего не выбрано");
		this.add(lab);
	}
	
	public void init() {
		this.removeAll();
		this.add(new JLabel("Ничего не выбрано"));
		this.repaint();
		this.revalidate();
	}

	public void setMealInfo(Meal meal) {
		this.removeAll();
		JPanel main = new JPanel(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(meal.getDishes().size(), 1));

		for (Iterator<Dish> iterator = meal.getDishes().iterator(); iterator.hasNext();) {
			Dish dish = (Dish) iterator.next();
			JPanel dishPanel = new JPanel(new BorderLayout());
			dishPanel.add(new JLabel(dish.getName()));
			dishPanel.add(new JLabel(dish.toString()), BorderLayout.CENTER);
			panel.add(dishPanel);
		}

		JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		main.add(pane);
		this.add(pane, BorderLayout.CENTER);

		this.repaint();
		this.revalidate();
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

}
