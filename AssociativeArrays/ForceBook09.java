package AssociativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class ForceBook09 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeSet<String>> forceBook = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"Lumpawaroo".equals(input)) {
            String[] tokens = input.split("\\s+\\|\\s+|\\s+->\\s+");

            if (input.contains("|")) {
                String forceSide = tokens[0];
                String forceUser = tokens[1];
                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide, new TreeSet<>());
                }

                boolean found = false;
                for (Map.Entry<String, TreeSet<String>> entry : forceBook.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    forceBook.get(forceSide).add(forceUser);
                }
//                if (forceBook.entrySet().stream().noneMatch(e -> e.getValue().contains(forceUser))) {
//                    forceBook.get(forceSide).add(forceUser);
//                }
            } else if (input.contains("->")) {
                String forceUser = tokens[0];
                String forceSide = tokens[1];

                for (Map.Entry<String, TreeSet<String>> entry : forceBook.entrySet()) {
                    entry.getValue().remove(forceUser);
                }
//                forceBook.forEach((key, value) -> {
//                    value.remove(forceUser);
//                });

                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide, new TreeSet<>());
                }

                forceBook.get(forceSide).add(forceUser);
                System.out.println(String.format("%s joins the %s side!", forceUser, forceSide));
            }

            input = reader.readLine();
        }

        forceBook
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(e -> System.out.printf("! %s%n", e));
                });
    }
}
