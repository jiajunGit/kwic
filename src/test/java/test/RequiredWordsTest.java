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
    
    @Test
    public void testNumbersSpecialCharacter() {
        
        RequiredWords requiredWords = RequiredWords.create();
        requiredWords.addWord("1234");
        requiredWords.addWord("1n2u3m4");
        requiredWords.addWord("Numb3r");
        requiredWords.addWord("");
        requiredWords.addWord("+");
        requiredWords.addWord(" ");
        
        assertTrue(requiredWords.size() == 5);
        assertTrue(requiredWords.contains("1234"));
        assertTrue(requiredWords.removeWord("1n2u3m4"));
        assertTrue(requiredWords.contains(" "));
        assertTrue(requiredWords.removeWord("+"));
        assertFalse(requiredWords.removeWord("+"));
        assertFalse(requiredWords.removeWord("number"));
        assertFalse(requiredWords.removeWord("    "));
        assertFalse(requiredWords.removeWord(""));
        assertFalse(requiredWords.removeWord("Number"));
        assertFalse(requiredWords.removeWord("numb3r"));
        
    }
    
    @Test
    public void testDoubleRemoveAdd() {
        
        RequiredWords requiredWords = RequiredWords.create();
        requiredWords.addWord("1234");
        requiredWords.addWord("1234");
        requiredWords.addWord("234");
        
        assertTrue(requiredWords.size() == 2);
        assertTrue(requiredWords.contains("1234"));
        assertTrue(requiredWords.removeWord("1234"));
        assertFalse(requiredWords.contains("1234"));
        assertTrue(requiredWords.removeWord("234"));
        assertFalse(requiredWords.removeWord("234"));
        
        
    }

}
