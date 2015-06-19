package main;

public class BalancedParentheses {

    public static void main(String[] args) {
        String sentence = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";

        if (isBalanced(sentence)) {
            System.out.println("Balanced!");
        } else {
            System.out.println("Unbalanced!");
        }
    }

    static boolean isBalanced(String sentence) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        if (count != 0) {
            return false;
        }
        return true;
    }
}
