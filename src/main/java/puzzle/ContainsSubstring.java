package puzzle;

import org.junit.Assert;
import org.junit.Test;

public class ContainsSubstring {

    static boolean isContainedInString(String string1, String string2) {
        if (string1.equals(string2)) {
            return true;
        }
        if (string1.length() < 1 || string2.length() < 1 || string2.length() > string1.length()) {
            return false;
        }
        if (string1.charAt(0) == string2.charAt(0)) {
            return string2.length() - 1 == 0 || isContainedInString(string1.substring(1), string2.substring(1));
        } else {
            return isContainedInString(string1.substring(1), string2);
        }
    }

    @Test
    public void Equal() {
        String bigString = "string";
        String subString = "string";
        Assert.assertTrue(isContainedInString(bigString, subString));
    }
    @Test
    public void Equal2() {
        String bigString = "The string";
        String subString = "string";
        Assert.assertTrue(isContainedInString(bigString, subString));
    }

    @Test
    public void Contained1() {
        String bigString = "This is the entered string. There might be a substring in it";
        String subString = "string";
        Assert.assertTrue(isContainedInString(bigString, subString));
    }
    @Test
    public void Contained2() {
        String bigString = "This is the entered string. There might be a substring in it";
        String subString = "s";
        Assert.assertTrue(isContainedInString(bigString, subString));
    }

    @Test
    public void NotContained() {
        String bigString = "This is the entered string. There might be a substring in it";
        String subString = "ain't here";
        Assert.assertFalse(isContainedInString(bigString, subString));
    }
}
