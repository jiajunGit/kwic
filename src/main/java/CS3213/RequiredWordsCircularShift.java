package CS3213;

import java.util.ArrayList;
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
		
		ArrayList<String> resultList = new ArrayList<String>(words.length);
		for(int i = 0, size = words.length; i < size; ++i) {
			resultList.add(getShiftedLine( i, words ));
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
}
