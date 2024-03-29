package math;

public class Fibonacci {

    /**
     * math.Fibonacci forumla is F(n) = F(n-1) + F(n-2)
     * ex: 0, 1, 1, 2, 3, 5, 8, 13, 21 ....
     */

    public static void main(String[] args) {
        System.out.println("Given a number and get the number in the fibonacci sequence");
        for (int i = 0; i<10; i++) {
            System.out.println("input " +i+ " results in:");
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n<=0){
            return 0;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }


    private static int fibonacci2(int n, int[] memory) {
        if (n == 1 || n == 0){
            return 1;
        } else if (memory[n] == 0) {
            memory[n] = fibonacci2(n-1, memory) + fibonacci2(n-2, memory);
        }
        return memory[n];
    }
}
