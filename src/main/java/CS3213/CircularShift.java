package CS3213;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is to generate a list of all circular shifts based on the string given.
 */
public class CircularShift implements AbstractShift {
    private static final String DELIMITER = " ";
    private CheckableSpecialWordsCollection _wordsToIgnore;

    private CircularShift( CheckableSpecialWordsCollection wordsToIgnore ) {
        _wordsToIgnore = wordsToIgnore;
    }
    
    public static CircularShift create( CheckableSpecialWordsCollection wordsToIgnore ) {
    	assert( wordsToIgnore != null );
        return new CircularShift(wordsToIgnore);
    }
    
    public List<String> getShifts( String line ) {
        
        assert(line != null);
        
        String[] words = line.split(DELIMITER);
        
        LinkedList<Integer> filteredShifts = new LinkedList<Integer>();
        for( int i = 0, length = words.length; i < length; ++i ){
            if( !isShiftStartingWithIgnoredWord(words, i) ) {
                filteredShifts.add(i);
            }
        }
        
        words = capitalizeWordsNotIgnoredInLine(words);
        
        ArrayList<String> resultList = new ArrayList<String>(filteredShifts.size());
        Iterator<Integer> itr = filteredShifts.iterator();
        while( itr.hasNext() ){
            resultList.add(getShiftedLine( itr.next(), words ));
        }
        
        return resultList;
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
        return _wordsToIgnore.contains(line[firstWordIndex]);
    }

    private String[] capitalizeWordsNotIgnoredInLine(String[] line) {
        
        ArrayList<String> newLine = new ArrayList<String>(line.length);
        String word;
        for( int i = 0, size = line.length; i < size; ++i ) {
            
            word = line[i];
            if (_wordsToIgnore.contains(word)) {
                newLine.add(word.toLowerCase());
            } else if (word.trim().isEmpty()) {
                continue;
            } else {
                newLine.add( Character.toUpperCase(word.charAt(0)) + (word.toLowerCase().substring(1)) );
            }
        }
        
        return newLine.toArray(new String[newLine.size()]);
    }
}