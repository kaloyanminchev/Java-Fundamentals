package AssociativeArrays;

import java.util.*;

public class Courses06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+:\\s+");
            String courseName = tokens[0];
            String studentName = tokens[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            } else {
                if (!courses.get(courseName).contains(studentName)) {
                    courses.get(courseName).add(studentName);
                }
            }
            input = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    Collections.sort(entry.getValue());
                    entry.getValue().forEach(e -> System.out.println("-- " + e));
                });
    }
}
