import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class BestStockProfit {


    public static int bestPrice(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int lowestPrice = prices[0];

        for(int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            }
            if (maxProfit < price - lowestPrice) {
                maxProfit = price -lowestPrice;
            }
        }
        return maxProfit;
    }

    @Test
    public void lowToHigh() {
        int[] prices = new int[] {1,2,3,4,5,4,3,5,6,7};
        Assert.assertEquals("Low to high: ", bestPrice(prices), 6);
    }


    @Test
    public void highToLow() {
        int[] prices = new int[] {7,5,3,2,1};
        Assert.assertEquals("High to Low: ", bestPrice(prices), 0);
    }


    @Test
    public void empty() {
        int[] prices = new int[] {};
        Assert.assertEquals("Empty: ", bestPrice(prices), 0);
    }


    @Test
    public void variation() {
        int[] prices = new int[] {7,4,3,1,2,3,4,5,4,3,5,6,7,5,3,2,1,10};
        Assert.assertEquals("Variation: ", bestPrice(prices), 9);
    }

}
