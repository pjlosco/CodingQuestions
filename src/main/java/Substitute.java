import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Substitute {

    HashMap<Character, Integer> valueMap = new HashMap<Character,Integer>();

    public int getValue(String key, String code) {
        if (key.length() != 10) {
            return 0;
        }

        if (!valueMap.isEmpty()) {
            valueMap = new HashMap<Character,Integer>();
        }
        int position = 1;
        for (char c : key.toCharArray()) {
            if (position != 10) {
                valueMap.put(c,position);
                position++;
            } else {
                valueMap.put(c,0);
            }
        }
        int returnValue = 0;
        for (char c : code.toCharArray()) {
            if (valueMap.containsKey(c)) {
                returnValue = returnValue*10 + valueMap.get(c);
            }
        }
        return returnValue;
    }


    @Test
    public void regressionTest() {
        Assert.assertEquals(0, getValue("ABCDEFGHIJ", "XJ"));
        Assert.assertEquals(6, getValue("CRYSTALBUM", "MMA"));
        Assert.assertEquals(709, getValue("TRADINGFEW", "LGXWEV"));
    }

}