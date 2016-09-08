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
    
    @Test
    public void testRemoveRequiredWordAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	String word = "ExAmPLe";
    	requiredWords.addRequiredWord(word);
    	assertTrue( requiredWords.removeRequiredWord(word) );
    }
    
    @Test
    public void testRemoveRequiredWordNotAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertFalse( requiredWords.removeRequiredWord("ExAmPLe") );
    }
    
    @Test
    public void testContainsAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	String word = "ExAmPLe";
    	requiredWords.addRequiredWord(word);
    	assertTrue( requiredWords.contains(word) );
    }
    
    // Existence
    // Read the input & store
    

}
