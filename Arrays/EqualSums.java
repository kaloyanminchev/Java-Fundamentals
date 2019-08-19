package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (numbers.length == 1) {
            System.out.println(0);
        } else {
            boolean isEqual = false;
            int index = 0;
            for (int i = 0; i < numbers.length; i++) {
                int sumLeft = 0, sumRight = 0;
                for (int j = 0; j < i; j++) {
                    sumLeft += numbers[j];
                }
                for (int j = numbers.length - 1; j > i; j--) {
                    sumRight += numbers[j];
                }
                if (sumLeft == sumRight) {
                    isEqual = true;
                    index = i;
                }
            }
            if (isEqual) {
                System.out.println(index);
            } else {
                System.out.println("no");
            }
        }
    }
}
