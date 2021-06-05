package view.panels.menu;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.JFreeChartDemo;
import org.jfree.data.general.DefaultPieDataset;

import model.CalCalculator;
import model.User;

public class DayResultPanel extends JPanel {

	public DayResultPanel() {
		super();
		this.setLayout(new GridLayout(1, 4));
	}

	public void init(User user) {

		DefaultPieDataset<String> datasetCal = new DefaultPieDataset<>();
		datasetCal.setValue("Калорий съедено", user.getActiveDay().getCounter().getCalories());
		datasetCal.setValue("Потребность",
				user.getCalc().getUserGoal().getCaloriesNeed() - user.getActiveDay().getCounter().getCalories());
		JFreeChart demo = ChartFactory.createPieChart("Калории", datasetCal, true, true, false);

		DefaultPieDataset<String> datasetProt = new DefaultPieDataset<>();
		datasetProt.setValue("Белков съедено", user.getActiveDay().getCounter().getProteins());
		datasetProt.setValue("Потребность",
				user.getCalc().getUserGoal().getProteinsNeed() - user.getActiveDay().getCounter().getProteins());
		JFreeChart demo2 = ChartFactory.createPieChart("Белки", datasetProt, true, true, false);

		DefaultPieDataset<String> datasetFat = new DefaultPieDataset<>();
		datasetFat.setValue("Жиров съедено", user.getActiveDay().getCounter().getFat());
		datasetFat.setValue("Потребность",
				user.getCalc().getUserGoal().getFatNeed() - user.getActiveDay().getCounter().getFat());
		JFreeChart demo3 = ChartFactory.createPieChart("Жиры", datasetFat, true, true, false);

		DefaultPieDataset<String> datasetCarb = new DefaultPieDataset<>();
		datasetCarb.setValue("Углеводов съедено", user.getActiveDay().getCounter().getCarbohydrates());
		datasetCarb.setValue("Потребность", user.getCalc().getUserGoal().getCarbohydratesNeed()
				- user.getActiveDay().getCounter().getCarbohydrates());
		JFreeChart demo4 = ChartFactory.createPieChart("Углеводы", datasetCarb, true, true, false);

		ChartPanel p1 = new ChartPanel(demo);
		p1.setPreferredSize(new Dimension(85, 135));

		ChartPanel p2 = new ChartPanel(demo2);
		p2.setPreferredSize(new Dimension(85, 135));

		ChartPanel p3 = new ChartPanel(demo3);
		p3.setPreferredSize(new Dimension(85, 135));

		ChartPanel p4 = new ChartPanel(demo4);
		p4.setPreferredSize(new Dimension(85, 135));

		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
	}

}
