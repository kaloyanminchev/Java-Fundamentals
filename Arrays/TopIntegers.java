package Arrays;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] inputArrayIntegers = new int[inputArray.length];
        for (int i = 0; i < inputArrayIntegers.length; i++) {
            inputArrayIntegers[i] = Integer.parseInt(inputArray[i]);
        }
        for (int i = 0; i < inputArrayIntegers.length; i++) {
            boolean isGreater = true;
            for (int j = i; j < inputArrayIntegers.length - 1; j++) {
                if (inputArrayIntegers[i] <= inputArrayIntegers[j + 1]) {
                    isGreater = false;
                    break;
                }
            }
            if (isGreater) {
                System.out.print(inputArrayIntegers[i] + " ");
            }
        }
    }
}
