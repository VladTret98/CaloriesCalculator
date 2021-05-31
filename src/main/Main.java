package main;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JFreeChart c = initCharts();
		ChartPanel pan = new ChartPanel(c);
		f.add(pan);
		f.setSize(400, 400);
		f.setVisible(true);

	}

	public static JFreeChart initCharts() {
		DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
		dataset.setValue("Калорий скушано", 456.6);
		JFreeChart demo = ChartFactory.createPieChart("Калории", dataset, true, true, false);
		return demo;
	}

}
