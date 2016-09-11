package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.WordsCollection;

public class WordsCollectionTest {

    @Test
    public void testCreate() {
       
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertTrue( wordsCollection != null );
    }
    
    @Test
    public void testAddRequiredWordNormalWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertTrue( wordsCollection.addWord("ExAmPle") );
    }
    
    @Test
    public void testAddRequiredWordEmptyWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertTrue( wordsCollection.addWord("") );
    }
    
    @Test(expected=AssertionError.class)
    public void testAddRequiredWordNullWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	wordsCollection.addWord(null);
    }
    
    @Test
    public void testRemoveRequiredWordAddedNormalWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	String word = "ExAmPLe";
    	wordsCollection.addWord(word);
    	assertTrue( wordsCollection.removeWord(word) );
    }
    
    @Test
    public void testRemoveRequiredWordNotAddedNormalWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertFalse( wordsCollection.removeWord("ExAmPLe") );
    }
    
    @Test(expected=AssertionError.class)
    public void testRemoveRequiredWordNullWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	wordsCollection.removeWord(null);
    }
    
    @Test
    public void testContainsAddedNormalWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	String word = "ExAmPLe";
    	wordsCollection.addWord(word);
    	assertTrue( wordsCollection.contains(word) );
    }
    
    @Test
    public void testContainsNotAddedNormalWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertFalse( wordsCollection.contains("ExAmPLe") );
    }
    
    @Test(expected=AssertionError.class)
    public void testContainsNullWord() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	wordsCollection.contains(null);
    }
    
    @Test
    public void testIsEmptyWithNoAddedWords() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertTrue(wordsCollection.isEmpty());
    }
    
    @Test
    public void testIsEmptyWithAddedWords() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	String word = "ExAmPLe";
    	wordsCollection.addWord(word);
    	assertFalse(wordsCollection.isEmpty());
    }
    
    @Test
    public void testSizeWithAddedWords() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	String word = "ExAmPLe";
    	wordsCollection.addWord(word);
    	assertTrue(wordsCollection.size() == 1);
    }
    
    @Test
    public void testSizeWithoutAddedWords() {
    	
    	WordsCollection wordsCollection = WordsCollection.create();
    	assertTrue(wordsCollection.size() == 0);
    }
    
    @Test
    public void testNumbersSpecialCharacter() {
        
        WordsCollection wordsCollection = WordsCollection.create();
        wordsCollection.addWord("1234");
        wordsCollection.addWord("1n2u3m4");
        wordsCollection.addWord("Numb3r");
        wordsCollection.addWord("");
        wordsCollection.addWord("+");
        wordsCollection.addWord(" ");
        
        assertTrue(wordsCollection.size() == 6);
        assertTrue(wordsCollection.contains("1234"));
        assertTrue(wordsCollection.removeWord("1n2u3m4"));
        assertTrue(wordsCollection.contains(" "));
        assertTrue(wordsCollection.removeWord("+"));
        assertTrue(wordsCollection.removeWord(""));
        assertTrue(wordsCollection.removeWord("Numb3r"));
        
    }
    
    @Test
    public void testDoubleRemoveAdd() {
        
        WordsCollection wordsCollection = WordsCollection.create();
        wordsCollection.addWord("1234");
        wordsCollection.addWord("1234");
        wordsCollection.addWord("234");
        
        assertTrue(wordsCollection.size() == 2);
        assertTrue(wordsCollection.contains("1234"));
        assertTrue(wordsCollection.removeWord("1234"));
        assertFalse(wordsCollection.contains("1234"));
        assertTrue(wordsCollection.removeWord("234"));
        assertFalse(wordsCollection.removeWord("234"));
        
        
    }
    
    @Test
    public void testIsWordIgnored() throws Exception {
        WordsCollection wordsToIgnore = WordsCollection.create();

        assertFalse(wordsToIgnore.removeWord("the"));

        wordsToIgnore.addWord("the");
        wordsToIgnore.addWord("of");
        wordsToIgnore.addWord("");
        assertTrue(wordsToIgnore.removeWord("the"));
        assertTrue(wordsToIgnore.removeWord("of"));
        assertTrue(wordsToIgnore.removeWord(""));
        assertFalse(wordsToIgnore.removeWord("after"));
        assertFalse(wordsToIgnore.removeWord("before"));

        wordsToIgnore.addWord("of"); // add duplicated word
        wordsToIgnore.addWord("after");
        wordsToIgnore.removeWord("the");
        wordsToIgnore.removeWord("");
        assertFalse(wordsToIgnore.removeWord("the"));
        assertTrue(wordsToIgnore.removeWord("of"));
        assertFalse(wordsToIgnore.removeWord(""));
        assertTrue(wordsToIgnore.removeWord("after"));
        assertFalse(wordsToIgnore.removeWord("before"));
    }

    @Test
    public void TestCreateNonNullOutput() {
    	
    	WordsCollection wordsToIgnore = WordsCollection.create();
    	assertTrue( wordsToIgnore != null );
    }

    // To affirm that the ignore words are case sensitive
    @Test
    public void testIsWordIgnoreCaseSensitive() throws Exception {
        WordsCollection wordsToIgnore = WordsCollection.create();

        wordsToIgnore.addWord("A");
        wordsToIgnore.addWord("iGnoreMe");

        assertTrue(wordsToIgnore.removeWord("A"));
        assertTrue(wordsToIgnore.removeWord("iGnoreMe"));
        assertFalse(wordsToIgnore.removeWord("a"));
        assertFalse(wordsToIgnore.removeWord("ignoreme"));
        assertFalse(wordsToIgnore.removeWord("Ignoreme"));

        wordsToIgnore.removeWord("iGnoreMe");
        assertFalse(wordsToIgnore.removeWord("iGnoreMe"));
        
        // Duplicate try again (expand of given)
        wordsToIgnore.addWord("Bananas");
        wordsToIgnore.addWord("Bananas");
        wordsToIgnore.removeWord("Bananas");
        assertFalse(wordsToIgnore.removeWord("Bananas"));
        
    }

    // To check whether numbers are allowed within ignore words
    @Test
    public void testIsNumberIgnored() throws Exception {
        WordsCollection wordsToIgnore = WordsCollection.create();

        wordsToIgnore.addWord("1");
        wordsToIgnore.addWord("2number");
        wordsToIgnore.addWord("n2mb3r");;
        wordsToIgnore.addWord("num43");
        
        assertTrue(wordsToIgnore.removeWord("1"));
        assertTrue(wordsToIgnore.removeWord("2number"));
        assertTrue(wordsToIgnore.removeWord("n2mb3r"));
        assertTrue(wordsToIgnore.removeWord("num43"));
        assertFalse(wordsToIgnore.removeWord("number"));
        assertFalse(wordsToIgnore.removeWord("num"));
        
        wordsToIgnore.removeWord("num43");
        assertFalse(wordsToIgnore.removeWord("num43"));

    }

    // To check whether special characters are allowed within ignore words
    @Test
    public void testIsSpecialCharacterIgnored() throws Exception {
        WordsCollection wordsToIgnore = WordsCollection.create();

        wordsToIgnore.addWord("@");
        wordsToIgnore.addWord("nu^*rology");
        wordsToIgnore.addWord("}}work{{{\"");
        wordsToIgnore.addWord(" ");

        assertTrue(wordsToIgnore.removeWord("@"));
        assertTrue(wordsToIgnore.removeWord("nu^*rology"));
        assertTrue(wordsToIgnore.removeWord("}}work{{{\""));
        assertFalse(wordsToIgnore.removeWord("nurology"));
        assertFalse(wordsToIgnore.removeWord("work"));
        assertTrue(wordsToIgnore.removeWord(" "));
        
        wordsToIgnore.removeWord("nu^*rology");
        assertFalse(wordsToIgnore.removeWord("nu^*rology"));


    }

}
