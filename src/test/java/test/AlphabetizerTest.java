package test;

import CS3213.Alphabetizer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AlphabetizerTest {

    @Test
    public void testGetSortedLines() throws Exception {
        Alphabetizer alphabetizer = Alphabetizer.create();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add("test a line");
        lines.add("a simple line");
        lines.add("this is test");
        lines.add("easy task");
    
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
        Alphabetizer alphabetizer = Alphabetizer.create();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add("a duplicate line with minor differences");
        lines.add("a duplicate line with major differences");
        lines.add("a duplicate line without similarities");
        lines.add("a duplicate line with similarities");
        
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
        Alphabetizer alphabetizer = Alphabetizer.create();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add("1sumplenumber");
        lines.add("2complicatednumbers");
        lines.add("lam3r");
        lines.add("lamer");
        lines.add("placeholder");
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
        Alphabetizer alphabetizer = Alphabetizer.create();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add("");
        lines.add(",,,!!");
        lines.add(",,,% ");
        lines.add(" ");
        lines.add("??@@");
        lines.add(":;");
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
    
    @Test
    public void testCreateOutput() {
    	
    	Alphabetizer alphabetizer = Alphabetizer.create();
    	assertTrue(alphabetizer != null);
    }
}