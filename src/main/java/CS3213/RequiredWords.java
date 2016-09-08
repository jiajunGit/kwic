package CS3213;

import java.util.HashSet;

public class RequiredWords {

	private HashSet<String> requiredWords;
	
	private RequiredWords() {
		requiredWords = new HashSet<String>();
	}
	
	public static RequiredWords create() {
    	return new RequiredWords();
    }
	
	public boolean addRequiredWord( String word ) {
		return requiredWords.add(word);
	}
}
