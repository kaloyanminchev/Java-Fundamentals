package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbersDiffSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int bombNumber = tokens[0];
        int power = tokens[1];

        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i).equals(bombNumber)) {
                int start = i - power;
                if (start < 0) {
                    start = 0;
                }
                int finish = i + power + 1;
                if (finish > sequence.size()) {
                    finish = sequence.size();
                }

                for (int j = start; j < finish; j++) {
                    sequence.set(j, 0);
                }
            }
        }

        int sum = 0;
        for (Integer number : sequence) {
            sum += number;
        }
        System.out.println(sum);
    }
}
