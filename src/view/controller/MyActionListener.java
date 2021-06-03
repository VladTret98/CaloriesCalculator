package view.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.MainCalculator;
import model.User;
import model.food.Meal;
import view.Frame;
import view.panels.addingfood.NewMealPanel;
import view.panels.menu.MenuPanel;

public class MyActionListener implements ActionListener {

	private MainCalculator calculator;

	private Frame frame;

	public final String REGISTRATION = "Регистрация"; // use for registration new user
	public final String SIGNIN = "Войти";
	public final String ADDMEAL = "Добавить блюдо";
	public final String GOTONEXTDAY = "GO to next day";
	public final String GOTOPREVIOUSDAY = "GO to previous day";
	public final String TOREGISTRATION = "GO to registration"; // use for going to registration
	public final String SHOWINFORMATION = "show info about meal";

	@Override
	public void actionPerformed(ActionEvent e) {
		if (REGISTRATION.equals(e.getActionCommand())) {
			if ("".equals(this.frame.getLoginPanel().getNewUserNameField().getText())
					|| "".equals(this.frame.getLoginPanel().getWeightField().getText())) {
				JOptionPane.showMessageDialog(new JOptionPane(), "Все нужно заполнить");
			} else {
				String name = this.frame.getLoginPanel().getNewUserNameField().getText();
				double weight = Double.valueOf(frame.getLoginPanel().getWeightField().getText());
				int goal = Integer.valueOf(1);
				double lifeStyle = 1.3;
				calculator.addNewUser(name, weight, goal, lifeStyle);
			}
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().add(frame.getLoginPanel().getSingInPanel());
			this.frame.getContentPane().repaint();
			this.frame.getContentPane().revalidate();
		}

		else if (SIGNIN.equals(e.getActionCommand())) {
			if ("".equals(this.frame.getLoginPanel().getLoginField().getText())) {
				JOptionPane.showMessageDialog(new JOptionPane(), "Вы ничего не ввели");
			} else {
				String name = frame.getLoginPanel().getLoginField().getText();
				if (this.calculator.findUser(name) != null) {
			User user = this.calculator.findUser(this.frame.getLoginPanel().getLoginField().getText());
			this.frame.getMenuPanel().setUser(user);
			this.frame.getContentPane().removeAll();
			if(this.frame.getMenuPanel() == null) {
				this.frame.setMenuPanel(new MenuPanel(this));
			} else {
				this.frame.getMenuPanel().init(user);
			}
			this.frame.getContentPane().add(frame.getMenuPanel());
			this.frame.repaint();
			this.frame.revalidate();
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "Пользователь не найден");
				}
			}
		}

		else if (ADDMEAL.equals(e.getActionCommand())) {
			JFrame frame = new JFrame();
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(new NewMealPanel(this));
			frame.setVisible(true);
			}

		else if (TOREGISTRATION.equals(e.getActionCommand())) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().add(frame.getLoginPanel().getRegistrationPanel());
			this.frame.getContentPane().repaint();
			this.frame.getContentPane().revalidate();
		}

		else if (SHOWINFORMATION.equals(e.getActionCommand())) {
			this.frame.getMenuPanel().getFoodPanel().setMealInfo(this.frame.getMenuPanel().getInfoPanel().getSelectedMeal());
		}

	}

	public MainCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(MainCalculator calculator) {
		this.calculator = calculator;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

}
