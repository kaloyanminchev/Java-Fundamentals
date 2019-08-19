package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String[] arr = scanner.nextLine().split("\\s+");
//        List<Integer> numbers = new ArrayList<>();
//        for (String elements : arr) {
//            numbers.add(Integer.parseInt(elements));
//        }

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] token = command.split("\\s+");
            String type = token[0];
            switch (type) {
                case "Add":
                    numbers.add(Integer.parseInt(token[1]));
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(Integer.parseInt(token[1])));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(token[1]));
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(token[1]);
                    int index = Integer.parseInt(token[2]);
                    numbers.add(index, numberToInsert);
                    break;
            }
            command = scanner.nextLine();
        }
//        for (Integer number : numbers) {
//            System.out.print(number + " ");
//        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
