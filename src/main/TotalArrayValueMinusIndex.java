package main;

/**
 * Write a function get_products_of_all_ints_except_at_index()
 * that takes an array of integers and returns an array of the products.
 * given:
 *  [1, 7, 3, 4]
 * result:
 *  [84, 12, 28, 21]
 * by calculating:
 *  [7*3*4, 1*3*4, 1*7*4, 1*7*3]
 */
public class TotalArrayValueMinusIndex {

    public int[] productsOfAllIntsExceptIndex(int[] values) {
        int[] resultArray = new int[values.length];
        long total = 1;
        for (int value : values) {
            total = total*value;
        }
        for (int index = 0;index < resultArray.length; index++)  {
            resultArray[index] = (int) total/values[index];
        }
        return resultArray;
    }

}
