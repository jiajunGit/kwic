package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;
import CS3213.WordsToIgnore;

import java.util.List;

public class CircularShiftTest {

	@Test(expected=AssertionError.class)
	public void testCreateWithNullIgnoredWords() {
		CircularShift.create(null);
	}
	
    @Test
    public void testGetShiftsOneWord() {

    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("shift");
        assertTrue( shifts != null );
        assertTrue( shifts.size() == 1 );
        assertTrue( shifts.contains("Shift") );
    }

    @Test
    public void testGetShiftsMultiWord() {

    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("tEst this Circular shIft");
        
        assertTrue(shifts.size() == 4);
        assertTrue(shifts.contains("Test This Circular Shift"));
        assertTrue(shifts.contains("This Circular Shift Test"));
        assertTrue(shifts.contains("Circular Shift Test This"));
        assertTrue(shifts.contains("Shift Test This Circular"));
    }

    @Test(expected=AssertionError.class)
    public void testGetShiftsNullLine() {

        WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        circularShift.getShifts(null);
    }
    
    @Test
    public void testGetShiftsNullWord() {

        WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        wordsToIgnore.addWord("");

        List<String> shifts = circularShift.getShifts("null");
        
        assertTrue(shifts != null);
        assertTrue(shifts.size() == 1);
        assertTrue(shifts.contains("Null"));
    }    
    
    @Test
    public void testGetShiftsEmptyLine() {

    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("");
        assertTrue(shifts != null);
        assertTrue(shifts.size() == 1);
        assertTrue(shifts.contains(""));
    }

    // Testing shifts for words with letters and numbers
    @Test
    public void testLetterNumberCircularShifts() throws Exception {
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("nuMb3Rs r g00d n0t evIl");
        
        assertTrue(shifts.size() == 5);
        assertTrue(shifts.contains("Numb3rs R G00d N0t Evil"));
        assertTrue(shifts.contains("R G00d N0t Evil Numb3rs"));
        assertTrue(shifts.contains("G00d N0t Evil Numb3rs R"));
        assertTrue(shifts.contains("N0t Evil Numb3rs R G00d"));
        assertTrue(shifts.contains("Evil Numb3rs R G00d N0t"));

    }

    @Test
    public void testGetShiftsRandomCases() {
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
    	wordsToIgnore.addWord("shift");
    	
    	CircularShift circularShift = CircularShift.create(wordsToIgnore);
    	List<String> shifts = circularShift.getShifts("tEst this Circular shIft");
        
        assertTrue(shifts.size() == 3);
        assertTrue(shifts.contains("Test This Circular shift"));
        assertTrue(shifts.contains("This Circular shift Test"));
        assertTrue(shifts.contains("Circular shift Test This"));
    }
    
    @Test
    public void testGetShiftWithEmptyWord() {
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
    	wordsToIgnore.addWord("of");
    	wordsToIgnore.addWord("the");
    	wordsToIgnore.addWord("and");
    	wordsToIgnore.addWord("are");
    	wordsToIgnore.addWord("is");
    	
    	CircularShift circularShift = CircularShift.create(wordsToIgnore);
    	List<String> shifts = circularShift.getShifts("HANSEL &  GRETEL: WARRIORS OF WITCHCRAFT");
    	
    	assertTrue(shifts.size() == 6);
    	assertTrue(shifts.remove("& Gretel: Warriors of Witchcraft Hansel"));
    	assertTrue(shifts.remove("Gretel: Warriors of Witchcraft Hansel &"));
    	assertTrue(shifts.remove("Gretel: Warriors of Witchcraft Hansel &"));
    	assertTrue(shifts.remove("Hansel & Gretel: Warriors of Witchcraft"));
    	assertTrue(shifts.remove("Warriors of Witchcraft Hansel & Gretel:"));
    	assertTrue(shifts.remove("Witchcraft Hansel & Gretel: Warriors of"));
    }
    
    @Test
    public void testEmptyIgnoreEmptyLine() {
        
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        wordsToIgnore.addWord("");
        wordsToIgnore.addWord(" ");
        
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("");
        assertFalse(shifts.contains(""));
        assertTrue(shifts.size() == 0);

        shifts = circularShift.getShifts("       ");
        assertFalse(shifts.contains(" "));
        assertTrue(shifts.size() == 0);
    }
}
