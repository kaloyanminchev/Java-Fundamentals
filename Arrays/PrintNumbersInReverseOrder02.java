package Arrays;

import java.util.Scanner;

public class PrintNumbersInReverseOrder02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            numbers[i] = currentNumber;
        }
        for (int j = numbers.length - 1; j >= 0; j--) {
            System.out.print(numbers[j] + " ");
        }
    }
}
