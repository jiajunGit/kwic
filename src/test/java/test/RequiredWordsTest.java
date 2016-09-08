package test;

//import CS3213.RequiredWords;
import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.RequiredWords;

public class RequiredWordsTest {

    @Test
    public void testCreate() {
       
    	RequiredWords requiredWords = RequiredWords.create();
    	assertTrue( requiredWords != null );
    }
    
    @Test
    public void testAddRequiredWordNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertTrue( requiredWords.addRequiredWord("ExAmPle") );
    }
    
    @Test
    public void testAddRequiredWordEmptyWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertFalse( requiredWords.addRequiredWord("") );
    }
    
    @Test(expected=AssertionError.class)
    public void testAddRequiredWordNullWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	requiredWords.addRequiredWord(null);
    }
    
    // Existence
    // Read the input & store
    

}
