package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import CS3213.RequiredWordsCircularShift;
import CS3213.WordsCollection;

public class RequiredWordsCircularShiftTest {

	@Test
    public void testCreateWithNonNullRequiredandIgnoreWords() {
        
		WordsCollection ignoredWords = WordsCollection.create();
		WordsCollection requiredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
    	assertTrue( shifter != null );
    }
	
	@Test(expected=AssertionError.class)
	public void testCreateWithNullIgnoreWords() {
		
		WordsCollection requiredWords = WordsCollection.create();
		RequiredWordsCircularShift.create(requiredWords, null);
	}
	
	@Test(expected=AssertionError.class)
	public void testCreateWithNullRequiredWords() {
		WordsCollection ignoredWords = WordsCollection.create();
		RequiredWordsCircularShift.create(null, ignoredWords);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShiftsForNullWords() {
		
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("green");
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
    	shifter.getShifts(null);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShiftsWithoutRequiredWords() {
		
		WordsCollection requiredWords = WordsCollection.create();
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
    	shifter.getShifts("ThIs Is An ExAmPle LiNe");
	}
	
	@Test
	public void testGetShiftsWithOneRequiredWord() {
		
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("Green");
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("Green");
		
		assertTrue( shiftedLines.size() == 1 );
		assertTrue( shiftedLines.remove("Green") );
	}
	
	@Test
	public void testGetShiftsForLineWithMoreThanOneRequiredWord() {
		
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("Green");
		requiredWords.addWord("Day");
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("Green Day");
		
		assertTrue( shiftedLines.size() == 2 );
		assertTrue( shiftedLines.remove("Green Day") );
		assertTrue( shiftedLines.remove("Day Green") );
	}
	
	@Test
	public void testGetShiftsForLineWithMoreThanOneRequiredWordAndNonRequiredWords() {
		
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("Green");
		requiredWords.addWord("Day");
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("Green and Day");
		
		assertTrue( shiftedLines.size() == 2 );
		assertTrue( shiftedLines.remove("Green And Day") );
		assertTrue( shiftedLines.remove("Day Green And") );
	}
	
	@Test
	public void testGetShiftsForLineWithRequiredAndNonRequiredWordsOfDifferentCases() {
		
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("tEst");
		requiredWords.addWord("Circular");
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("tEst this Circular shIft");
		
		assertTrue(shiftedLines.size() == 2);
        assertTrue(shiftedLines.remove("Test This Circular Shift"));
        assertTrue(shiftedLines.remove("Circular Shift Test This"));
	}
	
	@Test
	public void testGetShiftsForLineWithEmptyWord() {
		
		WordsCollection requiredWords = WordsCollection.create();
		requiredWords.addWord("GRETEL:");
		WordsCollection ignoredWords = WordsCollection.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		List<String> shiftedLines = shifter.getShifts("GRETEL:  GRETEL:  GRETEL:");
		
		assertTrue(shiftedLines.size() == 3);
        assertTrue(shiftedLines.get(0).equals("Gretel: Gretel: Gretel:"));
        assertTrue(shiftedLines.get(1).equals("Gretel: Gretel: Gretel:"));
        assertTrue(shiftedLines.get(2).equals("Gretel: Gretel: Gretel:"));
	}
	
	@Test
	public void testNumbersSpecial() {
		WordsCollection requiredWords = WordsCollection.create();
	    requiredWords.addWord("F1rs+");
        requiredWords.addWord("s3c0nD");
        requiredWords.addWord(" ");
        WordsCollection ignoredWords = WordsCollection.create();
        RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords, ignoredWords);
        List<String> shiftedLines = shifter.getShifts("Headache F1rs+ Sleepy s3c0nD Tired");
        
        assertTrue(shiftedLines.size() == 2);
        assertTrue(shiftedLines.remove("F1rs+ Sleepy S3c0nd Tired Headache"));
        assertTrue(shiftedLines.remove("S3c0nd Tired Headache F1rs+ Sleepy"));
    
	}
}
