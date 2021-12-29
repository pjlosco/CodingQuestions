package puzzle;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter something: ");
        String s = in.nextLine();
        System.out.println("You entered string "+s);
    }
}
