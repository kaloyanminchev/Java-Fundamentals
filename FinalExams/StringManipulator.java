package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = "";

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String string = tokens[1];
                    result += string;
                    break;
                case "Upgrade":
                    char symbol = tokens[1].charAt(0);
                    if (result.contains("" + symbol)) {
                        result = result.replaceAll("" +symbol, "" + (char) (symbol + 1));
                    }
                    break;
                case "Print":
                    System.out.println(result);
                    break;
                case "Index":
                    char c = tokens[1].charAt(0);
                    List<Integer> indexes = new ArrayList<>();
                    for (int i = 0; i < result.length(); i++) {
                        if (result.charAt(i) == c) {
                            indexes.add(i);
                        }
                    }
                    if (indexes.isEmpty()) {
                        System.out.println("None");
                    } else {
                        for (Integer index : indexes) {
                            System.out.print(index + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Remove":
                    String s = tokens[1];
                    result = result.replaceAll(s, "");
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
