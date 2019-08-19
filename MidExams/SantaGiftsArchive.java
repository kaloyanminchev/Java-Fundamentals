package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaGiftsArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int currentIndex = 0;
        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Forward":
                    int numberOfSteps = Integer.parseInt(tokens[1]);
                    if (currentIndex + numberOfSteps >= 0 && currentIndex + numberOfSteps < numbers.size()) {
                        currentIndex += numberOfSteps;
                        numbers.remove(currentIndex);
                    }
                    break;
                case "Back":
                    int steps = Integer.parseInt(tokens[1]);
                    if (currentIndex - steps >= 0 && currentIndex - steps < numbers.size()) {
                        currentIndex -= steps;
                        numbers.remove(currentIndex);
                    }
                    break;
                case "Gift":
                    int index = Integer.parseInt(tokens[1]);
                    int houseNumber = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, houseNumber);
                        currentIndex = index;
                    }
                    break;
                case "Swap":
                    int first = Integer.parseInt(tokens[1]);
                    int second = Integer.parseInt(tokens[2]);
                    if (numbers.contains(first) && numbers.contains(second)) {
                        int indexFirst = numbers.indexOf(first);
                        int indexSecond = numbers.indexOf(second);
                        numbers.set(indexFirst, second);
                        numbers.set(indexSecond, first);
                    }
                    break;
            }
        }

        System.out.println("Position: " + currentIndex);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
