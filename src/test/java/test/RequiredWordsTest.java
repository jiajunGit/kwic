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
    
    // Existence
    // Read the input & store
    

}