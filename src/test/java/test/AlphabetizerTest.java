package test;

import CS3213.Alphabetizer;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetizerTest {

    @Test
    public void testGetSortedLines() throws Exception {
        Alphabetizer alphabetizer = new Alphabetizer();

        String[] lines = {"test a line", "a simple line", "this is test", "easy task"};
        alphabetizer.addLines(lines);
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 4);
        assertEquals("a simple line", output[0]);
        assertEquals("easy task", output[1]);
        assertEquals("test a line", output[2]);
        assertEquals("this is test", output[3]);
    }
    
    // See if alphabetical throughout or only first word
    @Test
    public void testAlphabeticalSort() throws Exception {
        Alphabetizer alphabetizer = new Alphabetizer();

        String[] lines = {"a duplicate line with minor differences", "a duplicate line with major differences",
                "a duplicate line without similarities", "a duplicate line with similarities"};
        alphabetizer.addLines(lines);
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 4);
        
        assertEquals("a duplicate line with major differences", output[0]);
        assertEquals("a duplicate line with minor differences", output[1]);
        assertEquals("a duplicate line with similarities", output[2]);
        assertEquals("a duplicate line without similarities", output[3]);
    }
    
    // Number & Letter combinations sorting order
    @Test
    public void testAlphabeticalNumberLetter() throws Exception {
        Alphabetizer alphabetizer = new Alphabetizer();

        String[] lines = {"1sumplenumber", "2complicatednumbers", "lam3r", "lamer", "placeholder"};
        alphabetizer.addLines(lines);
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 5);

        assertEquals("1sumplenumber", output[0]);
        assertEquals("2complicatednumbers", output[1]);
        assertEquals("lam3r", output[2]);
        assertEquals("lamer", output[3]);
        assertEquals("placeholder", output[4]);
        
    }
    
    // Test if special characters are sorted by ASCII values
    @Test
    public void testAlphabeticalSpecial() throws Exception {
        Alphabetizer alphabetizer = new Alphabetizer();

        String[] lines = {"", ",,,!!", ",,,% ", " ", "??@@", ":;"};
        alphabetizer.addLines(lines);
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 6);
        
        assertEquals("", output[0]);
        assertEquals(" ", output[1]);
        assertEquals(",,,!!", output[2]);
        assertEquals(",,,% ", output[3]);
        assertEquals(":;", output[4]);
        assertEquals("??@@", output[5]);
        
    }
    
}