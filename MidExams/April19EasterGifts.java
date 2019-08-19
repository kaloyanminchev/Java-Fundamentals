package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class April19EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> line = Arrays.stream(scanner.nextLine().split("\\s")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!"No Money".equals(command)) {
            String[] tokens = command.split("\\s");
            String type = tokens[0];
            String gift = tokens[1];
            switch (type) {
                case "OutOfStock":
                    while (line.contains(gift)) {
                        int index = line.indexOf(gift);
                        line.set(index, "None");
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < line.size()) {
                        line.set(index, gift);
                    }
                    break;
                case "JustInCase":
                    line.set(line.size() - 1, gift);
                    break;
            }
            command = scanner.nextLine();
        }
        for (String gift : line) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }
    }
}
