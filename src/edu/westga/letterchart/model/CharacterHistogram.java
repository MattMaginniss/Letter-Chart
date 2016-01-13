package edu.westga.letterchart.model;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * A CharacterHistogram is a histogram of letter values
 * read from a text file.
 * @author lewisb
 *
 */
public class CharacterHistogram {
	private Scanner input;
	private HashMap<Character, Integer> hashMap;

	/**
	 * Creates an empty CharacterHistogram.
	 */
	public CharacterHistogram() {
		this.hashMap = new HashMap<Character, Integer>();
	}

	/**
	 * Gets the count for a given character.
	 *
	 * @param character the character we're interested in
	 * @return the number of times it appears in the histogram
	 */
	public int getCountFor(char character) {
		return this.hashMap.get(character);
	}

	/**
	 * Increases (by one) the count for the given character. Ignores non-alphabetic characters.
	 *
	 * @param character the character for which we should increase the count
	 */
	private void increaseCountFor(char character) {
		if (this.hashMap.containsKey(character)) {
			this.hashMap.put(character, this.hashMap.get(character) + 1);
		} else {
			this.hashMap.put(character, 1);
		}
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
		this.input = new Scanner(textFile);
		do {
			String value = this.input.next();
			value = value.toUpperCase();
			if (Character.isLetter(value.charAt(0))) {
				this.increaseCountFor(value.charAt(0));
			}
		} while (this.input.hasNext());
		this.input.close();
	}

	/**
	 * Data property, suitable for consumption by a PieChart.
	 *
	 * @return the histogram as pie char data
	 */
	public ObservableList<PieChart.Data> dataProperty() {
		return null;
	}
}
