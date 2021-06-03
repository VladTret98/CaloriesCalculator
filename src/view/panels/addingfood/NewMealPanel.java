package view.panels.addingfood;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import view.controller.MyActionListener;

public class NewMealPanel extends JPanel {
	private JTextField mealName;
	private List<NewDishPanel> newDishPanels;;
	private JButton addMealBtn, addDishBtn;
	private JScrollPane dishesPane;

	public NewMealPanel() {

	}

	public NewMealPanel(MyActionListener listener) {
		this.setLayout(new BorderLayout());

		this.newDishPanels = new ArrayList<NewDishPanel>();

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		this.dishesPane = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		for (int i = 0; i < 2; i++) {
			NewDishPanel panel = new NewDishPanel();
			this.newDishPanels.add(panel);
			p.add(panel);
		}

		this.addMealBtn = new JButton("Добавить");
		this.addMealBtn.addActionListener(listener);
		//this.addMealBtn.setActionCommand(listener.ADDMEAL);

		this.addDishBtn = new JButton();
		this.addDishBtn.setActionCommand("Добавить блюдо");
		this.addDishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewDishPanel panel = new NewDishPanel();
				newDishPanels.add(panel);
				p.add(panel);
				repaint();
				revalidate();
			}
		});
		
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(new JLabel("Введите название"));
		this.mealName = new JTextField();
		panel.add(this.mealName);
		
		this.add(panel, BorderLayout.NORTH);
		this.add(dishesPane, BorderLayout.CENTER);
		this.add(addMealBtn);
	}

	public JTextField getMealName() {
		return mealName;
	}

	public void setMealName(JTextField mealName) {
		this.mealName = mealName;
	}

	public List<NewDishPanel> getNewDishPanels() {
		return newDishPanels;
	}

	public void setNewDishPanels(List<NewDishPanel> newDishPanels) {
		this.newDishPanels = newDishPanels;
	}

	public JButton getAddMealBtn() {
		return addMealBtn;
	}

	public void setAddMealBtn(JButton addMealBtn) {
		this.addMealBtn = addMealBtn;
	}

	public JButton getAddDishBtn() {
		return addDishBtn;
	}

	public void setAddDishBtn(JButton addDishBtn) {
		this.addDishBtn = addDishBtn;
	}

	public JScrollPane getDishesPane() {
		return dishesPane;
	}

	public void setDishesPane(JScrollPane dishesPane) {
		this.dishesPane = dishesPane;
	}

}
