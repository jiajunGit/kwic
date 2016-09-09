package CS3213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer {
    private List<String> _lines;

    private Alphabetizer() {
        _lines = new ArrayList<String>();
    }

    public static Alphabetizer create() {
        return new Alphabetizer();
    }
    
    public void addLines(List<String> lines) {
        for (String str : lines) {
        	assert(str != null);
            _lines.add(str);
        }
    }

    public List<String> getSortedLines() {
        Collections.sort(_lines);
        return Collections.unmodifiableList(_lines);
    }
}