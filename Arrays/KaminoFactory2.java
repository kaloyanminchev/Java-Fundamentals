package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthSequence = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int sample = 0;
        int bestSum = 0;
        int bestIndex = Integer.MAX_VALUE;
        int bestSample = 0;
        String output = "";

        while (!"Clone them!".equals(input)) {
            int[] sequence = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            sample++;

            int maxCounter = 0;
            int sum = 0;
            int startingIndex = 0;
            for (int i = 0; i < sequence.length; i++) {
                sum += sequence[i];
                int counter = 0;
                for (int j = i; j < sequence.length; j++) {
                    if (sequence[i] == 1 && sequence[i] == sequence[j]) {
                        counter++;
                        if (counter > maxCounter) {
                            maxCounter = counter;
                            startingIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (startingIndex < bestIndex || sum > bestSum) {
                bestIndex = startingIndex;
                bestSum = sum;
                bestSample = sample;
                output = "";
                for (int i = 0; i < sequence.length; i++) {
                    output += sequence[i] + " ";
                }
            }


            input = scanner.nextLine();
        }
        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestSample, bestSum));
        System.out.println(String.join(" ", output));
    }
}
