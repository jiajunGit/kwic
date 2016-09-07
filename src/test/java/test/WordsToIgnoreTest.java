package test;

import CS3213.WordsToIgnore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsToIgnoreTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();

        assertFalse(wordsToIgnore.isWordIgnored("the"));

        wordsToIgnore.addWordToIgnore("the");
        wordsToIgnore.addWordToIgnore("of");
        wordsToIgnore.addWordToIgnore("");
        assertTrue(wordsToIgnore.isWordIgnored("the"));
        assertTrue(wordsToIgnore.isWordIgnored("of"));
        assertTrue(wordsToIgnore.isWordIgnored(""));
        assertFalse(wordsToIgnore.isWordIgnored("after"));
        assertFalse(wordsToIgnore.isWordIgnored("before"));

        wordsToIgnore.addWordToIgnore("of"); // add duplicated word
        wordsToIgnore.addWordToIgnore("after");
        wordsToIgnore.removeWordToIgnore("the");
        wordsToIgnore.removeWordToIgnore("");
        assertFalse(wordsToIgnore.isWordIgnored("the"));
        assertTrue(wordsToIgnore.isWordIgnored("of"));
        assertFalse(wordsToIgnore.isWordIgnored(""));
        assertTrue(wordsToIgnore.isWordIgnored("after"));
        assertFalse(wordsToIgnore.isWordIgnored("before"));
    }

    // To affirm that the ignore words are case sensitive
    @Test
    public void testIsWordIgnoreCaseSensitive() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();

        wordsToIgnore.addWordToIgnore("A");
        wordsToIgnore.addWordToIgnore("iGnoreMe");

        assertTrue(wordsToIgnore.isWordIgnored("A"));
        assertTrue(wordsToIgnore.isWordIgnored("iGnoreMe"));
        assertFalse(wordsToIgnore.isWordIgnored("a"));
        assertFalse(wordsToIgnore.isWordIgnored("ignoreme"));
        assertFalse(wordsToIgnore.isWordIgnored("Ignoreme"));

        wordsToIgnore.removeWordToIgnore("iGnoreMe");
        assertFalse(wordsToIgnore.isWordIgnored("iGnoreMe"));
        
        // Duplicate try again (expand of given)
        wordsToIgnore.addWordToIgnore("Bananas");
        wordsToIgnore.addWordToIgnore("Bananas");
        wordsToIgnore.removeWordToIgnore("Bananas");
        assertFalse(wordsToIgnore.isWordIgnored("Bananas"));
        
    }

    // To check whether numbers are allowed within ignore words
    @Test
    public void testIsNumberIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();

        wordsToIgnore.addWordToIgnore("1");
        wordsToIgnore.addWordToIgnore("2number");
        wordsToIgnore.addWordToIgnore("n2mb3r");;
        wordsToIgnore.addWordToIgnore("num43");
        
        assertTrue(wordsToIgnore.isWordIgnored("1"));
        assertTrue(wordsToIgnore.isWordIgnored("2number"));
        assertTrue(wordsToIgnore.isWordIgnored("n2mb3r"));
        assertTrue(wordsToIgnore.isWordIgnored("num43"));
        assertFalse(wordsToIgnore.isWordIgnored("number"));
        assertFalse(wordsToIgnore.isWordIgnored("num"));
        
        wordsToIgnore.removeWordToIgnore("num43");
        assertFalse(wordsToIgnore.isWordIgnored("num43"));

    }

    // To check whether special characters are allowed within ignore words
    @Test
    public void testIsSpecialCharacterIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();

        wordsToIgnore.addWordToIgnore("@");
        wordsToIgnore.addWordToIgnore("nu^*rology");
        wordsToIgnore.addWordToIgnore("}}work{{{\"");
        
        assertTrue(wordsToIgnore.isWordIgnored("@"));
        assertTrue(wordsToIgnore.isWordIgnored("nu^*rology"));
        assertTrue(wordsToIgnore.isWordIgnored("}}work{{{\""));
        assertFalse(wordsToIgnore.isWordIgnored("nurology"));
        assertFalse(wordsToIgnore.isWordIgnored("work"));
        
        wordsToIgnore.removeWordToIgnore("nu^*rology");
        assertFalse(wordsToIgnore.isWordIgnored("nu^*rology"));


    }

}
