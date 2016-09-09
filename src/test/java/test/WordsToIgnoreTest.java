package test;

import CS3213.WordsToIgnore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsToIgnoreTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        assertFalse(wordsToIgnore.contains("the"));

        wordsToIgnore.addWord("the");
        wordsToIgnore.addWord("of");
        wordsToIgnore.addWord("");
        assertTrue(wordsToIgnore.contains("the"));
        assertTrue(wordsToIgnore.contains("of"));
        assertTrue(wordsToIgnore.contains(""));
        assertFalse(wordsToIgnore.contains("after"));
        assertFalse(wordsToIgnore.contains("before"));

        wordsToIgnore.addWord("of"); // add duplicated word
        wordsToIgnore.addWord("after");
        wordsToIgnore.removeWord("the");
        wordsToIgnore.removeWord("");
        assertFalse(wordsToIgnore.contains("the"));
        assertTrue(wordsToIgnore.contains("of"));
        assertFalse(wordsToIgnore.contains(""));
        assertTrue(wordsToIgnore.contains("after"));
        assertFalse(wordsToIgnore.contains("before"));
    }

    @Test
    public void TestCreateNonNullOutput() {
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
    	assertTrue( wordsToIgnore != null );
    }

    // To affirm that the ignore words are case sensitive
    @Test
    public void testIsWordIgnoreCaseSensitive() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        wordsToIgnore.addWord("A");
        wordsToIgnore.addWord("iGnoreMe");

        assertTrue(wordsToIgnore.contains("A"));
        assertTrue(wordsToIgnore.contains("iGnoreMe"));
        assertFalse(wordsToIgnore.contains("a"));
        assertFalse(wordsToIgnore.contains("ignoreme"));
        assertFalse(wordsToIgnore.contains("Ignoreme"));

        wordsToIgnore.removeWord("iGnoreMe");
        assertFalse(wordsToIgnore.contains("iGnoreMe"));
        
        // Duplicate try again (expand of given)
        wordsToIgnore.addWord("Bananas");
        wordsToIgnore.addWord("Bananas");
        wordsToIgnore.removeWord("Bananas");
        assertFalse(wordsToIgnore.contains("Bananas"));
        
    }

    // To check whether numbers are allowed within ignore words
    @Test
    public void testIsNumberIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        wordsToIgnore.addWord("1");
        wordsToIgnore.addWord("2number");
        wordsToIgnore.addWord("n2mb3r");;
        wordsToIgnore.addWord("num43");
        
        assertTrue(wordsToIgnore.contains("1"));
        assertTrue(wordsToIgnore.contains("2number"));
        assertTrue(wordsToIgnore.contains("n2mb3r"));
        assertTrue(wordsToIgnore.contains("num43"));
        assertFalse(wordsToIgnore.contains("number"));
        assertFalse(wordsToIgnore.contains("num"));
        
        wordsToIgnore.removeWord("num43");
        assertFalse(wordsToIgnore.contains("num43"));

    }

    // To check whether special characters are allowed within ignore words
    @Test
    public void testIsSpecialCharacterIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        wordsToIgnore.addWord("@");
        wordsToIgnore.addWord("nu^*rology");
        wordsToIgnore.addWord("}}work{{{\"");
        wordsToIgnore.addWord(" ");

        assertTrue(wordsToIgnore.contains("@"));
        assertTrue(wordsToIgnore.contains("nu^*rology"));
        assertTrue(wordsToIgnore.contains("}}work{{{\""));
        assertFalse(wordsToIgnore.contains("nurology"));
        assertFalse(wordsToIgnore.contains("work"));
        assertTrue(wordsToIgnore.contains(" "));
        
        wordsToIgnore.removeWord("nu^*rology");
        assertFalse(wordsToIgnore.contains("nu^*rology"));


    }
}
