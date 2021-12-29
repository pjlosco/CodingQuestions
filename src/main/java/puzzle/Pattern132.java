package puzzle;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * i < j < k
 * nums[i] < nums[k] < nums[j].
 */
public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        try {
            for (int indexI = 0; indexI < nums.length; indexI++) {
                for (int indexJ = indexI +1; indexJ < nums.length; indexJ++) {
                    while (nums[indexI] == nums[indexJ] && indexJ-1 == indexI) {
                        indexI++;
                        indexJ++;
                    }
                    if (nums[indexI] < nums[indexJ]) {
                        for (int indexK = indexJ +1; indexK < nums.length; indexK++) {
                            while (nums[indexK] == nums[indexJ] && indexK-1 == indexJ) {
                                indexK++;
                                indexJ++;
                            }
                            if (nums[indexJ] > nums[indexK] && nums[indexK] > nums[indexI]) {
                                return true;
                            }
                        }
                    }
                }

            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    @Test
    public void unitTest1() {
//        assertTrue(find132pattern(new int[] {3,5,0,3,4}));
    }

    @Test
    public void unitTest2() {
        assertTrue(find132pattern(new int[] {-2,1,2,-2,1,2}));
    }
}
