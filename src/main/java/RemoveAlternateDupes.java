import java.util.HashMap;
import java.util.Map;

/**
 * Remove Alternate Duplicate characters from a char array you have to do it in Place.
 * Like keeping only the odd occurences of each character.
 */
public class RemoveAlternateDupes {

    public String activate(String input) {
        Map<Character, Integer> bookie = new HashMap<>();
        int inputLength = input.length();
        int index = 0;
        while (index < inputLength) {
            char character = input.charAt(index);
            if (bookie.containsKey(character)) {
                int occurrences = bookie.get(character) + 1;
                if (occurrences % 2 == 0) {
                    if (index == inputLength) {
                        input = input.substring(0, index);
                    } else {
                        input = input.substring(0, index) + input.substring(index + 1, inputLength);
                    }
                    inputLength--;
                } else {
                    index++;
                }
                bookie.put(character, occurrences);
            } else {
                bookie.put(character, 1);
                index++;
            }
        }
        return input;
    }
}
