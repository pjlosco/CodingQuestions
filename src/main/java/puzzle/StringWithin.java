package puzzle;

public class StringWithin {
    // The task is to write a function that takes two strings and figures out
// if you can delete 0 or more characters from first string in any location
// and make the two strings identical.

// f("abc", "abc") -> True
// f("abc", "") -> True
// f("ab", "ba") -> False
// f("abcdef", "adf") -> True // delete 'b', 'c', 'e'

// f("aba", "ba") -> True

// f("abcdefa", "adf") -> True // delete 'b', 'c', 'e', then remove first a

// f("abcadefa", "adf") -> True // delete 'b', 'c', 'e', then remove first a and inner a
// f("adadfa", "adf") -> True // delete 'b', 'c', 'e', then remove first a and inner a
// f("adadfa", "adf") -> True // delete 'b', 'c', 'e', then remove first a and inner a

// if the strings are the same size, both need the same characters in the same order, -> string1 contains string2
// string2 would always need less characters than string1

    boolean stringWithin(String first, String second) {

        if (first.equals(second) || second.isEmpty() || first.contains(second)) {
            return true;
        }

        // scenario first string has more characters than in second, always remove from first and try to match
        char[] firstAsArray = first.toCharArray();
        int index = 0;
        while (index < firstAsArray.length) {
            if (!second.contains(""+firstAsArray[index])){

                first = first.replaceAll(""+firstAsArray[index], "");

                if (first.equals(second)) {
                    return true;
                }
                if (second.length() > first.length()) {
                    return false;
                }
            }

            index++;
        }


        int index2 = 0;
        firstAsArray = first.toCharArray();
        char[] secondAsArray = second.toCharArray();
        char[] modifiedFirst = new char[second.length()];
        for (int index1 = 0; index1 < first.length(); index1++) {
            char a = firstAsArray[index1];
            char b = secondAsArray[index2];
            if (a == b) {
                modifiedFirst[index2] = a;
                if (second.equals(new String(modifiedFirst))) {
                    return true;
                }
                index1++;
                index2++;
            } else {
                index1++;
            }
        }


        return false;
    }
}
