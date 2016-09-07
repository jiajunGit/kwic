package test;

import CS3213.WordsToIgnore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsToIgnoreTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        assertFalse(wordsToIgnore.contains("the"));

        wordsToIgnore.addWordToIgnore("the");
        wordsToIgnore.addWordToIgnore("of");
        wordsToIgnore.addWordToIgnore("");
        assertTrue(wordsToIgnore.contains("the"));
        assertTrue(wordsToIgnore.contains("of"));
        assertTrue(wordsToIgnore.contains(""));
        assertFalse(wordsToIgnore.contains("after"));
        assertFalse(wordsToIgnore.contains("before"));

        wordsToIgnore.addWordToIgnore("of"); // add duplicated word
        wordsToIgnore.addWordToIgnore("after");
        wordsToIgnore.removeWordToIgnore("the");
        wordsToIgnore.removeWordToIgnore("");
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

        wordsToIgnore.addWordToIgnore("A");
        wordsToIgnore.addWordToIgnore("iGnoreMe");

        assertTrue(wordsToIgnore.contains("A"));
        assertTrue(wordsToIgnore.contains("iGnoreMe"));
        assertFalse(wordsToIgnore.contains("a"));
        assertFalse(wordsToIgnore.contains("ignoreme"));
        assertFalse(wordsToIgnore.contains("Ignoreme"));

        wordsToIgnore.removeWordToIgnore("iGnoreMe");
        assertFalse(wordsToIgnore.contains("iGnoreMe"));
        
        // Duplicate try again (expand of given)
        wordsToIgnore.addWordToIgnore("Bananas");
        wordsToIgnore.addWordToIgnore("Bananas");
        wordsToIgnore.removeWordToIgnore("Bananas");
        assertFalse(wordsToIgnore.contains("Bananas"));
        
    }

    // To check whether numbers are allowed within ignore words
    @Test
    public void testIsNumberIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        wordsToIgnore.addWordToIgnore("1");
        wordsToIgnore.addWordToIgnore("2number");
        wordsToIgnore.addWordToIgnore("n2mb3r");;
        wordsToIgnore.addWordToIgnore("num43");
        
        assertTrue(wordsToIgnore.contains("1"));
        assertTrue(wordsToIgnore.contains("2number"));
        assertTrue(wordsToIgnore.contains("n2mb3r"));
        assertTrue(wordsToIgnore.contains("num43"));
        assertFalse(wordsToIgnore.contains("number"));
        assertFalse(wordsToIgnore.contains("num"));
        
        wordsToIgnore.removeWordToIgnore("num43");
        assertFalse(wordsToIgnore.contains("num43"));

    }

    // To check whether special characters are allowed within ignore words
    @Test
    public void testIsSpecialCharacterIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.create();

        wordsToIgnore.addWordToIgnore("@");
        wordsToIgnore.addWordToIgnore("nu^*rology");
        wordsToIgnore.addWordToIgnore("}}work{{{\"");
        
        assertTrue(wordsToIgnore.contains("@"));
        assertTrue(wordsToIgnore.contains("nu^*rology"));
        assertTrue(wordsToIgnore.contains("}}work{{{\""));
        assertFalse(wordsToIgnore.contains("nurology"));
        assertFalse(wordsToIgnore.contains("work"));
        
        wordsToIgnore.removeWordToIgnore("nu^*rology");
        assertFalse(wordsToIgnore.contains("nu^*rology"));


    }
}
