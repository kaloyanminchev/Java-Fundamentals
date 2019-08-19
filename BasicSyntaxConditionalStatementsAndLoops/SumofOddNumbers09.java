package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class SumofOddNumbers09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sum += i;
            } else {
                n++;
            }

        }
        System.out.println(String.format("Sum: %d", sum));
    }
}
