package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class MultiplicationTable11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = times; i <= 10; i++) {
            System.out.printf("%d X %d = %d", number, i, number * i).println();
        }
        if (times > 10) {
            System.out.printf("%d X %d = %d", number, times, number * times);
        }
    }
}
