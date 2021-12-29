package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class EqualArrays {

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Analyze array
        if (array_a.length == array_b.length) {
            // make the array B match array A
            for (int indexA = 0; indexA < array_a.length; indexA++) {
                int valA = array_a[indexA];

                // check in arrayB for the value
                for(int indexB = indexA; indexB < array_b.length; indexB++) {
                    int valB = array_b[indexB];
                    if (valB == valA) {
                        // this space is equal, can continue on
                        // first sort!
                        if (indexA != indexB) {
                            // move forward bad value
                            array_b[indexB] = array_b[indexA];
                            // swap in good value
                            array_b[indexA] = valB;
                        }
                        break;
                    } else {
                        // check for at the end, return false if no more values
                        if (indexB == array_b.length - 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        // not equal so just return
        return false;
    }

    @Test
    public void test1() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        Assert.assertTrue(areTheyEqual(array_a_1, array_b_1));
    }

    @Test
    public void test2() {
        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        Assert.assertFalse(areTheyEqual(array_a_2, array_b_2));
    }
}
