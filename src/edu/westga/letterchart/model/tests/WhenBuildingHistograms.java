/**
 *
 */
package edu.westga.letterchart.model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test suite for testing methods in the CharacterHistogram class.
 *
 * @author Matt Maginniss
 * @version 2016.01.13
 */
public class WhenBuildingHistograms {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
	public void singleLetterFileShouldHaveOneEntryWithCountOfOne() {
		fail("Not yet implemented");
	}

	@Test
	public void fileWithOneRepeatingLetterShouldOnlyCountThatLetter() {
		fail("Not yet implemented");
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
