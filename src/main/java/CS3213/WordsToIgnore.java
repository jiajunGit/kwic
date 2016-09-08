package CS3213;

import java.util.HashSet;

public class WordsToIgnore implements ReadableWordsCollection, ModifiableWordsCollection {
    private HashSet<String> _wordsToIgnore;
    
    private WordsToIgnore() {
        _wordsToIgnore = new HashSet<String>();
    }

    public static WordsToIgnore create() {
    	return new WordsToIgnore();
    }

    public boolean addWord(String word) {
        assert(word != null);
        return _wordsToIgnore.add(word);
    }

    public boolean removeWord(String word) {
        assert(word != null);
        return _wordsToIgnore.remove(word);
    }
    
    public boolean contains(String word) {
    	assert(word != null);
        return _wordsToIgnore.contains(word);
    }
    
    public boolean isEmpty() {
    	return _wordsToIgnore.isEmpty();
    }
    
	public int size() {
		return _wordsToIgnore.size();
	}
}
