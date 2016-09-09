package test;

import CS3213.WordsToIgnore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsToIgnoreTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

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
    	
    	WordsToIgnore wordsToIgnore = WordsToIgnore.create();
    	assertTrue( wordsToIgnore != null );
    }

    // To affirm that the ignore words are case sensitive
    @Test
    public void testIsWordIgnoreCaseSensitive() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

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
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

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
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

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
