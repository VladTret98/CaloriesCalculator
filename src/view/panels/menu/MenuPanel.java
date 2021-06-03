package view.panels.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		this.setLayout(new GridLayout(1, 2));
		this.listener = listener;
	}

	public void init(User user) {
		this.user = user;
		
		this.dayResultPanel = new DayResultPanel();
		
		this.infoPanel = new DayInfoPanel(this.listener, user.getDays().get(user.getDays().size() - 1));
		
		this.foodPanel = new FoodPanel();
		this.foodPanel.init();
		
		this.setLayout(new BorderLayout());
		
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, infoPanel, foodPanel);
		pane.setDividerSize(8);
				
		this.add(pane);
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
