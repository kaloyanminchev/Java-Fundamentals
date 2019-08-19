package AssociativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LegendaryFarming03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junk = new HashMap<>();

        String winnerMaterial = "";
        boolean foundWinner = false;
        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int count = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (!keyMaterials.containsKey(material)) {
                    if (!junk.containsKey(material)) {
                        junk.put(material, count);
                    } else {
                        junk.put(material, junk.get(material) + count);
                    }
                } else {
                    keyMaterials.put(material, keyMaterials.get(material) + count);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        winnerMaterial = material;
                        foundWinner = true;
                        break;
                    }
                }
            }
            if (foundWinner) {
                break;
            }
        }

        if (winnerMaterial.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (winnerMaterial.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else if (winnerMaterial.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        }

        keyMaterials
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(entry -> System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));

        junk
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(entry -> System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));
    }
}
