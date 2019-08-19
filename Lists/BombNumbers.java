package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = (Arrays.stream(scanner.nextLine().split("\\s+")))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] tokens = (Arrays.stream(scanner.nextLine().split("\\s+")))
                .mapToInt(Integer::parseInt).toArray();

        int bombNumber = tokens[0];
        int power = tokens[1];

        while (sequence.contains(bombNumber)) {
            int elementIndex = sequence.indexOf(bombNumber);

            int left = Math.max(0, elementIndex - power);
            int right = Math.min(elementIndex + power, sequence.size() - 1);

            for (int i = right; i >= left; i--) {
                sequence.remove(i);
//                sequence.set(i, 0);
            }
        }
        int sum = 0;
        for (Integer number : sequence) {
            sum += number;
        }
        System.out.println(sum);

//        System.out.println(line.stream().mapToInt(e -> e).sum());
    }
}
