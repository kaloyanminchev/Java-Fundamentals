package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n % numbers.length; i++) {
            String temp = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = temp;
        }
        System.out.println(String.join(" ", numbers));
        //for (int i = 0; i < numbers.length; i++) {
        //    System.out.print(numbers[i] + " ");
        //}
    }
}
