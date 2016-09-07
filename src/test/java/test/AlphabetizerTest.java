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
    
    @Test
    public void testCreateOutput() {
    	
    	Alphabetizer alphabetizer = Alphabetizer.create();
    	assertTrue(alphabetizer != null);
    }
}