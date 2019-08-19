package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int element = Integer.parseInt(tokens[1]);
            switch (command) {
                case "Delete":
//                    numbers.removeAll(Collections.singleton(element));
//                    while (numbers.contains(element)) {
////                        numbers.remove(Integer.valueOf(element));
////                    }
                    while (numbers.remove(Integer.valueOf(element))) {
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, element);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
