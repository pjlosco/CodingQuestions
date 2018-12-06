import org.junit.Assert;
import org.junit.Test;

public class StringReversalTest {
    String toBeReversed = "A man a plan a canal, Panama!";
    String reversedString = "!amanaP ,lanac a nalp a nam A";

    @Test
    public void charSwap() {
        Assert.assertEquals(reversedString, StringReversal.charSwap(toBeReversed));
    }

    @Test
    public void collectionStyle() {
        Assert.assertEquals(reversedString, StringReversal.collectionStyle(toBeReversed));
    }
    @Test
    public void oldFashioned() {
        Assert.assertEquals(reversedString, StringReversal.oldFashioned(toBeReversed));
    }
    @Test
    public void recursive() {
        Assert.assertEquals(reversedString, StringReversal.recursive(toBeReversed));
    }
}
