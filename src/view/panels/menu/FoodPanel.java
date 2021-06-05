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
import model.food.Ingredient;
import model.food.PartOfTheDish;

public class FoodPanel extends JPanel {
	private Dish dish;

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

	public void setDishInfo(Dish dish) {
		this.removeAll();
		JPanel main = new JPanel(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(dish.getIngredients().size(), 1));

		for (Iterator<PartOfTheDish> iterator = dish.getIngredients().iterator(); iterator.hasNext();) {
			PartOfTheDish part = (PartOfTheDish) iterator.next();
			JPanel dishPanel = new JPanel(new BorderLayout());
			dishPanel.add(new JLabel(part.getIngredient().getName()));
			dishPanel.add(new JLabel(part.toString()), BorderLayout.CENTER);
			panel.add(dishPanel);
		}

		JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		main.add(pane);
		this.add(pane, BorderLayout.CENTER);

		this.repaint();
		this.revalidate();
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

}
