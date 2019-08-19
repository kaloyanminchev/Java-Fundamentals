package FinalExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class April06Dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, List<String>> wordsWithDefinitions = new TreeMap<>();

        String[] firstInput = reader.readLine().split("\\s\\|\\s");
        for (int i = 0; i < firstInput.length; i++) {
            String[] tokens = firstInput[i].split(":\\s");
            String word = tokens[0];
            String definition = tokens[1];
            wordsWithDefinitions.putIfAbsent(word, new ArrayList<>());
            wordsWithDefinitions.get(word).add(definition);
        }

        String[] secondInput = reader.readLine().split("\\s\\|\\s");
        for (String word : secondInput) {
            if (wordsWithDefinitions.containsKey(word)) {
                System.out.println(word);
                wordsWithDefinitions.get(word).stream()
                        .sorted((e1, e2) -> Integer.compare(e2.length(), e1.length()))
                        .forEach(e -> System.out.println(" -" + e));
            }
        }

        String command = reader.readLine();
        if (command.equals("List")) {
            for (Map.Entry<String, List<String>> entry : wordsWithDefinitions.entrySet()) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
