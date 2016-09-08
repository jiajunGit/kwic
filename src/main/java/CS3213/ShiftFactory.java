package CS3213;

import CS3213.CircularShift;

public class ShiftFactory {

	private static ShiftFactory _shiftFactory = null;
	
	private ShiftFactory() {}
	
	public static ShiftFactory getInstance() {
		
		if(_shiftFactory == null){
			_shiftFactory = new ShiftFactory();
		}
		return _shiftFactory;
	}
	
	public AbstractShift getShifter( ReadableWordsCollection ignoredWords, ReadableWordsCollection requiredWords ) {
		
		assert( requiredWords != null );
		
		if( requiredWords.isEmpty() ){
			return CircularShift.create(ignoredWords);
		}
		else {
			return RequiredWordsCircularShift.create(requiredWords, ignoredWords);
		}
	}
}
