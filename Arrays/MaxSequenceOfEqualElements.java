package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int counter = 1;
        int maxCounter = 0;
        int maxInteger = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                counter++;
                if (counter > maxCounter) {
                    maxCounter = counter;
                    maxInteger = numbers[i];
                }
            } else {
                counter = 1;
            }
        }
        for (int i = 1; i <= maxCounter; i++) {
            System.out.print(maxInteger + " ");
        }
    }
}
