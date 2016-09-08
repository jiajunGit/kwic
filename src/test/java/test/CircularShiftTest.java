package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;
import CS3213.WordsToIgnore;

import java.util.HashSet;
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
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        assertTrue(testSet.size() == 4);
        assertTrue(testSet.contains("Test This Circular Shift"));
        assertTrue(testSet.contains("This Circular Shift Test"));
        assertTrue(testSet.contains("Circular Shift Test This"));
        assertTrue(testSet.contains("Shift Test This Circular"));
    }

    @Test(expected=AssertionError.class)
    public void testGetShiftsNullLine() {

    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        circularShift.getShifts(null);
    }

    public void testGetShiftsEmptyLine() {

    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("");
        assertTrue( shifts != null );
        assertTrue( shifts.size() == 0 );
    }

    // Testing shifts for words with letters and numbers
    @Test
    public void testLetterNumberCircularShifts() throws Exception {
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
        CircularShift circularShift = CircularShift.create(wordsToIgnore);
        List<String> shifts = circularShift.getShifts("nuMb3Rs r g00d n0t evIl");
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        assertTrue(testSet.size() == 5);

        assertTrue(testSet.contains("Numb3rs R G00d N0t Evil"));
        assertTrue(testSet.contains("R G00d N0t Evil Numb3rs"));
        assertTrue(testSet.contains("G00d N0t Evil Numb3rs R"));
        assertTrue(testSet.contains("N0t Evil Numb3rs R G00d"));
        assertTrue(testSet.contains("Evil Numb3rs R G00d N0t"));

    }

    @Test
    public void testGetShiftsRandomCases() {
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
    	wordsToIgnore.addWord("shIft");
    	
    	CircularShift circularShift = CircularShift.create(wordsToIgnore);
    	List<String> shifts = circularShift.getShifts("tEst this Circular shIft");
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        assertTrue(testSet.size() == 3);
        assertTrue(testSet.contains("Test This Circular shift"));
        assertTrue(testSet.contains("This Circular shift Test"));
        assertTrue(testSet.contains("Circular shift Test This"));
    }
}
