package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!"3:1".equals(command)) {
            String[] tokens = command.split("\\s+");
            String type = tokens[0];
            switch (type) {
                case "merge":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex >= data.size()) {
                        endIndex = data.size() - 1;
                    }
                    if (startIndex >= data.size()) {
                        command = scanner.nextLine();
                        continue;
                    } else {
                        for (int i = endIndex; i > startIndex; i--) {
                            data.set(startIndex, data.get(startIndex) + data.get(startIndex + 1));
                            data.remove(startIndex + 1);
                        }
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(tokens[1]);
                    int partitions = Integer.parseInt(tokens[2]);
                    String elementToDivide = data.get(index);
                    List<String> newList = new ArrayList<>();

                    if (elementToDivide.length() % partitions == 0) {
                        int lengthPortion = elementToDivide.length() / partitions;
                        int count = 0;
                        for (int i = 0; i < partitions; i++) {
                            String concat = "";
                            for (int j = 0; j < lengthPortion; j++) {
                                char symbol = elementToDivide.charAt(count);
                                concat += symbol;
                                count++;
                            }
                            newList.add(concat);
                        }
                    } else {
                        int lengthPortion = elementToDivide.length() / partitions;
                        int count = 0;
                        for (int i = 0; i < partitions; i++) {
                            String concat = "";

                            if (i == partitions - 1) {
                                for (int j = count; j < elementToDivide.length(); j++) {
                                    char symbol = elementToDivide.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                            } else {
                                for (int j = 0; j < lengthPortion; j++) {
                                    char symbol = elementToDivide.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                            }
                            newList.add(concat);
                        }
                    }
                    data.remove(index);
                    data.addAll(index, newList);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(data.toString().replaceAll("[\\[\\],]", ""));

    }
}
