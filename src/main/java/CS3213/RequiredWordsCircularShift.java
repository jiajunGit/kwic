package CS3213;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RequiredWordsCircularShift {

	private static final String DELIMITER = " ";
	private CheckableSpecialWordsCollection _requiredWords;
	
	private RequiredWordsCircularShift( CheckableSpecialWordsCollection requiredWords ) {
		_requiredWords = requiredWords;
	}
	
	public static RequiredWordsCircularShift create( CheckableSpecialWordsCollection requiredWords ) {
		assert(requiredWords != null);
		return new RequiredWordsCircularShift(requiredWords);
	}
	
	public List<String> getShifts( String line ) {
		
		assert(_requiredWords.isEmpty() == false);
		
		String[] words = line.split(DELIMITER);
		
		LinkedList<Integer> filteredShifts = new LinkedList<Integer>();
        for( int i = 0, length = words.length; i < length; ++i ){
            if( isShiftStartingWithRequiredWord(words, i) ) {
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
	
	private boolean isShiftStartingWithRequiredWord( String[] line, int firstWordIndex ) {
        return _requiredWords.contains(line[firstWordIndex]);
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
}
