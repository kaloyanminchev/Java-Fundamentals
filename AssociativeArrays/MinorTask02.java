package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinorTask02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            int qty = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(input, 0);
            resources.put(input, resources.get(input) + qty);

            input = scanner.nextLine();
        }
//        resources.entrySet().forEach(e -> System.out.println(String.format("%s -> %d", e.getKey(), e.getValue())));
        for (Map.Entry<String, Integer> e : resources.entrySet()) {
            System.out.println(String.format("%s -> %d", e.getKey(), e.getValue()));
        }
    }
}
