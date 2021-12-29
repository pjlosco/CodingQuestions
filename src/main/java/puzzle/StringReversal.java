package puzzle;

public class StringReversal {

    public static void main(String[] args) {
        String toBeReversed = "A man a plan a canal, Panama!";

        System.out.println(collectionStyle(toBeReversed));
        System.out.println(oldFashioned(toBeReversed));
        System.out.println(charSwap(toBeReversed));
        System.out.println(recursive(toBeReversed));
    }

    static String collectionStyle(String toBeReversed) {
        return new StringBuilder(toBeReversed).reverse().toString();
    }

    static String oldFashioned(String toBeReversed) {
        StringBuilder builder  = new StringBuilder();
        char[] toBe = toBeReversed.toCharArray();
        int pos = 0;
        while (builder.toString().length() < toBeReversed.length()) {
            builder.insert(0, toBe[pos]);
            pos++;
        }
        return builder.toString();
    }

    static String charSwap(String toBeReversed) {
        int stringLength = toBeReversed.length();
        char[] reversed = toBeReversed.toCharArray();
        for (int index = 0; index < stringLength; index++) {
            int endPosition = stringLength-index-1;
            char swapChar = reversed[index];
            reversed[index] = reversed[endPosition];
            reversed[endPosition] = swapChar;
            if (index >= endPosition) {
                break;
            }
        }
        return String.copyValueOf(reversed);
    }

    static String recursive(String toBeReversed) {
        if (toBeReversed.length() == 1) {
            return toBeReversed;
        }
        return toBeReversed.substring(toBeReversed.length()-1) + recursive(toBeReversed.substring(0, toBeReversed.length()-1));
    }

}
