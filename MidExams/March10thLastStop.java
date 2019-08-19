package MidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class March10thLastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Change":
                    int paintingNumber = Integer.parseInt(tokens[1]);
                    int changedNumber = Integer.parseInt(tokens[2]);
                    if (numbers.contains(paintingNumber)) {
                        int index = numbers.indexOf(paintingNumber);
                        numbers.set(index, changedNumber);
                    }
                    break;
                case "Hide":
                    numbers.remove(Integer.valueOf(tokens[1]));
                    break;
                case "Switch":
                    int first = Integer.parseInt(tokens[1]);
                    int second = Integer.parseInt(tokens[2]);
                    if (numbers.contains(first) && numbers.contains(second)) {
                        int indexFirst = numbers.indexOf(first);
                        int indexSecond = numbers.indexOf(second);
                        numbers.set(indexFirst, second);
                        numbers.set(indexSecond, first);
                    }
                    break;
                case "Insert":
                    int place = Integer.parseInt(tokens[1]);
                    int number = Integer.parseInt(tokens[2]);
                    if (place >= 0 && place < numbers.size()) {
                        numbers.add(place + 1, number);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(numbers);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
