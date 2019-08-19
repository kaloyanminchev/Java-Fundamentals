package AssociativeArrays;

import java.util.*;

public class OddOccurrences03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s+");

        Map<String, Integer> output = new LinkedHashMap<>();

        for (String s : arr) {
            String wordToLowerCase = s.toLowerCase();
            if (!output.containsKey(wordToLowerCase)) {
                output.put(wordToLowerCase, 1);
            } else {
                output.put(wordToLowerCase, output.get(wordToLowerCase) + 1);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : output.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", result));
    }
}
