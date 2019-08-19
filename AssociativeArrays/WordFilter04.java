package AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
