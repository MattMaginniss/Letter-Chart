/**
 *
 */
package edu.westga.letterchart.model.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.westga.letterchart.model.CharacterHistogram;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * Test suite for testing methods in the CharacterHistogram class.
 *
 * @author Matt Maginniss
 * @version 2016.01.13
 */
public class WhenBuildingHistograms {
	CharacterHistogram histogram;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.histogram = new CharacterHistogram();
	}

	@Test(expected=IllegalArgumentException.class)
	public void nullTextFileShouldThrowException() throws FileNotFoundException, IOException {
		this.histogram.load(null);
	}

	@Test
	public void emptyFileShouldHaveNoData() throws FileNotFoundException, IOException {
		this.histogram.load(new File("emptyTextFile.txt"));
		assertTrue(this.histogram.dataProperty().isEmpty());
	}

	@Test
	public void singleLetterFileShouldHaveOneEntryWithCountOfOne() throws FileNotFoundException, IOException {
		this.histogram.load(new File("oneLetterFile.txt"));
		assertEquals(1, this.histogram.getCountFor('H'));
	}

	@Test
	public void fileWithOneRepeatingLetterShouldOnlyCountThatLetter() throws FileNotFoundException, IOException {
		this.histogram.load(new File("repeatingLetterFile.txt"));
		assertEquals(45, this.histogram.getCountFor('F'));
	}

	@Test
	public void fileWithOneOfEachLetterShouldHaveAppropriateHistogram() throws FileNotFoundException, IOException {
		this.histogram.load(new File("everyLetterFile.txt"));
		ObservableList<PieChart.Data> testData = FXCollections.observableArrayList(
				new PieChart.Data("A", 1),
				new PieChart.Data("B", 1),
				new PieChart.Data("C", 1),
				new PieChart.Data("D", 1),
				new PieChart.Data("E", 1),
				new PieChart.Data("F", 1),
				new PieChart.Data("G", 1),
				new PieChart.Data("H", 1),
				new PieChart.Data("I", 1),
				new PieChart.Data("J", 1),
				new PieChart.Data("K", 1),
				new PieChart.Data("L", 1),
				new PieChart.Data("M", 1),
				new PieChart.Data("N", 1),
				new PieChart.Data("O", 1),
				new PieChart.Data("P", 1),
				new PieChart.Data("Q", 1),
				new PieChart.Data("R", 1),
				new PieChart.Data("S", 1),
				new PieChart.Data("T", 1),
				new PieChart.Data("U", 1),
				new PieChart.Data("V", 1),
				new PieChart.Data("W", 1),
				new PieChart.Data("X", 1),
				new PieChart.Data("Y", 1),
				new PieChart.Data("Z", 1));
		assertEquals(this.histogram.dataProperty().toString(), testData.toString());
	}

	@Test
	public void fileWithManyOfSomeLettersShouldHaveAppropriateHistogram () throws FileNotFoundException, IOException {
		this.histogram.load(new File("manyOfSomeLettersFile.txt"));
		ObservableList<PieChart.Data> testData = FXCollections.observableArrayList(
				new PieChart.Data("A", 10),
				new PieChart.Data("B", 5),
				new PieChart.Data("C", 3),
				new PieChart.Data("D", 3),
				new PieChart.Data("E", 3),
				new PieChart.Data("F", 2),
				new PieChart.Data("G", 2),
				new PieChart.Data("H", 1),
				new PieChart.Data("I", 1),
				new PieChart.Data("J", 1),
				new PieChart.Data("Z", 5),
				new PieChart.Data("K", 1));
		assertEquals(this.histogram.dataProperty().toString(), testData.toString());
	}

	@Test
	public void fileWithOnlyPunctuationShouldHaveNoData  () throws FileNotFoundException, IOException {
		this.histogram.load(new File("punctuationFile.txt"));
		assertTrue(this.histogram.dataProperty().isEmpty());
	}

	@Test
	public void fileWithMixedLettersAndPunctuationShouldIgnorePunctuation  () throws FileNotFoundException, IOException {
		this.histogram.load(new File("mixedLettersAndPunctuationFile.txt"));
		ObservableList<PieChart.Data> testData = FXCollections.observableArrayList(
				new PieChart.Data("A", 1),
				new PieChart.Data("S", 1),
				new PieChart.Data("D", 1),
				new PieChart.Data("F", 1),
				new PieChart.Data("G", 1),
				new PieChart.Data("H", 1),
				new PieChart.Data("J", 1),
				new PieChart.Data("K", 1),
				new PieChart.Data("L", 1));
		assertEquals(this.histogram.dataProperty().toString(), testData.toString());
	}


}
