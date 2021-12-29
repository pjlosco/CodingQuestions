package math;

/**
 * Created by patrick on 4/28/14.
 */
public class PrimeChecker {

    /**
     * Prime numbers are only divisible by 1 and itself
     */

    public static void main(String[] args) {
        System.out.println("A list of prime numbers between 1 and 50 is:");
        for(int i = 1; i<=50; i++){
            if (primeCheck(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean primeCheck(int n) {
        for(int i = 2; i<(n/2+1); i++) {
            int remainder = n % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }

}
