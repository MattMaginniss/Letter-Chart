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

	@Test
	public void nullTextFileShouldThrowException() {
		fail("Not yet implemented");
	}

	@Test
	public void emptyFileShouldHaveNoData() {
		fail("Not yet implemented");
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
	public void fileWithOneOfEachLetterShouldHaveAppropriateHistogram() {
		fail("Not yet implemented");
	}

	@Test
	public void fileWithManyOfSomeLettersShouldHaveAppropriateHistogram () {
		fail("Not yet implemented");
	}

	@Test
	public void fileWithOnlyPunctuationShouldHaveNoData  () {
		fail("Not yet implemented");
	}

	@Test
	public void fileWithMixedLettersAndPunctuationShouldIgnorePunctuation  () {
		fail("Not yet implemented");
	}


}
