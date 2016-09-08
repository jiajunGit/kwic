package CS3213;

public class ShiftFactory {

	private static ShiftFactory _shiftFactory = null;
	
	private ShiftFactory() {}
	
	public static ShiftFactory getInstance() {
		
		if(_shiftFactory == null){
			_shiftFactory = new ShiftFactory();
		}
		return _shiftFactory;
	}
}
