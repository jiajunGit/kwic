package CS3213;

import java.util.HashSet;

public class RequiredWords implements CheckableSpecialWordsCollection {

	private HashSet<String> requiredWords;
	
	private RequiredWords() {
		requiredWords = new HashSet<String>();
	}
	
	public static RequiredWords create() {
    	return new RequiredWords();
    }
	
	public boolean removeRequiredWord( String word ) {
		return requiredWords.remove(word);
	}
	
	public boolean addRequiredWord( String word ) {
		assert(word != null);
		return (!word.isEmpty() ? requiredWords.add(word) : false);
	}
	
	public boolean contains( String word ) {
		return requiredWords.contains(word);
	}
	
	public boolean isEmpty() {
		return requiredWords.isEmpty();
	}
	
	public int size() {
		return requiredWords.size();
	}
}
