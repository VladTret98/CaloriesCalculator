package view;

import java.awt.CardLayout;

import javax.swing.JFrame;

import view.panels.FoodPanel;
import view.panels.LoginPanel;
import view.panels.MainMenuPanel;

public class Frame extends JFrame {
	private CardLayout cards;
	private LoginPanel loginPanel;
	private MainMenuPanel menuPanel;
	private FoodPanel foodPanel;
	
	public Frame() {
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cards = new CardLayout();
		this.loginPanel = new LoginPanel();
		this.menuPanel = new MainMenuPanel();
		this.foodPanel = new FoodPanel();
	}
	
	
	public CardLayout getCards() {
		return cards;
	}

	public void setCards(CardLayout cards) {
		this.cards = cards;
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	public MainMenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MainMenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public FoodPanel getFoodPanel() {
		return foodPanel;
	}

	public void setFoodPanel(FoodPanel foodPanel) {
		this.foodPanel = foodPanel;
	}

}
