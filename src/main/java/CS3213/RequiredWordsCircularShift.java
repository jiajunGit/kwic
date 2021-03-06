package CS3213;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RequiredWordsCircularShift implements AbstractShift {

	private static final String DELIMITER = " ";
	private WordsCollection _requiredWords;
	private WordsCollection _ignoredWords;
	
	private RequiredWordsCircularShift( WordsCollection requiredWords, WordsCollection ignoredWords ) {
		_requiredWords = requiredWords;
		_ignoredWords = ignoredWords;
	}
	
	public static RequiredWordsCircularShift create( WordsCollection requiredWords, WordsCollection ignoredWords ) {
		assert(requiredWords != null && ignoredWords != null);
		return new RequiredWordsCircularShift(requiredWords, ignoredWords);
	}
	
	public List<String> getShifts( String line ) {
		
		assert(line != null && _requiredWords.isEmpty() == false);
		
        String[] words = line.split(DELIMITER);
		
		LinkedList<Integer> filteredShifts = new LinkedList<Integer>();
        for( int i = 0, length = words.length; i < length; ++i ){
            if( isShiftStartingWithRequiredWord(words, i) ) {
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
	
	private boolean isShiftStartingWithRequiredWord( String[] line, int firstWordIndex ) {
        return _requiredWords.contains(line[firstWordIndex]);
    }
	
	private String getShiftedLine(int index, String[] words) {
	    StringBuilder builder = new StringBuilder();
	
	    for (int i=index;i<words.length;i++) {
	    	if(words[i] != null){
		        builder.append(words[i]);
		        builder.append(DELIMITER);
	    	}
	    }
	    for (int i=0;i<index;i++) {
	    	if(words[i] != null) {
		        builder.append(words[i]);
		        builder.append(DELIMITER);
	    	}
	    }
	    if (builder.length() > 0) {
	        builder.deleteCharAt(builder.length() - 1);
	    }
	
	    return builder.toString();
	}
	
	private String[] capitalizeWordsNotIgnoredInLine(String[] line) {
        
        ArrayList<String> newLine = new ArrayList<String>(line.length);
        String word;
        for( int i = 0, size = line.length; i < size; ++i ) {
            
            word = line[i].toLowerCase();
            if (_ignoredWords.contains(word)) {
            	newLine.add(word);
            } else if (word.trim().isEmpty()) {
            	newLine.add(null);
            } else {
            	newLine.add( Character.toUpperCase(word.charAt(0)) + (word.substring(1)) );
            }
        }
        
        return newLine.toArray(new String[newLine.size()]);
    }
}
