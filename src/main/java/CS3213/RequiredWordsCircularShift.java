package CS3213;

import java.util.ArrayList;
import java.util.List;

public class RequiredWordsCircularShift {

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
		
		List<String> shifts = new ArrayList<String>();
		shifts.add(line);
		
		return shifts;
	}
}
