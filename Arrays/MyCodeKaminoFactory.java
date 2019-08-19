package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MyCodeKaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthDNA = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int bestSequenceCount = 0;
        int bestSequenceSum = 0;
        int bestSequenceIndex = Integer.MAX_VALUE;
        int sample = 0;
        int sampleOutput = 0;
        int[] output = new int[lengthDNA];

        while (!"Clone them!".equals(input)) {
            int[] sequence = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sample++;
            int maxCount = 0;
            int mostLeftIndex = 0;
            for (int i = 0; i < sequence.length; i++) {
                int count = 0;
                for (int j = i; j < sequence.length; j++) {
                    if (sequence[i] == 1 && sequence[i] == sequence[j]) {
                        count++;
                        if (count > maxCount) {
                            maxCount = count;
                            mostLeftIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < sequence.length; i++) {
                sum += sequence[i];
            }

            if (mostLeftIndex < bestSequenceIndex || sum > bestSequenceSum) {
                bestSequenceIndex = mostLeftIndex;
                bestSequenceSum = sum;
                output = sequence;
                sampleOutput = sample;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.format("Best DNA sample %d with sum: %d.", sampleOutput, bestSequenceSum));
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
