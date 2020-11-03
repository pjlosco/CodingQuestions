import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array, arrange the elements such that the number formed by concatenating the elements is highest.
 * E.g.: input = [9, 93, 24, 6],
 * the output should be: [9,93,6,24].
 *  This is because if you concatenate all the numbers,
 * 993624 is the highest number that can be formed.
 */
public class HighestConcatenate {

    public static ArrayList<Integer> activate(int[] unsortedInput) {
        List<Integer> list = Arrays.stream(unsortedInput).boxed().collect(Collectors.toList());
        return activate(new ArrayList<>(list));
    }

    public static ArrayList<Integer> activate(ArrayList<Integer> unsortedInput) {

        ArrayList<Integer> sortedOutput = new ArrayList<>();

        // loop through array
        for (Integer element : unsortedInput) {
            if (sortedOutput.size() == 0) {
                // if result has nothing yet its sorted, just add
                sortedOutput.add(element);
            } else {
                // if result already contains items, find a place to add
                int indexOfSortedOutput;
                for (indexOfSortedOutput = 0; indexOfSortedOutput < sortedOutput.size(); indexOfSortedOutput++) {
                    if (element.equals(sortedOutput.get(indexOfSortedOutput))) {
                        // the index of where we are comparing is equal therefor we can add it
                        break;
                    }
                    if (isElementStartingValueHigher(element, sortedOutput.get(indexOfSortedOutput))) {
                        break;
                    }
                }
                sortedOutput.add(indexOfSortedOutput, element);
            }
        }

        return sortedOutput;
    }

    public static boolean isElementStartingValueHigher(int elementInteger, int comparingInteger) {
        // compare first integer in number
        String elementAsString = Integer.toString(elementInteger);
        String comparingIntegerAsString = Integer.toString(comparingInteger);
        Integer digitOfElement;
        Integer digitOfComparison;

        for (int elementIndex = 0; elementIndex <  elementAsString.length(); elementIndex++) {
            try {
                digitOfElement = Integer.parseInt(elementAsString.substring(elementIndex, elementIndex + 1));
            } catch (IndexOutOfBoundsException e) {
                return true;
            }
            try {
                digitOfComparison = Integer.parseInt(comparingIntegerAsString.substring(elementIndex, elementIndex+1));
            } catch (IndexOutOfBoundsException e) {
                return false;
            }

            if (digitOfElement > digitOfComparison) {
                return true;
            } else if (digitOfElement < digitOfComparison) {
                return false;
            }
        }
        return false;
    }

    @Test
    public void testSample() {
        int[] sampleArray = {9, 93, 24, 6};
        int[] expectedArray = {9, 93, 6, 24};
        ArrayList<Integer> result = activate(sampleArray);
        int[] resultArray = result.stream().mapToInt(i->i).toArray();
        Assert.assertEquals(resultArray, expectedArray);
    }

    @Test
    public void emptyCheck() {

    }

    @Test
    public void nullCheck() {

    }

    @Test
    public void longNumber() {

    }

    @Test
    public void lotsOfValues() {

    }

    @Test
    public void stressTest() {

    }
}
