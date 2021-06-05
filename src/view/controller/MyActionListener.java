package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.Main;
import model.Day;
import model.MainCalculator;
import model.User;
import view.Frame;
import view.panels.LoginPanel;
import view.panels.addingfood.NewDishPanel;
import view.panels.menu.MenuPanel;

public class MyActionListener implements ActionListener {

	private MainCalculator calculator;

	private Frame frame;

	public final String REGISTRATION = "Регистрация"; // use for registration new user
	public final String SIGNIN = "Войти";
	public final String GOTONEXTDAY = "GO to next day";
	public final String GOTOPREVIOUSDAY = "GO to previous day";
	public final String TOREGISTRATION = "GO to registration"; // use for going to registration
	public final String SHOWINFORMATION = "show info about meal";
	public final String GOTOADDDISH = "show panel for adding new dish";
	public final String ADDDISH = "add new dish";

	@Override
	public void actionPerformed(ActionEvent e) {
		if (REGISTRATION.equals(e.getActionCommand())) {
			if ("".equals(this.frame.getLoginPanel().getNewUserNameField().getText())
					|| "".equals(this.frame.getLoginPanel().getWeightField().getText())) {
				JOptionPane.showMessageDialog(new JOptionPane(), "Все нужно заполнить");
			} else {
				String name = this.frame.getLoginPanel().getNewUserNameField().getText();
				double weight = Double.valueOf(frame.getLoginPanel().getWeightField().getText());
				int goal = this.frame.getLoginPanel().getGoal();
				double lifeStyle = this.frame.getLoginPanel().getSelectedLifeStyle();
				calculator.addNewUser(name, weight, goal, lifeStyle);
				Main.saveProgram(this);
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
					this.calculator.setDate();
					this.frame.getMenuPanel().setUser(user);
					this.frame.getContentPane().removeAll();
					
				//	this.frame.init(this);
					
					if (this.frame.getMenuPanel() == null) {
						this.frame.setMenuPanel(new MenuPanel(this));
					} else {
						this.frame.getMenuPanel().init(this.getCalculator().getActiveUser());
					}
					Main.saveProgram(this);
					this.frame.getContentPane().add(frame.getMenuPanel());
					this.frame.getContentPane().repaint();
					this.frame.getContentPane().revalidate();
				} else {
					JOptionPane.showMessageDialog(new JOptionPane(), "Пользователь не найден");
				}
			}
		}

		else if (GOTOADDDISH.equals(e.getActionCommand())) {
			this.frame.getContentPane().removeAll();
			NewDishPanel panel = new NewDishPanel(this);
			this.frame.setDishPanel(panel);
			this.frame.getContentPane().add(this.frame.getDishPanel());
			this.frame.getContentPane().repaint();
			this.frame.getContentPane().revalidate();
		}

		else if (ADDDISH.equals(e.getActionCommand())) {
			this.frame.getContentPane().removeAll();
			this.calculator.addNewDish(frame.getDishPanel());
			Main.saveProgram(this);
			frame.setMenuPanel(new MenuPanel(this));
			this.frame.getMenuPanel().init(this.calculator.getActiveUser());
			this.frame.getContentPane().add(frame.getMenuPanel());
			this.frame.getContentPane().repaint();
			this.frame.getContentPane().revalidate();
		}

		else if (TOREGISTRATION.equals(e.getActionCommand())) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().add(frame.getLoginPanel().add(frame.getLoginPanel().initRegistrationPanel()));
			this.frame.getContentPane().repaint();
			this.frame.getContentPane().revalidate();
		}

		else if (SHOWINFORMATION.equals(e.getActionCommand())) {
			this.frame.getMenuPanel().getFoodPanel()
					.setDishInfo(this.frame.getMenuPanel().getInfoPanel().getSelectedMeal());
		}

		else if (GOTOPREVIOUSDAY.equals(e.getActionCommand())) {
			if (this.calculator.getActiveUser().getActiveDay() != null) {

				Day day = this.calculator.getActiveUser().getPreviousDay();
				this.calculator.getActiveUser().setActiveDay(day);
				Main.saveProgram(this);

				this.frame.getContentPane().removeAll();
				this.frame.setMenuPanel(new MenuPanel(this));
				this.frame.getMenuPanel().init(this.calculator.getActiveUser());
				this.frame.getContentPane().add(frame.getMenuPanel());
				this.frame.getContentPane().repaint();
				this.frame.getContentPane().revalidate();
			} else {
				this.getCalculator().getActiveUser().setActiveDay(this.calculator.getActiveUser().getDays()
						.get(this.calculator.getActiveUser().getDays().size() - 1));
				Day day = this.calculator.getActiveUser().getPreviousDay();
				this.calculator.getActiveUser().setActiveDay(day);
				Main.saveProgram(this);
				this.frame.getContentPane().removeAll();
				this.frame.setMenuPanel(new MenuPanel(this));
				this.frame.getMenuPanel().init(this.calculator.getActiveUser());
				this.frame.getContentPane().add(frame.getMenuPanel());
				this.frame.getContentPane().repaint();
				this.frame.getContentPane().revalidate();
			}
		}

		else if (GOTONEXTDAY.equals(e.getActionCommand())) {
			if (this.calculator.getActiveUser().getActiveDay() != null) {
				Day day = this.calculator.getActiveUser().getNextDay();
				this.calculator.getActiveUser().setActiveDay(day);
				Main.saveProgram(this);
				this.frame.getContentPane().removeAll();
				this.frame.setMenuPanel(new MenuPanel(this));
				this.frame.getMenuPanel().init(this.calculator.getActiveUser());
				this.frame.getContentPane().add(this.frame.getMenuPanel());
				this.frame.getContentPane().repaint();
				this.frame.getContentPane().revalidate();
			} else {
				this.getCalculator().getActiveUser().setActiveDay(this.calculator.getActiveUser().getDays()
						.get(this.calculator.getActiveUser().getDays().size() - 1));
				Day day = this.calculator.getActiveUser().getNextDay();
				this.calculator.getActiveUser().setActiveDay(day);
				Main.saveProgram(this);
				this.frame.getContentPane().removeAll();
				this.frame.setMenuPanel(new MenuPanel(this));
				this.frame.getMenuPanel().init(this.calculator.getActiveUser());
				this.frame.getContentPane().add(frame.getMenuPanel());
				this.frame.getContentPane().repaint();
				this.frame.getContentPane().revalidate();
			}
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
