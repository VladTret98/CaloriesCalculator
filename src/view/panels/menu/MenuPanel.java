package view.panels.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.Day;
import model.User;
import view.controller.MyActionListener;

public class MenuPanel extends JPanel {
	private DayResultPanel dayResultPanel;
	private FoodPanel foodPanel;
	private DayInfoPanel infoPanel;
	private User user;
	private MyActionListener listener;

	public MenuPanel() {

	}

	public MenuPanel(MyActionListener listener) {
		this.setLayout(new BorderLayout());
		
		this.listener = listener;
	}

	public void init(User user) {
		JPanel menu = new JPanel();		
		menu.setLayout(new GridLayout(1, 2));
		
		if(user.getActiveDay().getDishes() != null) {
			
		
		
		this.user = user;
		
		this.dayResultPanel = new DayResultPanel();
		this.dayResultPanel.init(user);
		
		this.infoPanel = new DayInfoPanel(this.listener, user.getActiveDay());
		
		this.foodPanel = new FoodPanel();
		this.foodPanel.init();
		
		this.setLayout(new BorderLayout());
		
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, infoPanel, foodPanel);
		pane.setDividerSize(8);
				
		menu.add(pane);
		this.add(dayResultPanel, BorderLayout.NORTH);
		this.add(menu, BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
		} else {
			JButton button = new JButton("Добавить блюдо");
			button.addActionListener(listener);
			button.setActionCommand(listener.GOTOADDDISH);
			this.add(button);
		}
	}

	public DayResultPanel getDayResultPanel() {
		return dayResultPanel;
	}

	public void setDayResultPanel(DayResultPanel dayResultPanel) {
		this.dayResultPanel = dayResultPanel;
	}

	public FoodPanel getFoodPanel() {
		return foodPanel;
	}

	public void setFoodPanel(FoodPanel foodPanel) {
		this.foodPanel = foodPanel;
	}

	public DayInfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(DayInfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		// this.dayResultPanel.init(user);
//		this.infoPanel.init(user);
//		this.foodPanel.init();
		this.user = user;
	}

}
