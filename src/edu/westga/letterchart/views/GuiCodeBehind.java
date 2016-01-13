package edu.westga.letterchart.views;

import java.io.File;
import java.io.IOException;

import edu.westga.letterchart.model.CharacterHistogram;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

public class GuiCodeBehind {

	@FXML
	private MenuItem closeMenuItem;

	@FXML
	private MenuItem openMenuItem;

    @FXML
    private PieChart pieChart;

	private CharacterHistogram charHist;

	ObservableList<PieChart.Data> pieChartData;

	/**
	 * Constructor for class
	 *
	 * @precondition none
	 * @postcondition The class is instantiated
	 */
	public GuiCodeBehind() {
		this.charHist = new CharacterHistogram();
	}

	/**
	 * Initializes components in the gui
	 *
	 * @precondition none
	 * @postcondition The Gui is initialized
	 */
	public void initialize() {
		this.setEventActions();
	}

	/**
	 * Sets event actions for GUI controls
	 *
	 * @precondition none
	 * @postcondition GUI controls are active
	 */
	private void setEventActions() {
		this.closeMenuItem.setOnAction(event -> System.exit(0));
		this.openMenuItem.setOnAction(event -> this.getData());

	}

	private void getData(){
		File file = this.loadFile();
		try {
			this.charHist.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.pieChartData = this.charHist.dataProperty();
		this.buildChart();
	}

	private File loadFile(){
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		return selectedFile;
	}

	private void buildChart(){
		this.pieChart.setData(pieChartData);
		this.pieChart.setTitle("");
	}

}
