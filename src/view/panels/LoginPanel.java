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

import main.AppConstants;

public class LoginPanel extends JPanel {
	private JPanel registrationPanel, singInPanel;
	private JTextField nameField, weightField, loginField;
	private CardLayout cards;
	private JButton createNewUserBtn, enterBtn;

	public LoginPanel() {
		super();
		init();
	}

	public void init() {
		this.cards = new CardLayout();
		this.setLayout(cards);
		this.singInPanel = signInPanel();
		this.registrationPanel = initRegistrationPanel();
		this.add(this.singInPanel, AppConstants.SIGNINPANEL);
		this.add(this.registrationPanel, AppConstants.REGISTRATIONPANEL);
	}

	private JPanel initRegistrationPanel() {
		JPanel registrationPanel = new JPanel(new BorderLayout());

		registrationPanel.add(addNorthRegistrationPanel(), BorderLayout.NORTH);

		JLabel nameLabel = new JLabel("Введите имя");
		this.nameField = new JTextField(20);

		JLabel weightLabel = new JLabel("Введите вес");
		this.weightField = new JTextField(5);

		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(weightLabel);
		panel.add(weightField);

		JCheckBox massBox = new JCheckBox("Хочу набрать массу");
		JCheckBox loosingWeightBox = new JCheckBox("Хочу похудеть");
		JCheckBox noChangesBox = new JCheckBox("Хочу просто держать себя в форме");

		JPanel goalPanel = new JPanel();
		goalPanel.add(loosingWeightBox);
		goalPanel.add(noChangesBox);
		goalPanel.add(massBox);

		JPanel centerPanel = new JPanel(new GridLayout(2, 1));
		centerPanel.add(panel);
		centerPanel.add(goalPanel);

		registrationPanel.add(centerPanel, BorderLayout.CENTER);

		this.createNewUserBtn = new JButton("Продолжить");
		registrationPanel.add(createNewUserBtn, BorderLayout.SOUTH);

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
		center.add(loginLab, BorderLayout.CENTER);
		center.add(loginField, BorderLayout.CENTER);

		this.enterBtn = new JButton("Войти");
		center.add(enterBtn, BorderLayout.SOUTH);

		JLabel inLabel = new JLabel("Вход");
		signInPanel.add(inLabel, BorderLayout.NORTH);
		signInPanel.add(center, BorderLayout.CENTER);
		return signInPanel;
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
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
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

	public CardLayout getCards() {
		return cards;
	}

	public void setCards(CardLayout cards) {
		this.cards = cards;
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

}
