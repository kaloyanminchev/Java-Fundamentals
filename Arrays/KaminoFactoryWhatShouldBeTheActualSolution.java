package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactoryWhatShouldBeTheActualSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfSequence = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int currentSample = 0;
        int bestSample = 0;

        int bestSequenceCounter = 0;
        int bestSequenceStartingIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        String output = "";

        while (!"Clone them!".equals(input)) {
            int[] sequence = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();

            currentSample++;
            int currentSequenceSum = 0;
            int maxCounter = 0;
            int bestStartingIndexCurrentSequence = 0;

            for (int i = 0; i < sequence.length; i++) {
                currentSequenceSum += sequence[i];
                int counter = 0;
                for (int j = i; j < sequence.length; j++) {
                    if (sequence[i] == 1 && sequence[i] == sequence[j]) {
                        counter++;
                        if (counter > maxCounter) {
                            maxCounter = counter;
                            bestStartingIndexCurrentSequence = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (maxCounter > bestSequenceCounter) {
                bestSequenceCounter = maxCounter;
                bestSample = currentSample;
                bestSequenceStartingIndex = bestStartingIndexCurrentSequence;
                bestSequenceSum = currentSequenceSum;
                output = "";
                for (int i = 0; i < sequence.length; i++) {
                    output += sequence[i] + " ";
                }
            } else if (maxCounter == bestSequenceCounter) {
                if (bestStartingIndexCurrentSequence < bestSequenceStartingIndex) {
                    bestSample = currentSample;
                    bestSequenceStartingIndex = bestStartingIndexCurrentSequence;
                    bestSequenceSum = currentSequenceSum;
                    output = "";
                    for (int i = 0; i < sequence.length; i++) {
                        output += sequence[i] + " ";
                    }
                } else if (bestStartingIndexCurrentSequence == bestSequenceStartingIndex) {
                    if (currentSequenceSum > bestSequenceSum) {
                        bestSample = currentSample;
                        bestSequenceStartingIndex = bestStartingIndexCurrentSequence;
                        bestSequenceSum = currentSequenceSum;
                        output = "";
                        for (int i = 0; i < sequence.length; i++) {
                            output += sequence[i] + " ";
                        }
                    }
                }

            }
            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSample, bestSequenceSum);
        System.out.println(String.join(" ", output));
    }
}
