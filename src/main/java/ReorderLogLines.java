import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReorderLogLines {

    /**
     * You have been given a task of reordering some data from a log file.
     * In the log file, every line is a space-delimited list of strings;
     * all lines begin with an alphanumeric identifier
     * There will be no lines consisting only of an identifier.
     * After the alphanumeric identifier, a line will consist of either:
     * a list of words using only lowercase English letters,
     * or list of only integers.
     * You have to reorder the data such that all of the lines with words are at the top of the log file.
     * The lines with words are ordered lexicographically, ignoring the identifier except in the case of ties.
     * In the case of ties (if there are two lines that are identical except for the identifier),
     * the identifier is used to order lexicographically. Alphanumeric should be sorted in ASCII order
     * (numbers come before letters). The identifiers must still be part of the lines in the output Strings.
     * Lines with integers must be left in the original order they were in the file.
     * Write an algorithm to reorder the data in the log file, according to the rules above.
     * @param logFileSize an integer representing the number of log lines
     * @param logLines a list of strings representing the log file.
     * @return Return a list of strings representing the reordered log file data.
     */
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        if (logFileSize != logLines.size()) {
            throw new RuntimeException("Bad data");
        }

        ArrayList<String> orderedList = new ArrayList<>();
        ArrayList<String> noWordsList = new ArrayList<>();
        for (String line : logLines) {
            line = line.replaceAll("\\[", "");
            line = line.replaceAll("\\]", "");
            String[] words = line.split(" ");
            boolean hasAnyRealWords = false;
            Pattern numberPat = Pattern.compile("\\d+");
            Matcher match = numberPat.matcher(words[1]);
            if (!match.find()) {
                line = words[1] + " " + words[2] + " " + words[3] + " " + words[0];
                orderedList.add(line);
            } else {
                noWordsList.add(line);
            }
        }
        orderedList.sort(Comparator.naturalOrder());
        ArrayList<String> reallyOrderedList = new ArrayList<>();
        for (String line : orderedList) {
            String[] words = line.split(" ");
            line = words[3] + " " + words[0] + " " + words[1] + " " + words[2];
            reallyOrderedList.add(line);
        }
        reallyOrderedList.addAll(noWordsList);
        return reallyOrderedList;
    }
}
