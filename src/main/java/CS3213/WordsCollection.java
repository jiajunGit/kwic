package CS3213;

import java.util.HashSet;

public class WordsCollection {
    private HashSet<String> _words;
    
    private WordsCollection() {
        _words = new HashSet<String>();
    }

    public static WordsCollection create() {
    	return new WordsCollection();
    }

    public boolean addWord(String word) {
        assert(word != null);
        return _words.add(word);
    }

    public boolean removeWord(String word) {
        assert(word != null);
        return _words.remove(word);
    }
    
    public boolean contains(String word) {
    	assert(word != null);
        return _words.contains(word);
    }
    
    public boolean isEmpty() {
    	return _words.isEmpty();
    }
    
	public int size() {
		return _words.size();
	}
}
