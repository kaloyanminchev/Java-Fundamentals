package Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrayOfStrings = input.split(" ");
        List<Double> numbers = new ArrayList<>();
        for (String strings : arrayOfStrings) {
            double number = Double.parseDouble(strings);
            numbers.add(number);
        }

        int i = 0;
        while (i < numbers.size() - 1) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = 0;
            } else {
                i++;
            }
        }
//        for (int i = 0; i < numbers.size() - 1; i++) {
//            if (numbers.get(i).equals(numbers.get(i + 1))) {
//                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
//                numbers.remove(i + 1);
//                i = - 1;
//            }
//        }

        List<String> numbersInStrings = new ArrayList<>();
        for (double number : numbers) {
            numbersInStrings.add(String.valueOf(new DecimalFormat("#.#").format(number)));
        }

        System.out.println(String.join(" ", numbersInStrings));


    }
}
