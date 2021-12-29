package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 */
public class KDiff {

    public int findPairs(int[] nums, int k) {
        Set<AbstractMap> pairs = new HashSet<>();
        Arrays.sort(nums);
        for (int indexI = nums.length; indexI > 1; indexI--) {
            for (int indexJ = indexI-1; indexJ > 0; indexJ--) {
                int first  = nums[indexI-1];
                int second = nums[indexJ-1];
                if (first - second == k) {
                    pairs.add(new HashMap(first, second));
                } else if (first - second > k) {
                    break;
                }
            }
        }
        return pairs.size();
    }


    @Test
    public void unitTest1() {
        int actualResult = findPairs(new int[]{3,1,4,1,5}, 2);
        Assert.assertEquals(2, actualResult);
    }

    @Test
    public void unitTest2() {
        int actualResult = findPairs(new int[]{1,2,3,4,5}, 1);
        Assert.assertEquals(4, actualResult);
    }

    @Test
    public void unitTest3() {
        int actualResult = findPairs(new int[]{1,3,1,5,4}, 0);
        Assert.assertEquals(1, actualResult);
    }
}
