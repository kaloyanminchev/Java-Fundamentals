package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NascarQualificationsArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String racer = tokens[1];

            switch (command) {
                case "Race":
                    if (!names.contains(racer)) {
                        names.add(racer);
                    }
                    break;
                case "Accident":
                    names.remove(racer);
                    break;
                case "Box":
                    if (names.contains(racer)) {
                        int index = names.indexOf(racer);
                        int indexToMove = names.indexOf(racer) + 1;
                        if (index < names.size() - 1) {
                            names.remove(racer);
                            names.add(indexToMove, racer);
                        }
                    }
                    break;
                case "Overtake":
                    int countPositions = Integer.parseInt(tokens[2]);
                    if (names.contains(racer)) {
                        int currentIndex = names.indexOf(racer);
                        int indexToSet = currentIndex - countPositions;
                        if (indexToSet >= 0 && indexToSet < names.size()) {
                            names.remove(racer);
                            names.add(indexToSet, racer);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.join(" ~ ", names));
    }
}
