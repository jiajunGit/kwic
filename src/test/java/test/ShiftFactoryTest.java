package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.AbstractShift;
import CS3213.CircularShift;
import CS3213.RequiredWordsCircularShift;
import CS3213.ShiftFactory;
import CS3213.WordsCollection;

public class ShiftFactoryTest {

	@Test
	public void testGetInstanceForNonNullOutput() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		assertTrue( shiftFactory != null );
	}
	
	@Test
	public void testGetShifterForNonNullOuput() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		WordsCollection ignoreWords = WordsCollection.create();
		WordsCollection requiredWords = WordsCollection.create();
		assertTrue( shiftFactory.getShifter(ignoreWords, requiredWords) != null );
	}
	
	@Test
	public void testGetShifterWithNoRequiredWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		WordsCollection ignoreWords = WordsCollection.create();
		WordsCollection requiredWords = WordsCollection.create();
		AbstractShift shifter = shiftFactory.getShifter(ignoreWords, requiredWords);
		assertTrue( shifter instanceof CircularShift );
	}
	
	@Test
	public void testGetShifterWithRequiredWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		WordsCollection ignoreWords = WordsCollection.create();
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("Example");
		AbstractShift shifter = shiftFactory.getShifter(ignoreWords, requiredWords);
		assertTrue( shifter instanceof RequiredWordsCircularShift );
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShifterWithNullIgnoreWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		WordsCollection requiredWords = WordsCollection.create();
		shiftFactory.getShifter(null, requiredWords);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShifterWithNullRequiredWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		WordsCollection ignoreWords = WordsCollection.create();
		shiftFactory.getShifter(ignoreWords, null);
	}
}
