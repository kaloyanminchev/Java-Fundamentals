package Methods;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        System.out.println(getSubtract(one, two, three));
    }

    static int getSum(int one, int two) {
        return one + two;
    }

    static int getSubtract(int one, int two, int three) {
        return getSum(one, two) - three;
    }
}
