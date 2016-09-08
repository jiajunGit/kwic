package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.AbstractShift;
import CS3213.ReadableWordsCollection;
import CS3213.CircularShift;
import CS3213.RequiredWords;
import CS3213.RequiredWordsCircularShift;
import CS3213.ShiftFactory;
import CS3213.WordsToIgnore;

public class ShiftFactoryTest {

	@Test
	public void testGetInstanceForNonNullOutput() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		assertTrue( shiftFactory != null );
	}
	
	@Test
	public void testGetShifterForNonNullOuput() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		ReadableWordsCollection ignoreWords = WordsToIgnore.create();
		ReadableWordsCollection requiredWords = RequiredWords.create();
		assertTrue( shiftFactory.getShifter(ignoreWords, requiredWords) != null );
	}
	
	@Test
	public void testGetShifterWithNoRequiredWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		ReadableWordsCollection ignoreWords = WordsToIgnore.create();
		ReadableWordsCollection requiredWords = RequiredWords.create();
		AbstractShift shifter = shiftFactory.getShifter(ignoreWords, requiredWords);
		assertTrue( shifter instanceof CircularShift );
	}
	
	@Test
	public void testGetShifterWithRequiredWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		ReadableWordsCollection ignoreWords = WordsToIgnore.create();
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("Example");
		AbstractShift shifter = shiftFactory.getShifter(ignoreWords, requiredWords);
		assertTrue( shifter instanceof RequiredWordsCircularShift );
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShifterWithNullIgnoreWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		ReadableWordsCollection requiredWords = RequiredWords.create();
		shiftFactory.getShifter(null, requiredWords);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShifterWithNullRequiredWords() {
		
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
		ReadableWordsCollection ignoreWords = WordsToIgnore.create();
		shiftFactory.getShifter(ignoreWords, null);
	}
}
