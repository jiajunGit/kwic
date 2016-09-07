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
    
    @Test
    public void testCreateOutput() {
    	
    	Alphabetizer alphabetizer = Alphabetizer.create();
    	assertTrue(alphabetizer != null);
    }
}