package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Switch":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.set(index, -numbers.get(index));
                    }
                    break;
                case "Change":
                    int place = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);
                    if (place >= 0 && place < numbers.size()) {
                        numbers.set(place, value);
                    }
                    break;
                case "Sum":
                    String type = tokens[1];
                    if ("Negative".equals(type)) {
                        System.out.println(numbers.stream().filter(e -> e < 0).mapToInt(e -> e).sum());
                    } else if ("Positive".equals(type)) {
                        System.out.println(numbers.stream().filter(e -> e > 0).mapToInt(e -> e).sum());
                    } else if ("All".equals(type)) {
                        System.out.println(numbers.stream().mapToInt(e -> e).sum());
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            if (number >= 0) {
                System.out.print(number + " ");
            }
        }
    }
}
