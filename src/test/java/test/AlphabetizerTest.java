package test;

import CS3213.Alphabetizer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
        List<String> output = alphabetizer.getSortedLines();
        assertTrue(output.size() == 4);
        assertEquals("a simple line", output.get(0));
        assertEquals("easy task", output.get(1));
        assertEquals("test a line", output.get(2));
        assertEquals("this is test", output.get(3));
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
        List<String> output = alphabetizer.getSortedLines();
        assertTrue(output.size() == 4);
        
        assertEquals("a duplicate line with major differences", output.get(0));
        assertEquals("a duplicate line with minor differences", output.get(1));
        assertEquals("a duplicate line with similarities", output.get(2));
        assertEquals("a duplicate line without similarities", output.get(3));
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
        List<String> output = alphabetizer.getSortedLines();
        assertTrue(output.size() == 5);

        assertEquals("1sumplenumber", output.get(0));
        assertEquals("2complicatednumbers", output.get(1));
        assertEquals("lam3r", output.get(2));
        assertEquals("lamer", output.get(3));
        assertEquals("placeholder", output.get(4));
        
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
        List<String> output = alphabetizer.getSortedLines();
        assertTrue(output.size() == 6);
        
        assertEquals("", output.get(0));
        assertEquals(" ", output.get(1));
        assertEquals(",,,!!", output.get(2));
        assertEquals(",,,% ", output.get(3));
        assertEquals(":;", output.get(4));
        assertEquals("??@@", output.get(5));
    }
    
    @Test(expected=NullPointerException.class) 
    public void testNullLines() throws Exception {
        Alphabetizer alphabetizer = Alphabetizer.create();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add(null);
        lines.add("null");
        alphabetizer.addLines(lines);
        List<String> output = alphabetizer.getSortedLines();
        assertTrue(output.size() == 2);
        assertEquals(null, output.get(0));
        assertEquals("null", output.get(1));
    }
    
    // All together now
    @Test
    public void testCompleteInput() throws Exception {
        Alphabetizer alphabetizer = Alphabetizer.create();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add(".n.0.");
        lines.add("S0 m34N!");
        lines.add("sh0rt t3s+");
        lines.add("short test");
        lines.add("1337");
        lines.add("^.^");
        alphabetizer.addLines(lines);
        List<String> output = alphabetizer.getSortedLines();
        assertTrue(output.size() == 6);
        
        assertEquals(".n.0.", output.get(0));
        assertEquals("1337", output.get(1));
        assertEquals("S0 m34N!", output.get(2));
        assertEquals("^.^", output.get(3));
        assertEquals("sh0rt t3s+", output.get(4));
        assertEquals("short test", output.get(5));
    }
    
    @Test
    public void testCreateOutput() {
    	
    	Alphabetizer alphabetizer = Alphabetizer.create();
    	assertTrue(alphabetizer != null);
    }
}