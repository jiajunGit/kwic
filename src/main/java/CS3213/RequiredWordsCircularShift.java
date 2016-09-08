package CS3213;

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
		return null;
	}
}
