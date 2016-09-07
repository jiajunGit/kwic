package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class is to generate a list of all circular shifts based on the string given.
 */
public class CircularShift {
    public static String DELIMITER = " ";
    private String _line;
    private WordsToIgnore _wordsToIgnore;

    /**
     * input should not be null
     * @param line
     */
    public CircularShift(String line) {
        assert(line != null);
        _line = line.toLowerCase();
        _wordsToIgnore = WordsToIgnore.getWordsToIgnore();
    }

    public String[] getCircularShifts() {
        String[] words = _line.split(DELIMITER);
        String[] shifts = new String[words.length];
        shifts[0] = _line;

        for (int i=1;i<words.length;i++) {
            shifts[i] = getShiftedLine(i, words);
        }

        String[] filteredShifts = getShiftsWithoutIgnoredWordLeading(shifts);
        for (int i=0;i<filteredShifts.length;i++) {
            filteredShifts[i] = capitalizeWordsNotIgnoredInShift(filteredShifts[i]);
        }

        return filteredShifts;
    }

    private String getShiftedLine(int index, String[] words) {
        StringBuilder builder = new StringBuilder();

        for (int i=index;i<words.length;i++) {
            builder.append(words[i]);
            builder.append(DELIMITER);
        }
        for (int i=0;i<index;i++) {
            builder.append(words[i]);
            builder.append(DELIMITER);
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    private String[] getShiftsWithoutIgnoredWordLeading(String[] shifts) {
        List<String> shiftList = new ArrayList<String>(Arrays.asList(shifts));

        Iterator<String> iter = shiftList.iterator();
        while (iter.hasNext()) {
            if (isShiftStartingWithIgnoredWord(iter.next())) {
                iter.remove();
            }
        }

        return shiftList.toArray(new String[shiftList.size()]);
    }

    private boolean isShiftStartingWithIgnoredWord(String line) {
        return _wordsToIgnore.isWordIgnored(line.split(DELIMITER)[0]);
    }

    private String capitalizeWordsNotIgnoredInShift(String shift) {
        String[] words = shift.split(DELIMITER);
        StringBuilder builder = new StringBuilder();

        for (String str : words) {
            if (_wordsToIgnore.isWordIgnored(str)) {
                builder.append(str);
            } else if (str.trim().isEmpty()) {
                continue;
            } else {
                builder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1));
            }
            builder.append(DELIMITER);
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
