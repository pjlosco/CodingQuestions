package puzzle;

import org.junit.Assert;
import org.junit.Test;

public class BalancedParentheses {

    static boolean isBalanced(String s) {
        char[] expectedCloser = new char[((s.length()/2)+1)];
        int closerIndex = 0;
        char[] input = s.toCharArray();
        int pCount = 0;
        int bCount = 0;
        int cCount = 0;
        for (char c : input) {
            switch(c) {
                case '(':
                    pCount++;
                    expectedCloser[closerIndex] = ')';
                    closerIndex++;
                    break;

                case '[':
                    bCount++;
                    expectedCloser[closerIndex] = ']';
                    closerIndex++;
                    break;

                case '{':
                    cCount++;
                    expectedCloser[closerIndex] = '}';
                    closerIndex++;
                    break;

                case ')':
                    closerIndex--;
                    if (expectedCloser[closerIndex] != c) {
                        return false;
                    }
                    pCount--;
                    break;

                case ']':
                    closerIndex--;
                    if (expectedCloser[closerIndex] != c) {
                        return false;
                    }
                    bCount--;
                    break;

                case '}':
                    closerIndex--;
                    if (expectedCloser[closerIndex] != c) {
                        return false;
                    }
                    cCount--;
                    break;
            }


            if (pCount < 0 || bCount < 0 || cCount < 0) {
                return false;
            }
        }
        if (pCount != 0 || bCount != 0 || cCount != 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test1() {
//        Assert.assertFalse(isBalanced("{[(])}"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isBalanced("{{[[(())]]}}"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isBalanced("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."));
    }

}
