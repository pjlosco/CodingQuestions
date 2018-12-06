import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CommonWordTest {

    CommonWords solution = new CommonWords();

    /**
     * Input:
     *   literatureText = “Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill’s favorite food.”
     *   wordsToExclude = ["and", "he", "the", "to", "is", "Jack", "Jill"]
     * Output:
     *   ["cheese", “s”]
     * Explanation:
     *   The word “and” has a maximum of three frequency but this word should be excluded while analyzing the word frequency.
     *   The words “Jack”, “Jill”, “s”, "to" and "cheese” have the next maximum frequency(two) in the given text but
     *   the words “Jack”, "to" and “Jill” should be excluded as these are commonly used words which you are not
     *   interested to include.
     *   So the output is ["cheese", “s”] or [“s”, "cheese"] as the order of words does not matter.
     */
    @Test
    public void inputTest() {
        ArrayList<String> exclusionList = new ArrayList<>();
        exclusionList.add("and");
        exclusionList.add("to");
        exclusionList.add("is");
        exclusionList.add("the");
        exclusionList.add("jill");
        exclusionList.add("jack");

        ArrayList<String> expectedWords = new ArrayList<>();
        expectedWords.add("cheese");
        expectedWords.add("s");

        String test = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill’s favorite food.";
        Assert.assertEquals(solution.retrieveMostFrequentlyUsedWords(test, exclusionList), expectedWords);
    }
}
