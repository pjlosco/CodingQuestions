import org.junit.Assert;
import org.junit.Test;

public class GCDTest {
    GCD gcd = new GCD();

    @Test
    public void inputTest() {
        Assert.assertEquals(gcd.generalizedGCD(5, new int[]{2, 3, 4, 5, 6}), 1);
    }

    /**
     * The largest positive integer that divides all the positive integers 2, 4, 6, 8, 10 without a remainder is 2.
     */
    @Test
    public void input2Test() {
        Assert.assertEquals(gcd.generalizedGCD(5, new int[]{2, 4, 6, 8, 10}), 2);
    }

    @Test
    public void input3Test() {
        Assert.assertEquals(gcd.generalizedGCD(5, new int[]{5, 10, 15, 20, 25}), 5);
    }

    @Test
    public void input4Test() {
        Assert.assertEquals(gcd.generalizedGCD(5, new int[]{10, 10, 10, 20, 20}), 10);
    }
}
