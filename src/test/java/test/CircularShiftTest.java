package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;
import CS3213.WordsCollection;

import java.util.List;

public class CircularShiftTest {

	@Test(expected=AssertionError.class)
	public void testCreateWithNullIgnoredWords() {
		CircularShift.create(null);
	}
	
    @Test
    public void testGetShiftsOneWord() {

    	WordsCollection wordsToIgnore = WordsCollection.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("shift");
        assertTrue( shifts != null );
        assertTrue( shifts.size() == 1 );
        assertTrue( shifts.remove("Shift") );
    }

    @Test
    public void testGetShiftsMultiWord() {

    	WordsCollection wordsToIgnore = WordsCollection.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("tEst this Circular shIft");
        
        assertTrue(shifts.size() == 4);
        assertTrue(shifts.remove("Test This Circular Shift"));
        assertTrue(shifts.remove("This Circular Shift Test"));
        assertTrue(shifts.remove("Circular Shift Test This"));
        assertTrue(shifts.remove("Shift Test This Circular"));
    }

    @Test(expected=AssertionError.class)
    public void testGetShiftsNullLine() {

        WordsCollection wordsToIgnore = WordsCollection.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        circularShift.getShifts(null);
    }
    
    @Test
    public void testGetShiftsNullWord() {

        WordsCollection wordsToIgnore = WordsCollection.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        wordsToIgnore.addWord("");

        List<String> shifts = circularShift.getShifts("null");
        
        assertTrue(shifts != null);
        assertTrue(shifts.size() == 1);
        assertTrue(shifts.remove("Null"));
    }    
    
    @Test
    public void testGetShiftsEmptyLine() {

    	WordsCollection wordsToIgnore = WordsCollection.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("");
        assertTrue(shifts != null);
        assertTrue(shifts.size() == 1);
        assertTrue(shifts.remove(""));
    }

    // Testing shifts for words with letters and numbers
    @Test
    public void testLetterNumberCircularShifts() throws Exception {
    	
    	WordsCollection wordsToIgnore = WordsCollection.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("nuMb3Rs r g00d n0t evIl");
        
        assertTrue(shifts.size() == 5);
        assertTrue(shifts.remove("Numb3rs R G00d N0t Evil"));
        assertTrue(shifts.remove("R G00d N0t Evil Numb3rs"));
        assertTrue(shifts.remove("G00d N0t Evil Numb3rs R"));
        assertTrue(shifts.remove("N0t Evil Numb3rs R G00d"));
        assertTrue(shifts.remove("Evil Numb3rs R G00d N0t"));

    }

    @Test
    public void testGetShiftsRandomCases() {
    	
    	WordsCollection wordsToIgnore = WordsCollection.create();
    	wordsToIgnore.addWord("shift");
    	
    	CircularShift circularShift = CircularShift.create(wordsToIgnore);
    	List<String> shifts = circularShift.getShifts("tEst this Circular shIft");
        
        assertTrue(shifts.size() == 3);
        assertTrue(shifts.remove("Test This Circular shift"));
        assertTrue(shifts.remove("This Circular shift Test"));
        assertTrue(shifts.remove("Circular shift Test This"));
    }
    
    @Test
    public void testGetShiftWithEmptyWord() {
    	
    	WordsCollection wordsToIgnore = WordsCollection.create();
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
        
        WordsCollection wordsToIgnore = WordsCollection.create();
        wordsToIgnore.addWord("");
        wordsToIgnore.addWord(" ");
        
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("");
        assertTrue(shifts.size() == 0);

        shifts = circularShift.getShifts("       ");
        assertTrue(shifts.size() == 0);
    }
}
