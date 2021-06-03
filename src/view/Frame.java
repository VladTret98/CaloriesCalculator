package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import model.User;
import view.controller.MyActionListener;
import view.panels.LoginPanel;
import view.panels.menu.MenuPanel;

public class Frame extends JFrame {
	private LoginPanel loginPanel;
	private MenuPanel menuPanel;

	public Frame() {

	}

	public void init(MyActionListener listener, User user) {
		this.setSize(650, 420);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.loginPanel = new LoginPanel(listener);
		this.menuPanel = new MenuPanel(listener);
		this.getContentPane().add(this.loginPanel);
		this.setVisible(true);
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

}
