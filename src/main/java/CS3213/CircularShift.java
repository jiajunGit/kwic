package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is to generate a list of all circular shifts based on the string given.
 */
public class CircularShift {
    public static String DELIMITER = " ";
    private String _line;
    private WordsToIgnore _wordsToIgnore;

    /**
     * input should not be null
     * @param line
     */
    public CircularShift(String line) {
        assert(line != null);
        this._line = line.toLowerCase();
        this._wordsToIgnore = WordsToIgnore.getWordsToIgnore();
    }

    public List<String> getShifts( String line ) {
    	
    	assert(line != null);
    	
    	line = line.toLowerCase();
    	String[] words = capitalizeWordsNotIgnoredInLine(line.split(DELIMITER));
    	
    	LinkedList<Integer> filteredShifts = new LinkedList<Integer>();
    	for( int i = 0, length = words.length; i < length; ++i ){
    		if( !isShiftStartingWithIgnoredWord(words, i) ){
    			filteredShifts.add(i);
    		}
    	}
    	
    	ArrayList<String> resultList = new ArrayList<String>(filteredShifts.size());
    	Iterator<Integer> itr = filteredShifts.iterator();
    	while( itr.hasNext() ){
    		resultList.add(getShiftedLine( itr.next(), words ));
    	}
        
        return resultList;
    }
    
    public String[] getCircularShifts() {
        String[] words = this._line.split(DELIMITER);
        String[] shifts = new String[words.length];
        shifts[0] = this._line;

        for (int i=1;i<words.length;i++) {
            shifts[i] = this.getShiftedLine(i, words);
        }

        String[] filteredShifts = getShiftsWithoutIgnoredWordLeading(shifts);
        for (int i=0;i<filteredShifts.length;i++) {
            filteredShifts[i] = capitalizeWordsNotIgnoredInShift(filteredShifts[i]);
        }

        return filteredShifts;
    }

    private String getShiftedLine(int index, String[] words) {
        StringBuilder builder = new StringBuilder();

        for (int i=index;i<words.length;i++) {
            builder.append(words[i]);
            builder.append(DELIMITER);
        }
        for (int i=0;i<index;i++) {
            builder.append(words[i]);
            builder.append(DELIMITER);
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    private boolean isShiftStartingWithIgnoredWord( String[] line, int firstWordIndex ) {
    	return _wordsToIgnore.isWordIgnored(line[firstWordIndex]);
    }
    
    private String[] getShiftsWithoutIgnoredWordLeading(String[] shifts) {
        List<String> shiftList = new ArrayList<String>(Arrays.asList(shifts));

        Iterator<String> iter = shiftList.iterator();
        while (iter.hasNext()) {
            if (isShiftStartingWithIgnoredWord(iter.next())) {
                iter.remove();
            }
        }

        return shiftList.toArray(new String[shiftList.size()]);
    }

    private boolean isShiftStartingWithIgnoredWord(String line) {
        return this._wordsToIgnore.isWordIgnored(line.split(DELIMITER)[0]);
    }

    private String[] capitalizeWordsNotIgnoredInLine(String[] line) {
    	
    	ArrayList<String> newLine = new ArrayList<String>(line.length);
    	String word;
    	for( int i = 0, size = line.length; i < size; ++i ) {
    		
    		word = line[i];
    		if (_wordsToIgnore.isWordIgnored(word)) {
    			newLine.add(word);
            } else if (word.trim().isEmpty()) {
                continue;
            } else {
            	newLine.add( Character.toUpperCase(word.charAt(0)) + (word.substring(1)) );
            }
    	}
    	
    	return newLine.toArray(new String[newLine.size()]);
    }
    
    private String capitalizeWordsNotIgnoredInShift(String shift) {
        String[] words = shift.split(DELIMITER);
        StringBuilder builder = new StringBuilder();

        for (String str : words) {
            if (this._wordsToIgnore.isWordIgnored(str)) {
                builder.append(str);
            } else if (str.trim().isEmpty()) {
                continue;
            } else {
                builder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1));
            }
            builder.append(DELIMITER);
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
