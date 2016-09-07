package CS3213;

import java.util.HashSet;

public class WordsToIgnore implements CheckableSpecialWordsCollection {
    private HashSet<String> _wordsToIgnore;
    
    private WordsToIgnore() {
        _wordsToIgnore = new HashSet<String>();
    }

    public static WordsToIgnore create() {
    	return new WordsToIgnore();
    }

    public void addWordToIgnore(String word) {
        assert(word != null);
        _wordsToIgnore.add(word);
    }

    public void removeWordToIgnore(String word) {
        assert(word != null);
        _wordsToIgnore.remove(word);
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
