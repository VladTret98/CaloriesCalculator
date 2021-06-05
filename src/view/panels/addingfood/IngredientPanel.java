package view.panels.addingfood;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IngredientPanel extends JPanel {
	private JTextField nameField, caloriesfield, proteinsField, fatField, carbonsField, massField;

	public IngredientPanel() {
		this.nameField = new JTextField(20);
		this.nameField.setPreferredSize(new Dimension(50,25));
		
		this.caloriesfield = new JTextField(5);
		this.caloriesfield.setPreferredSize(new Dimension(50,25));
		
		this.proteinsField = new JTextField(5);
		this.proteinsField.setPreferredSize(new Dimension(50,25));
		
		this.fatField = new JTextField(5);
		this.fatField.setPreferredSize(new Dimension(50,25));
		
		this.carbonsField = new JTextField(5);
		this.carbonsField.setPreferredSize(new Dimension(50,25));
		
		this.massField = new JTextField(7);
		this.massField.setPreferredSize(new Dimension(50,25));
		
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(1,6));
		
		//JPanel panel = new JPanel(new GridLayout(1,6));
		
		JLabel nameLabel = new JLabel("Название");
		JPanel p1 = new JPanel(new GridLayout(2,1));
		p1.add(nameLabel);
		p1.add(this.nameField);
		
		JLabel calorie = new JLabel("кКал/100г");
		JPanel p2 = new JPanel(new GridLayout(2,1));
		p2.add(calorie);
		p2.add(this.caloriesfield);
		
		JLabel protein = new JLabel("белки/100г");
		JPanel p3 = new JPanel(new GridLayout(2,1));
		p3.add(protein);
		p3.add(this.proteinsField);
		
		JLabel fat = new JLabel("жиры/100г");
		JPanel p4 = new JPanel(new GridLayout(2,1));
		p4.add(fat);
		p4.add(this.fatField);
		
		JLabel carbons = new JLabel("углеводы/100г");
		JPanel p5 = new JPanel(new GridLayout(2,1));
		p5.add(carbons);
		p5.add(this.carbonsField);
		
		JLabel mass = new JLabel("масса");
		JPanel p6 = new JPanel(new GridLayout(2,1));
		p6.add(mass);
		p6.add(this.massField);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		
		//this.add(panel);
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getCaloriesfield() {
		return caloriesfield;
	}

	public void setCaloriesfield(JTextField caloriesfield) {
		this.caloriesfield = caloriesfield;
	}

	public JTextField getProteinsField() {
		return proteinsField;
	}

	public void setProteinsField(JTextField proteinsField) {
		this.proteinsField = proteinsField;
	}

	public JTextField getFatField() {
		return fatField;
	}

	public void setFatField(JTextField fatField) {
		this.fatField = fatField;
	}

	public JTextField getCarbonsField() {
		return carbonsField;
	}

	public void setCarbonsField(JTextField carbonsField) {
		this.carbonsField = carbonsField;
	}

	public JTextField getMassField() {
		return massField;
	}

	public void setMassField(JTextField massField) {
		this.massField = massField;
	}

}
