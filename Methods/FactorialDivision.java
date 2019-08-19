package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());

        double result = getFactorial(first) / getFactorial(second);
        System.out.printf("%.2f", result);
    }

    static double getFactorial(double number) {
        double factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
