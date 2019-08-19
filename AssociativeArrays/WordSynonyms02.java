package AssociativeArrays;

import java.util.*;

public class WordSynonyms02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            String synonym = scanner.next();

            if (!words.containsKey(word)) {
                words.put(word, new ArrayList<>());
            }
            words.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
