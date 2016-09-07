package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;

import java.util.HashSet;
import java.util.List;

public class CircularShiftTest {

    @Test
    public void testGetCircularShifts() throws Exception {
        CircularShift circularShift = new CircularShift("tEst this Circular shIft");
        String[] shifts = circularShift.getCircularShifts();
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
    
    @Test
    public void testGetShifts() {
    	
    	CircularShift circularShift = new CircularShift("");
    	List<String> shifts = circularShift.getShifts("shift");
    	assertTrue( shifts != null );
    	assertTrue( shifts.size() == 1 );
    	assertTrue( shifts.contains("Shift") );
    }
}
