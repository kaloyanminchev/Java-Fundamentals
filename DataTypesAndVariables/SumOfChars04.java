package DataTypesAndVariables;

import java.util.Scanner;

public class SumOfChars04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += scanner.nextLine().charAt(3);
        }
        System.out.println(String.format("The sum equals: %d", sum));

    }
}
