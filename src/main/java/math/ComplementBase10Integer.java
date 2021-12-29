package math;

import org.junit.Assert;
import org.junit.Test;

public class ComplementBase10Integer {

    /**
     * Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.
     *
     * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
     *
     * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
     * @param N
     * @return
     */
    public int bitwiseComplement(int N) {
        String binary = Integer.toBinaryString(N);
        char[] binaryArray = binary.toCharArray();
        StringBuilder inverseBinary = new StringBuilder();
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == '1') {
                inverseBinary.append("0");
            } else {
                inverseBinary.append("1");
            }
        }

        // convert binary to integer
        return Integer.parseInt(inverseBinary.toString(), 2);
    }


    @Test
    public void unitTest1() {
        int actualResult = bitwiseComplement(5);
        Assert.assertEquals(2, actualResult);
    }

    @Test
    public void unitTest2() {
        int actualResult = bitwiseComplement(7);
        Assert.assertEquals(0, actualResult);
    }

    @Test
    public void unitTest3() {
        int actualResult = bitwiseComplement(10);
        Assert.assertEquals(5, actualResult);
    }
}
