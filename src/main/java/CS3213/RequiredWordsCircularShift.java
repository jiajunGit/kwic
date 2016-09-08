package CS3213;

public class RequiredWordsCircularShift {

	private CheckableSpecialWordsCollection _requiredWords;
	
	private RequiredWordsCircularShift( CheckableSpecialWordsCollection requiredWords ) {
		_requiredWords = requiredWords;
	}
	
	public static RequiredWordsCircularShift create( CheckableSpecialWordsCollection requiredWords ) {
		return new RequiredWordsCircularShift(requiredWords);
	}
	
	
}