package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        while (!sequence.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < sequence.size()) {
                int value = sequence.get(index);
                calculateValues(sequence, index, value);
                sum += sequence.get(index);
                sequence.remove(index);
            } else if (index < 0) {
                int indexToTake = 0;
                int valueToTake = sequence.get(indexToTake);
                calculateValues(sequence, indexToTake, valueToTake);
                sum += sequence.get(0);
                sequence.remove(indexToTake);
                sequence.add(indexToTake, sequence.get(sequence.size() - 1));
            } else if (index > sequence.size() - 1) {
                int indexToTake = sequence.size() - 1;
                int valueToTake = sequence.get(indexToTake);
                calculateValues(sequence, indexToTake, valueToTake);
                sum += sequence.get(indexToTake);
                sequence.remove(indexToTake);
                sequence.add(indexToTake, sequence.get(0));
            }
        }
        System.out.println(sum);
    }

    private static void calculateValues(List<Integer> sequence, int index, int value) {
        for (int i = 0; i < sequence.size(); i++) {
            if (i != index) {
                if (sequence.get(i) <= value) {
                    sequence.set(i, sequence.get(i) + value);
                } else {
                    sequence.set(i, sequence.get(i) - value);
                }
            }
        }
    }
}
