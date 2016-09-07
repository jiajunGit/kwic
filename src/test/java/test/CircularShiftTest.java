package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;

import java.util.HashSet;

public class CircularShiftTest {

    @Test
    public void testGetCircularShifts() throws Exception {
        CircularShift circularShit = new CircularShift("tEst this Circular shIft");
        String[] shifts = circularShit.getCircularShifts();
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
    
    // Testing shifts for words with letters and numbers
    @Test
    public void testLetterNumberCircularShifts() throws Exception {
        CircularShift circularShit = new CircularShift("nuMb3Rs r g00d n0t evIl");
        String[] shifts = circularShit.getCircularShifts();
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
}
