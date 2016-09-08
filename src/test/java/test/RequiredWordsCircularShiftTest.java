package test;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import CS3213.ReadableWordsCollection;
import CS3213.RequiredWords;
import CS3213.RequiredWordsCircularShift;
import CS3213.WordsToIgnore;

public class RequiredWordsCircularShiftTest {

	@Test
    public void testCreateWithNonNullRequiredandIgnoreWords() {
        
		ReadableWordsCollection requiredWords = RequiredWords.create();
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
    	assertTrue( shifter != null );
    }
	
	@Test(expected=AssertionError.class)
	public void testCreateWithNullIgnoreWords() {
		
		ReadableWordsCollection requiredWords = RequiredWords.create();
		RequiredWordsCircularShift.create(requiredWords, null);
	}
	
	@Test(expected=AssertionError.class)
	public void testCreateWithNullRequiredWords() {
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
		RequiredWordsCircularShift.create(null, ignoredWords);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShiftsForNullWords() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("green");
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
    	shifter.getShifts(null);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShiftsWithoutRequiredWords() {
		
		ReadableWordsCollection requiredWords = RequiredWords.create();
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
    	shifter.getShifts("ThIs Is An ExAmPle LiNe");
	}
	
	@Test
	public void testGetShiftsWithOneRequiredWord() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("Green");
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("Green");
		
		HashSet<String> testSet = new HashSet<String>();
		for( String line : shiftedLines ) {
			testSet.add(line);
		}
		
		assertTrue( testSet.size() == 1 );
		assertTrue( testSet.contains("Green") );
	}
	
	@Test
	public void testGetShiftsForLineWithMoreThanOneRequiredWord() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("Green");
		requiredWords.addWord("Day");
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("Green Day");
		
		HashSet<String> testSet = new HashSet<String>();
		for( String line : shiftedLines ) {
			testSet.add(line);
		}
		
		assertTrue( testSet.size() == 2 );
		assertTrue( testSet.contains("Green Day") );
		assertTrue( testSet.contains("Day Green") );
	}
	
	@Test
	public void testGetShiftsForLineWithMoreThanOneRequiredWordAndNonRequiredWords() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("Green");
		requiredWords.addWord("Day");
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("Green and Day");
		
		HashSet<String> testSet = new HashSet<String>();
		for( String line : shiftedLines ) {
			testSet.add(line);
		}
		
		assertTrue( testSet.size() == 2 );
		assertTrue( testSet.contains("Green And Day") );
		assertTrue( testSet.contains("Day Green And") );
	}
	
	@Test
	public void testGetShiftsForLineWithRequiredAndNonRequiredWordsOfDifferentCases() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("tEst");
		requiredWords.addWord("Circular");
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("tEst this Circular shIft");
		
		HashSet<String> testSet = new HashSet<String>();
		for( String line : shiftedLines ) {
			testSet.add(line);
		}
		
		assertTrue(testSet.size() == 2);
        assertTrue(testSet.contains("Test This Circular Shift"));
        assertTrue(testSet.contains("Circular Shift Test This"));
	}
	
	@Test
	public void testGetShiftsForLineWithEmptyWord() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addWord("GRETEL:");
		ReadableWordsCollection ignoredWords = WordsToIgnore.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("GRETEL:  GRETEL:  GRETEL:");
		
		assertTrue(shiftedLines.size() == 3);
        assertTrue(shiftedLines.get(0).equals("Gretel: Gretel: Gretel:"));
        assertTrue(shiftedLines.get(1).equals("Gretel: Gretel: Gretel:"));
        assertTrue(shiftedLines.get(2).equals("Gretel: Gretel: Gretel:"));
	}
}
