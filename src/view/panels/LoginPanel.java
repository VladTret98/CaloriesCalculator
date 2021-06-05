package view.panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.controller.MyActionListener;

public class LoginPanel extends JPanel {
	private JPanel registrationPanel, singInPanel;
	private JTextField newUserNameField, weightField, loginField;
	private JButton createNewUserBtn, enterBtn, goToRegistration;
	private JCheckBox lifeStyle1, lifeStyle2, lifeStyle3, massBox, loosingWeightBox, keepFitBox;

	public LoginPanel() {
		super();
	}

	public LoginPanel(MyActionListener listener) {

		this.enterBtn = new JButton("Войти");
		this.enterBtn.addActionListener(listener);
		this.enterBtn.setActionCommand(listener.SIGNIN);

		this.createNewUserBtn = new JButton("Продолжить");
		this.createNewUserBtn.addActionListener(listener);
		this.createNewUserBtn.setActionCommand(listener.REGISTRATION);
		
		this.goToRegistration = new JButton("Зарегистрироваться");
		this.goToRegistration.setActionCommand(listener.TOREGISTRATION);
		this.goToRegistration.addActionListener(listener);

		this.singInPanel = signInPanel();
		this.registrationPanel = initRegistrationPanel();

		this.add(this.singInPanel);
	}

	public JPanel initRegistrationPanel() {
		JPanel registrationPanel = new JPanel(new BorderLayout());

		registrationPanel.add(addNorthRegistrationPanel(), BorderLayout.NORTH);

		JLabel nameLabel = new JLabel("Введите имя");
		this.newUserNameField = new JTextField(20);

		JLabel weightLabel = new JLabel("Введите вес");
		this.weightField = new JTextField(5);

		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(nameLabel);
		panel.add(newUserNameField);
		panel.add(weightLabel);
		panel.add(weightField);

		JLabel lab = new JLabel("Укажите ваш образ жизни");
		lab.setAlignmentX(CENTER_ALIGNMENT);
		this.lifeStyle1 = new JCheckBox("Сидячий");
		this.lifeStyle2 = new JCheckBox("Активный");
		this.lifeStyle3 = new JCheckBox("Спортивный");
		JPanel lifeStylePanel = new JPanel(new BorderLayout());
		lifeStylePanel.add(lab, BorderLayout.NORTH);
		JPanel pan = new JPanel(new GridLayout(1, 3));
		pan.add(lifeStyle1);
		pan.add(lifeStyle2);
		pan.add(lifeStyle3);
		lifeStylePanel.add(pan, BorderLayout.CENTER);

		this.massBox = new JCheckBox("Хочу набрать массу");
		this.loosingWeightBox = new JCheckBox("Хочу похудеть");
		this.keepFitBox = new JCheckBox("Хочу просто держать себя в форме");

		JPanel goalPanel = new JPanel();
		goalPanel.add(loosingWeightBox);
		goalPanel.add(keepFitBox);
		goalPanel.add(massBox);

		JPanel centerPanel = new JPanel(new GridLayout(3, 1));
		centerPanel.add(panel);
		centerPanel.add(lifeStylePanel);
		centerPanel.add(goalPanel);
		
		registrationPanel.add(centerPanel, BorderLayout.CENTER);
		registrationPanel.add(this.createNewUserBtn, BorderLayout.SOUTH);

		return registrationPanel;
	}

	private JPanel addNorthRegistrationPanel() {

		JLabel welcomeLab = new JLabel("Добро пожаловать");
		welcomeLab.setFont(new Font("asdad", Font.BOLD, 28));
		welcomeLab.setHorizontalAlignment(JLabel.CENTER);

		JLabel welcomeLab2 = new JLabel("Заполните информацию о себе и выберите цель");
		welcomeLab2.setFont(new Font("asdad", Font.BOLD, 20));
		welcomeLab2.setHorizontalAlignment(JLabel.CENTER);

		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.add(welcomeLab);
		northPanel.add(welcomeLab2);

		return northPanel;
	}

	private JPanel signInPanel() {
		JPanel signInPanel = new JPanel(new BorderLayout());

		JLabel loginLab = new JLabel("Введите имя");
		loginLab.setAlignmentX(CENTER_ALIGNMENT);
		loginLab.setAlignmentY(CENTER_ALIGNMENT);
		this.loginField = new JTextField(20);
		loginField.setAlignmentX(CENTER_ALIGNMENT);
		loginField.setAlignmentY(CENTER_ALIGNMENT);

		JPanel center = new JPanel(new BorderLayout());
		
		this.goToRegistration.setSize(60, 20);
		
		center.add(loginLab, BorderLayout.CENTER);
		center.add(loginField, BorderLayout.CENTER);

		center.add(this.enterBtn, BorderLayout.SOUTH);

		JLabel inLabel = new JLabel("Вход");
		JLabel inLabel2 = new JLabel("Введите имя");
		JPanel inPanel = new JPanel(new GridLayout(2,1));
		inPanel.add(inLabel);
		inPanel.add(inLabel2);
		
		signInPanel.add(inPanel, BorderLayout.NORTH);
		signInPanel.add(center, BorderLayout.CENTER);
		signInPanel.add(this.goToRegistration, BorderLayout.SOUTH);
		return signInPanel;
	}
	
	public double getSelectedLifeStyle() {
		if (this.lifeStyle1.isSelected()) return 1;
		else if (this.lifeStyle2.isSelected()) return 1.3;
		else return 1.5;
	}
	
	public int getGoal() {
		if (this.massBox.isSelected()) return 3;
		else if (this.loosingWeightBox.isSelected()) return 1;
		else return 2;
	}

	public JPanel getRegistrationPanel() {
		return registrationPanel;
	}

	public void setRegistrationPanel(JPanel registrationPanel) {
		this.registrationPanel = registrationPanel;
	}

	public JPanel getSingInPanel() {
		return singInPanel;
	}

	public void setSingInPanel(JPanel singInPanel) {
		this.singInPanel = singInPanel;
	}

	public JTextField getNameField() {
		return newUserNameField;
	}

	public void setNameField(JTextField nameField) {
		this.newUserNameField = nameField;
	}

	public JTextField getWeightField() {
		return weightField;
	}

	public void setWeightField(JTextField weightField) {
		this.weightField = weightField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}

	public JButton getCreateNewUserBtn() {
		return createNewUserBtn;
	}

	public void setCreateNewUserBtn(JButton createNewUserBtn) {
		this.createNewUserBtn = createNewUserBtn;
	}

	public JButton getEnterBtn() {
		return enterBtn;
	}

	public void setEnterBtn(JButton enterBtn) {
		this.enterBtn = enterBtn;
	}

	public JTextField getNewUserNameField() {
		return newUserNameField;
	}

	public void setNewUserNameField(JTextField newUserNameField) {
		this.newUserNameField = newUserNameField;
	}
	
	

}
