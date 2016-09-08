package test;

import static org.junit.Assert.assertTrue;

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
}
