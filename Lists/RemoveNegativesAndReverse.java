package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
            } else {
                i++;
            }
        }
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) < 0) {
//                numbers.remove(i);
//                i--;
//            }
//        }

        if (numbers.size() == 0) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
