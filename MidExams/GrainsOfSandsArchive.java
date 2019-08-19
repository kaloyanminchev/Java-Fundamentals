package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSandsArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> grains = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Mort".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            switch (command) {
                case "Add":
                    grains.add(value);
                    break;
                case "Remove":
                    if (grains.contains(value)) {
                        grains.remove(Integer.valueOf(value));
                    } else {
                        if (value >= 0 && value < grains.size()) {
                            grains.remove(value);
                        }
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(tokens[2]);
                    if (grains.contains(value)) {
                        int indexToReplace = grains.indexOf(value);
                        grains.set(indexToReplace, replacement);
                    }
                    break;
                case "Increase":
                    int elementToTake;
                    boolean noElement = true;
                    for (int i = 0; i < grains.size(); i++) {
                        if (grains.get(i) >= value) {
                            noElement = false;
                            elementToTake = grains.get(i);
                            for (int j = 0; j < grains.size(); j++) {
                                grains.set(j, grains.get(j) + elementToTake);
                            }
                            break;
                        }
                    }
                    if (noElement) {
                        elementToTake = grains.get(grains.size() - 1);
                        for (int i = 0; i < grains.size(); i++) {
                            grains.set(i, grains.get(i) + elementToTake);
                        }
                    }
                    break;
                case "Collapse":
                    for (int i = grains.size() - 1; i >= 0; i--) {
                        if (grains.get(i) < value) {
                            grains.remove(i);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(grains.toString().replaceAll("[\\[\\],]", ""));
    }
}
