package MidExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DemoMarchCookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int highestQuality = Integer.MIN_VALUE;
        double greaterAverageQuality = 0;
        List<Integer> bestBatch = new ArrayList<>();

        while (!"Bake It!".equals(input)) {
            List<Integer> currentBatch = Arrays.stream(input.split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int qualityCurrentBatch = currentBatch.stream().mapToInt(e -> e).sum();
            double averageQualityCurrentBatch = qualityCurrentBatch * 1.0 / currentBatch.size();

            if (qualityCurrentBatch > highestQuality) {
                highestQuality = qualityCurrentBatch;
                bestBatch = currentBatch;
                greaterAverageQuality = averageQualityCurrentBatch;
            } else if (qualityCurrentBatch == highestQuality) {
                if (averageQualityCurrentBatch > greaterAverageQuality) {
                    bestBatch = currentBatch;
                    greaterAverageQuality = averageQualityCurrentBatch;
                } else if (averageQualityCurrentBatch == greaterAverageQuality) {
                    if (currentBatch.size() < bestBatch.size()) {
                        bestBatch = currentBatch;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best Batch quality: %d%n", highestQuality);
        System.out.println(bestBatch.toString().replaceAll("[\\[\\],]", ""));
    }
}

