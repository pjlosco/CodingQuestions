public class ContainsSubstring {

    public static void main(String[] args) {
        String string1 = "This is the entered string. There might be a substring in it";
        String string2 = "string";

        if (isContainedInString(string1, string2)) {
            System.out.println("It was found! \'" + string2 + "\' IS contained in \"" + string1 + "\"");
        } else {
            System.out.println("\'" + string2 + "\' is NOT contained in \"" + string1 + "\"");
        }
    }

    static boolean isContainedInString(String string1, String string2) {
        if (string1.length() < 1 || string2.length() < 1 || string2.length() > string1.length()) {
            return false;
        }
        if (string1.charAt(0) == string2.charAt(0)) {
            return string2.length() - 1 == 0 || isContainedInString(string1.substring(1), string2.substring(1));
        } else {
            return isContainedInString(string1.substring(1), string2);
        }
    }
}
