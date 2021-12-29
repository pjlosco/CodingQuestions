package puzzle;

import org.junit.Assert;
import org.junit.Test;

public class Cipher {


    private final String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] alphaUpperMap = alphabetUpper.toCharArray();

    private final String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private final char[] alphaLowerMap = alphabetLower.toCharArray();

    private final String numbers = "0123456789";
    private final char[] numMap = numbers.toCharArray();

    char getRotatedChar(char input, int rotationFactor) {
        if (!alphabetUpper.contains("" +input) &&
                !alphabetLower.contains("" +input) &&
                !numbers.contains("" +input)) {
            return input;
        }

        int arrayLength = 0;
        char[] map = null;

        if (alphabetUpper.contains(""+input)) {
            map = alphaUpperMap;
            arrayLength = alphabetUpper.length();
        } else if (alphabetLower.contains(""+input)) {
            map = alphaLowerMap;
            arrayLength = alphabetLower.length();
        } else {
            map = numMap;
            arrayLength = 10;
        }

        int actualOffset = rotationFactor % arrayLength;
        for (int index = 0; index < map.length; index++) {
            if (input == map[index]) {
                // matched, stop looking
                if (index + actualOffset > map.length) {
                    actualOffset = index + actualOffset - map.length;
                    return map[actualOffset];
                } else {
                    return map[index + actualOffset];
                }
            }
        }

        return input;
    }


    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char[] output = new char[input.length()];
        int index = 0;
        for (char c : input.toCharArray()) {
            output[index] = getRotatedChar(c, rotationFactor);
            index++;
        }
        return new String(output);
    }

    @Test
    public void test1() {
        String input = "All-convoYs-9-be:Alert1.";
        String expected = "Epp-gsrzsCw-3-fi:Epivx5.";
        Assert.assertEquals(expected, rotationalCipher(input, 4));
    }

    @Test
    public void test2() {
        String input = "abcdZXYzxy-999.@";
        String expected = "stuvRPQrpq-999.@";
        Assert.assertEquals(expected, rotationalCipher(input, 200));
    }
}
