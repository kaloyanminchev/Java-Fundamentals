package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Dec18SantaList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> kids = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Finished!")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            switch (type) {
                case "Bad":
                    if (!kids.contains(tokens[1])) {
                        kids.add(0, tokens[1]);
                    }
                    break;
                case "Good":
                    kids.remove(tokens[1]);
                    break;
                case "Rename":
                    String oldName = tokens[1];
                    String newName = tokens[2];
                    if (kids.contains(oldName)) {
                        int index = kids.indexOf(oldName);
                        kids.set(index, newName);
                    }
                    break;
                case "Rearrange":
                    String kidName = tokens[1];
                    if (kids.contains(kidName)) {
                        kids.remove(kidName);
                        kids.add(kidName);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", kids));
    }
}
