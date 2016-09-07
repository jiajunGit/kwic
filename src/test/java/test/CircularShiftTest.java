package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;

import java.util.HashSet;
import java.util.List;

public class CircularShiftTest {
    
    @Test
    public void testGetShiftsOneWord() {
    	
    	CircularShift circularShift = CircularShift.create();
    	List<String> shifts = circularShift.getShifts("shift");
    	assertTrue( shifts != null );
    	assertTrue( shifts.size() == 1 );
    	assertTrue( shifts.contains("Shift") );
    }
    
    @Test
    public void testGetShiftsMultiWord() {
    	
    	CircularShift circularShift = CircularShift.create();
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
    	
    	CircularShift circularShift = CircularShift.create();
    	List<String> shifts = circularShift.getShifts(null);
    }
    
    public void testGetShiftsEmptyLine() {
    	
    	CircularShift circularShift =CircularShift.create();
    	List<String> shifts = circularShift.getShifts("");
    	assertTrue( shifts != null );
    	assertTrue( shifts.size() == 0 );
    }
}
