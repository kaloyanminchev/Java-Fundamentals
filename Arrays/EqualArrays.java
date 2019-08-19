package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] second = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] == second[i]) {
                sum += first[i];
            } else {
                System.out.println(String.format("Arrays are not identical. Found difference at %d index.", i));
                return;
            }
        }
        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
