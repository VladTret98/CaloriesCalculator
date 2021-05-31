package view.panels;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenuPanel extends JPanel {
	private DayResultPanel dayResultPanel;
	private JButton addMealBtn, changeWeightBtn;
	private JTextField newWeightField;
	private JPanel historyPanel;
	
	
	public MainMenuPanel() {
		super();
		init();
	}
	
	
	
	public void init() {
		this.setLayout(new BorderLayout());
		
		JPanel changesPanel = createChangesPanel();
	}
	
	
	private JPanel createChangesPanel() {
		JPanel changesPanel = new JPanel();
		
		
		
		return changesPanel;
	}
	
	
	
}
