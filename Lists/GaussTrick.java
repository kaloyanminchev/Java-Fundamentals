package Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> line = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> newLine = new ArrayList<>();
        for (int i = 0; i < line.size() / 2; i++) {
            newLine.add(line.get(i) + line.get(line.size() - 1 - i));
        }

        if (line.size() % 2 != 0) {
            newLine.add(line.get(line.size() / 2));
        }

        for (Integer integer : newLine) {
            System.out.print(integer + " ");
        }
    }
}
