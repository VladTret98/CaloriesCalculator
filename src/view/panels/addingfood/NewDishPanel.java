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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import view.controller.MyActionListener;

public class NewDishPanel extends JPanel {
	private JTextField nameField;
	private List<IngredientPanel> ingredientsPanels;
	private JButton addIngredientBtn, addBtn;
	private JScrollPane ingredientsPane;

	public NewDishPanel(MyActionListener listener) {
		this.setLayout(new BorderLayout());

		this.ingredientsPanels = new ArrayList<IngredientPanel>();

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.ingredientsPane = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.addBtn = new JButton("Добавить блюдо");
		this.addBtn.addActionListener(listener);
		this.addBtn.setActionCommand(listener.ADDDISH);

		this.addIngredientBtn = new JButton("+");
		this.addIngredientBtn.setActionCommand("Добавить ингредиент");
		this.addIngredientBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IngredientPanel panel = new IngredientPanel();
				ingredientsPanels.add(panel);
				p.add(panel);
				repaint();
				revalidate();
			}
		});
//		init(p);
//	}
//
//	public void init(JPanel p) {
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		p1.add(new JLabel("Название"));
		p1.add(this.nameField = new JTextField(20));
		this.add(p1, BorderLayout.NORTH);

		for (int i = 0; i < 2; i++) {
			IngredientPanel panel = new IngredientPanel();
			p.add(panel);
			this.ingredientsPanels.add(panel);
		}

		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(this.ingredientsPane, BorderLayout.CENTER);
		centerPanel.add(this.addIngredientBtn, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(addBtn, BorderLayout.SOUTH);
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JButton getAddIngredientBtn() {
		return addIngredientBtn;
	}

	public void setAddIngredientBtn(JButton addIngredientBtn) {
		this.addIngredientBtn = addIngredientBtn;
	}

	public List<IngredientPanel> getIngredientsPanels() {
		return ingredientsPanels;
	}

	public void setIngredientsPanels(List<IngredientPanel> ingredientsPanels) {
		this.ingredientsPanels = ingredientsPanels;
	}

	public JScrollPane getIngredientsPane() {
		return ingredientsPane;
	}

	public void setIngredientsPane(JScrollPane ingredientsPane) {
		this.ingredientsPane = ingredientsPane;
	}

}
