package main;

import junit.framework.Assert;
import org.junit.Test;

/**
 Design an algorithm and test cases for the following problem. Take a string and find if it contains a pallindrome.
 */
public class Pallindrome {

    boolean containsPallindrome(String phrase) {
        if (phrase == null || phrase.isEmpty()){
            return false;
        }
        String[] words = phrase.split(" ");
        for(String word : words) {
            if (isPallindrome(word)) {
                return true;
            }
        }
        return false;
    }

    boolean isPallindrome(String phrase) {
        if (phrase == null || phrase.isEmpty()){
            return false;
        }
        else {
            int startIndex = 0;
            int endIndex = phrase.length()-1;
            char[] phraseArray = phrase.toCharArray();
            for (int count = 0; count < phrase.length()/2 + 1; count++) {
                if (startIndex == endIndex) {
                    return true;
                }
                if (phraseArray[startIndex] != phraseArray[endIndex]) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
        }
        return true;
    }


    @Test
    public void NullCheck() {
        Assert.assertFalse(containsPallindrome(null));
    }

    @Test
    public void Empty() {
        Assert.assertFalse(containsPallindrome(""));
    }

    @Test
    public void SimplePhrase() {
        Assert.assertFalse(containsPallindrome("phrase"));
    }

    @Test
    public void SimplePhrase2() {
        Assert.assertTrue(containsPallindrome("a"));
    }

    @Test
    public void SimplePhrase3() {
        Assert.assertTrue(containsPallindrome("aba"));
    }

    @Test
    public void SimplePhrase4() {
        Assert.assertTrue(containsPallindrome("abba"));
    }

    @Test
    public void SimplePhrase5() {
        Assert.assertFalse(containsPallindrome("aabb"));
    }

    @Test
    public void Phrase() {
        Assert.assertTrue(containsPallindrome("I'm going out with hannah"));
    }

    @Test
    public void Phrase2() {
        Assert.assertTrue(containsPallindrome("Contains a pallindrome?"));
    }

    @Test
    public void Phrase3() {
        Assert.assertFalse(containsPallindrome("foo oof"));
    }

    @Test
    public void LongPhrase() {
        Assert.assertFalse(containsPallindrome("hu uysd popcxiuh wpeiuh zl;uxhp wh syiuzgc oyag jhdbasdyu owyeg oayg xkjhzcbyweg couyiebw cyoz uhcb auyb ouwhbec kzuyxcg kuhbwe kuyaszk hcb xcefwfoo oof"));
    }
}
