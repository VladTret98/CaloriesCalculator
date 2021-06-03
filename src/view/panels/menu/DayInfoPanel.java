package view.panels.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Day;
import model.User;
import model.food.Meal;
import view.controller.MyActionListener;

public class DayInfoPanel extends JPanel {
	private Meal selectedMeal;
	private JButton selectNextDayBtn, selectPreviousDayBtn, showInformationBtn, addMealBtn;
	private MyActionListener listener;

	public DayInfoPanel() {
		this.setLayout(new BorderLayout());
	}
	
	public void init(User user) {
		this.removeAll();
		createInfoPanel(user.getDays().get(user.getDays().size() - 1));
		this.repaint();
		this.revalidate();
	}

	public DayInfoPanel(MyActionListener listener, Day day) {
		this.setLayout(new BorderLayout());
		this.listener = listener;
		
		this.addMealBtn = new JButton("Добавить прием пищи");
		this.addMealBtn.setActionCommand(listener.ADDMEAL);
		this.addMealBtn.addActionListener(listener);

		this.selectNextDayBtn = new JButton("---->");
		this.selectNextDayBtn.setActionCommand(listener.GOTONEXTDAY);
		this.selectNextDayBtn.addActionListener(listener);

		this.selectPreviousDayBtn = new JButton("<----");
		this.selectPreviousDayBtn.setActionCommand(listener.GOTOPREVIOUSDAY);
		this.selectPreviousDayBtn.addActionListener(listener);

		createInfoPanel(day);
	}

	public void createInfoPanel(Day day) {
		JPanel infoPanel = new JPanel(new GridLayout(2, 1));

		JPanel panel = new JPanel(new GridLayout(day.getMeals().size() + 1, 1));

		JScrollPane pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		for (Iterator<Meal> iterator = day.getMeals().iterator(); iterator.hasNext();) {
			Meal meal = (Meal) iterator.next();
			panel.add(createMealsPanel(meal, listener));
		}

			
		
		JPanel dayChoicePanel = new JPanel(new GridLayout(1, 2, 30, 0));
		dayChoicePanel.add(this.selectPreviousDayBtn);
		dayChoicePanel.add(this.selectNextDayBtn);
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(this.addMealBtn, BorderLayout.NORTH);	
		p.add(dayChoicePanel, BorderLayout.CENTER);

		infoPanel.add(pane);
		infoPanel.add(p);

		this.add(infoPanel, BorderLayout.CENTER);
	}

	private JPanel createMealsPanel(Meal meal, MyActionListener listener) {
		JPanel main = new JPanel(new GridLayout(2, 1));

		JLabel lab = new JLabel(meal.getName());
		lab.setAlignmentX(CENTER_ALIGNMENT);

		this.selectedMeal = null;

		JButton btn = new JButton("Подробнее");
		btn.setActionCommand("SHOW");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("SHOW".equals(e.getActionCommand())) {
					selectedMeal = meal;
					listener.actionPerformed(new ActionEvent(btn, WIDTH, listener.SHOWINFORMATION));
				}
			}
		});

		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(lab);
		panel.add(btn);

		JPanel info = new JPanel(new GridLayout(1, 4));

		JPanel p1 = new JPanel(new GridLayout(2, 1));
		p1.add(new JLabel("Калории"));
		p1.add(new JLabel(String.valueOf(meal.getCounter().getCalories())));

		JPanel p2 = new JPanel(new GridLayout(2, 1));
		p2.add(new JLabel("Белки"));
		p2.add(new JLabel(String.valueOf(meal.getCounter().getProteins())));

		JPanel p3 = new JPanel(new GridLayout(2, 1));
		p3.add(new JLabel("Углеводы"));
		p3.add(new JLabel(String.valueOf(meal.getCounter().getCarbohydrates())));

		JPanel p4 = new JPanel(new GridLayout(2, 1));
		p4.add(new JLabel("Жиры"));
		p4.add(new JLabel(String.valueOf(meal.getCounter().getFat())));

		info.add(p1);
		info.add(p2);
		info.add(p3);
		info.add(p4);

		main.add(panel);
		main.add(info);

		return main;
	}

	public Meal getSelectedMeal() {
		return selectedMeal;
	}

	public void setSelectedMeal(Meal selectedMeal) {
		this.selectedMeal = selectedMeal;
	}

	public JButton getSelectNextDayBtn() {
		return selectNextDayBtn;
	}

	public void setSelectNextDayBtn(JButton selectNextDayBtn) {
		this.selectNextDayBtn = selectNextDayBtn;
	}

	public JButton getSelectPreviousDayBtn() {
		return selectPreviousDayBtn;
	}

	public void setSelectPreviousDayBtn(JButton selectPreviousDayBtn) {
		this.selectPreviousDayBtn = selectPreviousDayBtn;
	}

	public JButton getShowInformationBtn() {
		return showInformationBtn;
	}

	public void setShowInformationBtn(JButton showInformationBtn) {
		this.showInformationBtn = showInformationBtn;
	}

	public JButton getAddMealBtn() {
		return addMealBtn;
	}

	public void setAddMealBtn(JButton addMealBtn) {
		this.addMealBtn = addMealBtn;
	}

}
