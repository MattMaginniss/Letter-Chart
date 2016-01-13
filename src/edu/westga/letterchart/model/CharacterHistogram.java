package edu.westga.letterchart.model;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * A CharacterHistogram is a histogram of letter values
 * read from a text file.
 * @author lewisb
 *
 */
public class CharacterHistogram {

	/**
	 * Creates an empty CharacterHistogram.
	 */
	public CharacterHistogram() {

	}

	/**
	 * Gets the count for a given character.
	 *
	 * @param character the character we're interested in
	 * @return the number of times it appears in the histogram
	 */
	public int getCountFor(char character) {
		return 0;
	}

	/**
	 * Increases (by one) the count for the given character. Ignores non-alphabetic characters.
	 *
	 * @param character the character for which we should increase the count
	 */
	private void increaseCountFor(char character) {

	}

	/**
	 * Clears this CharacterHistogram and loads in the new character data
	 *
	 * @param textFile the file to open
	 * @throws FileNotFoundException if the file cannot be found
	 * @throws IOException if an unexpected I/O problem occurs
	 * @throws IllegalArgumentException if the file is null
	 */
	public void load(File textFile) throws FileNotFoundException, IOException {
		String fileString = new Scanner(textFile).useDelimiter("\\A").next();
		System.out.println(fileString);
	}

	/**
	 * Data property, suitable for consumption by a PieChart.
	 *
	 * @return the histogram as pie char data
	 */
	public ObservableList<PieChart.Data> dataProperty() {
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));

		return pieChartData;
	}
}
