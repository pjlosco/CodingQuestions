import org.junit.Test;
import org.junit.Assert;

/**
 Design an algorithm and test cases for the following problem. Take a string and find if it contains a pallindrome.
 */
public class Palindrome {

    boolean containsPalindrome(String phrase) {
        if (phrase == null || phrase.isEmpty()){
            return false;
        }
        String[] words = phrase.split(" ");
        for(String word : words) {
            if (isPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

    boolean isPalindrome(String phrase) {
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
        Assert.assertFalse(containsPalindrome(null));
    }

    @Test
    public void Empty() {
        Assert.assertFalse(containsPalindrome(""));
    }

    @Test
    public void SimplePhrase() {
        Assert.assertFalse(containsPalindrome("phrase"));
    }

    @Test
    public void SimplePhrase2() {
        Assert.assertTrue(containsPalindrome("a"));
    }

    @Test
    public void SimplePhrase3() {
        Assert.assertTrue(containsPalindrome("aba"));
    }

    @Test
    public void SimplePhrase4() {
        Assert.assertTrue(containsPalindrome("abba"));
    }

    @Test
    public void SimplePhrase5() {
        Assert.assertFalse(containsPalindrome("aabb"));
    }

    @Test
    public void Phrase() {
        Assert.assertFalse(containsPalindrome("I'm going to the mall"));
    }

    @Test
    public void Phrase2() {
        Assert.assertTrue(containsPalindrome("Contains a palindrome?"));
    }

    @Test
    public void Phrase3() {
        Assert.assertFalse(containsPalindrome("foo oof"));
    }

    @Test
    public void LongPhrase() {
        Assert.assertFalse(containsPalindrome("hu uysd popcxiuh wpeiuh zl;uxhp wh syiuzgc oyag jhdbasdyu owyeg oayg xkjhzcbyweg couyiebw cyoz uhcb auyb ouwhbec kzuyxcg kuhbwe kuyaszk hcb xcefwfoo oof"));
    }

    @Test
    public void FamousPhrase() {
        Assert.assertTrue(containsPalindrome("a man a plan a canal panama"));
    }
}
