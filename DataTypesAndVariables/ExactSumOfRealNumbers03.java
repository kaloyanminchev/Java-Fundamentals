package DataTypesAndVariables;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNumbers = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 1; i <= countNumbers; i++) {
            BigDecimal currentNumber = new BigDecimal(scanner.nextLine());
            sum = sum.add(currentNumber);
        }
        System.out.println(sum);
    }
}
