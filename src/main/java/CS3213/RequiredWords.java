package CS3213;

import java.util.HashSet;

public class RequiredWords implements ReadableWordsCollection, ModifiableWordsCollection {

	private HashSet<String> requiredWords;
	
	private RequiredWords() {
		requiredWords = new HashSet<String>();
	}
	
	public static RequiredWords create() {
    	return new RequiredWords();
    }
	
	public boolean removeWord( String word ) {
		assert(word != null);
		return requiredWords.remove(word);
	}
	
	public boolean addWord( String word ) {
		assert(word != null);
		return (!word.isEmpty() ? requiredWords.add(word) : false);
	}
	
	public boolean contains( String word ) {
		assert(word != null);
		return requiredWords.contains(word);
	}
	
	public boolean isEmpty() {
		return requiredWords.isEmpty();
	}
	
	public int size() {
		return requiredWords.size();
	}
}
