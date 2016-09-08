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
    	assertTrue( requiredWords.addWord("ExAmPle") );
    }
    
    @Test
    public void testAddRequiredWordEmptyWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertFalse( requiredWords.addWord("") );
    }
    
    @Test(expected=AssertionError.class)
    public void testAddRequiredWordNullWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	requiredWords.addWord(null);
    }
    
    @Test
    public void testRemoveRequiredWordAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	String word = "ExAmPLe";
    	requiredWords.addWord(word);
    	assertTrue( requiredWords.removeWord(word) );
    }
    
    @Test
    public void testRemoveRequiredWordNotAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertFalse( requiredWords.removeWord("ExAmPLe") );
    }
    
    @Test(expected=AssertionError.class)
    public void testRemoveRequiredWordNullWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	requiredWords.removeWord(null);
    }
    
    @Test
    public void testContainsAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	String word = "ExAmPLe";
    	requiredWords.addWord(word);
    	assertTrue( requiredWords.contains(word) );
    }
    
    @Test
    public void testContainsNotAddedNormalWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertFalse( requiredWords.contains("ExAmPLe") );
    }
    
    @Test(expected=AssertionError.class)
    public void testContainsNullWord() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	requiredWords.contains(null);
    }
    
    @Test
    public void testIsEmptyWithNoAddedWords() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertTrue(requiredWords.isEmpty());
    }
    
    @Test
    public void testIsEmptyWithAddedWords() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	String word = "ExAmPLe";
    	requiredWords.addWord(word);
    	assertFalse(requiredWords.isEmpty());
    }
    
    @Test
    public void testSizeWithAddedWords() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	String word = "ExAmPLe";
    	requiredWords.addWord(word);
    	assertTrue(requiredWords.size() == 1);
    }
    
    @Test
    public void testSizeWithoutAddedWords() {
    	
    	RequiredWords requiredWords = RequiredWords.create();
    	assertTrue(requiredWords.size() == 0);
    }
    
    // Existence
    // Read the input & store
    

}
