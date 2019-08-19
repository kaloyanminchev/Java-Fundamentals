package AssociativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentAcademy07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Double> students = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> countGrades = new LinkedHashMap<>();

        for (int i = 0; i < rows; i++) {
            String name = reader.readLine();
            double grade = Double.parseDouble(reader.readLine());
            if (!students.containsKey(name)) {
                students.put(name, grade);
                countGrades.put(name, 1);
            } else {
                students.put(name, students.get(name) + grade);
                countGrades.put(name, countGrades.get(name) + 1);
            }
        }

        LinkedHashMap<String, Double> averageGrades = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            String currentName = entry.getKey();
            double currentAverage = entry.getValue() / countGrades.get(currentName);
            averageGrades.put(currentName, currentAverage);
        }

        averageGrades
                .entrySet()
                .stream()
                .filter(n -> n.getValue() >= 4.50)
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }
}
