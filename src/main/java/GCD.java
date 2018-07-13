import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GCD {

    /**
     * The greatest common divisor (GCD), also called highest common factor (HCF) of N numbers is the
     * largest positive integer that divides all numbers without giving a remainder.
     *
     * @param num an integer representing the number of positive integers (N).
     * @param arr a list of positive integers.
     * @return an integer representing the GCD of the given positive integers.
     */
    public int generalizedGCD(int num, int[] arr)
    {
        if (num != arr.length) {
            return 0;
        } else {
            // make an array list so its easier to use
            Set<Integer> shortList = convertToSet(arr);
            int gcd = 1;
            for (Integer possibleDenominator : shortList) {
                boolean foundGCD = false;
                for (Integer value : shortList) {
                    if (value == possibleDenominator) {
                        continue;
                    } else if (value % possibleDenominator != 0) {
                        foundGCD = false;
                        break;
                    } else {
                        foundGCD = true;
                    }
                }
                if (foundGCD) {
                    gcd = (int)possibleDenominator;
                }
                shortList.add(possibleDenominator);
            }
            return gcd;
        }
    }

    public Set<Integer> convertToSet(int[] values) {
        Set<Integer> newList = new HashSet<>();
        for (int value : values) {
            newList.add(value);
        }
        return newList;
    }

}
