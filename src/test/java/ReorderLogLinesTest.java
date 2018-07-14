import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReorderLogLinesTest {

    ReorderLogLines reorderLogLines = new ReorderLogLines();

    /**
     * Note: Identifier consists of only lower case english character and numbers.</p>
     * Example
     * Input: logFileSize = 5
     *        logLines = [a1 9 2 3 1], [g1 act car], [zo4 4 7], [ab1 off key dog], [a8 act zoo]
     * Output: [g1 act car], [a8 act zoo], [ab1 off key dog], [a1 9 2 3 1], [zo4 4 7]
     * Explanation: Second, fourth, and fifth lines are the lines with words.
     *      According to the lexicographical order, the second line will be reordered first in the log file,
     *      then fifth, and the fourth comes in the log file. Next, the lines with numbers come in the order
     *      in which these lines were in the input.</p></div>
     */
    @Test
    public void inputTest() {
        int logFileSize = 4;
        ArrayList<String> actualWords = new ArrayList<>();
        actualWords.add("[mi2 jog mid pet]");
        actualWords.add("[wz3 34 54 398]");
        actualWords.add("[a1 alps cow bar]");
        actualWords.add("[x4 45 21 7]");

        ArrayList<String> expectedWords = new ArrayList<>();
        expectedWords.add("a1 alps cow bar");
        expectedWords.add("mi2 jog mid pet");
        expectedWords.add("wz3 34 54 398");
        expectedWords.add("x4 45 21 7");

        Assert.assertEquals(expectedWords, reorderLogLines.reorderLines(logFileSize, actualWords));
    }

    @Test
    public void input2Test() {
        int logFileSize = 6;
        ArrayList<String> actualWords = new ArrayList<>();
        actualWords.add("[t2 13 121 98]");
        actualWords.add("[r1 box ape bit]");
        actualWords.add("[b4 xi me nu]");
        actualWords.add("[br8 eat nim did]");
        actualWords.add("[w1 has uni gry]");
        actualWords.add("[f3 52 54 31]");

        ArrayList<String> expectedWords = new ArrayList<>();
        actualWords.add("r1 box ape bit");
        actualWords.add("br8 eat nim did");
        actualWords.add("w1 has uni gry");
        actualWords.add("b4 xi me nu");
        actualWords.add("t2 13 121 98");
        actualWords.add("f3 52 54 31");

        Assert.assertEquals(expectedWords, reorderLogLines.reorderLines(logFileSize, actualWords));
    }
}
