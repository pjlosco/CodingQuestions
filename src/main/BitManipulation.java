package main;

import org.junit.Test;

/**
 * Created by Patrick on 6/21/2015.
 */
public class BitManipulation {

    public int countBitsInChar(char c) {
        int x = (int) c;
        System.out.println(c+" = " + x);
        x = (x & 0x55) + (x >> 1) & 0x55;
        x = (x & 0x33) + (x >> 2) & 0x33;
        x = (x & 0x0F) + (x >> 4) & 0x0F;
        return x;
    }

    @Test
    public void simpleTest() {
        countBitsInChar('a');
        countBitsInChar('b');
    }
}
