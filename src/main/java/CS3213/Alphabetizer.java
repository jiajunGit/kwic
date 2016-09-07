package CS3213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by junchao on 8/23/2014.
 */
public class Alphabetizer {
    private List<String> _lines;

    public Alphabetizer() {
        _lines = new ArrayList<String>();
    }

    public void addLines(String[] lines) {
        for (String str : lines) {
            _lines.add(str);
        }
    }

    public String[] getSortedLines() {
        Collections.sort(_lines);
        return _lines.toArray(new String[_lines.size()]);
    }
}
