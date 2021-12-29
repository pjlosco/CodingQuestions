package math;

public class Calculator {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        if (isBalancedParentheses(s)) {
            char[] input = s.toCharArray();
            return innerCalculate(input);
        } else {
            throw new RuntimeException("Un balanced input");
        }
    }

    boolean isBalancedParentheses(String input) {
        return true;
    }

    private int innerCalculate(char[] input) {
        int returnValue = 0;
        char operation = '0';
        int firstValue = 0;
        int secondValue = 0;
        boolean onFirstValue = true;
        for (int index = 0; index < input.length; index++) {
            char value = input[index];
            switch(value) {
                case '(':
                    // recursive call
                case ')':
                    continue;
                case '+':
                case '-':
                    if (onFirstValue) {
                        onFirstValue = false;
                    } else {
                        returnValue = evaluate(firstValue,  secondValue,  operation);
                        onFirstValue = true;
                    }
                    operation = value;
                    continue;
                case '/':
                case 'x':
                    throw new RuntimeException("Operation not supported");
                default:
                    if (onFirstValue) {
                        firstValue = (firstValue * 10) + value;
                    } else {
                        secondValue = (secondValue * 10) + value;
                    }
            }
        }
        return 0;
    }

    private int evaluate(int firstValue,  int secondValue, char operation){
        return new Integer(firstValue + "" + operation + secondValue);
    }
}
