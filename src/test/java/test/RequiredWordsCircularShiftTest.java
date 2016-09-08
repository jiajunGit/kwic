package test;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import CS3213.CheckableSpecialWordsCollection;
import CS3213.RequiredWords;
import CS3213.RequiredWordsCircularShift;

public class RequiredWordsCircularShiftTest {

	@Test
    public void testCreate() {
        
		CheckableSpecialWordsCollection requiredWords = RequiredWords.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords);
    	assertTrue( shifter != null );
    }
	
	@Test(expected=AssertionError.class)
	public void testCreateWithNullRequiredWords() {
		RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(null);
	}
	
	@Test(expected=AssertionError.class)
	public void testGetShiftsWithoutRequiredWords() {
		
		CheckableSpecialWordsCollection requiredWords = RequiredWords.create();
    	RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords);
    	shifter.getShifts("ThIs Is An ExAmPle LiNe");
	}
	
	@Test
	public void testGetShiftsWithOneRequiredWord() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addRequiredWord("Green");
		RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords);
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
		requiredWords.addRequiredWord("Green");
		requiredWords.addRequiredWord("Day");
		RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords);
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
		requiredWords.addRequiredWord("Green");
		requiredWords.addRequiredWord("Day");
		RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords);
		List<String> shiftedLines = shifter.getShifts("Green and Day");
		
		HashSet<String> testSet = new HashSet<String>();
		for( String line : shiftedLines ) {
			testSet.add(line);
		}
		
		assertTrue( testSet.size() == 2 );
		assertTrue( testSet.contains("Green and Day") );
		assertTrue( testSet.contains("Day Green and") );
	}
	
	@Test
	public void testGetShiftsForLineWithRequiredAndNonRequiredWordsOfDifferentCases() {
		
		RequiredWords requiredWords = RequiredWords.create();
		requiredWords.addRequiredWord("tEst");
		requiredWords.addRequiredWord("Circular");
		RequiredWordsCircularShift shifter = RequiredWordsCircularShift.create(requiredWords);
		List<String> shiftedLines = shifter.getShifts("tEst this Circular shIft");
		
		HashSet<String> testSet = new HashSet<String>();
		for( String line : shiftedLines ) {
			testSet.add(line);
		}
		
		assertTrue(testSet.size() == 2);
        assertTrue(testSet.contains("Test This Circular Shift"));
        assertTrue(testSet.contains("Circular Shift Test This"));
	}
}
