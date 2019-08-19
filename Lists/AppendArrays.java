package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> output = new ArrayList<>();

        String[] array = scanner.nextLine().split("\\|+");

        for (int i = array.length - 1; i >= 0; i--) {
            String[] current = array[i].split("\\s+");
            for (int j = 0; j < current.length; j++) {
                if (!current[j].equals("")) {
                    output.add(current[j]);
                }
            }
        }
        for (String number : output) {
            System.out.print(number + " ");
        }
//        System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
    }
}
