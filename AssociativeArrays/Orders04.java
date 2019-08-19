package AssociativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Orders04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> itemsWithCount = new LinkedHashMap<>();
        LinkedHashMap<String, Double> itemsWithPrice = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"buy".equals(input)) {
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int count = Integer.parseInt(tokens[2]);

            if (!itemsWithCount.containsKey(product)) {
                itemsWithCount.put(product, count);
                itemsWithPrice.put(product, price);
            } else {
                itemsWithCount.put(product, itemsWithCount.get(product) + count);
                itemsWithPrice.put(product, price);
            }
            input = reader.readLine();
        }
        for (Map.Entry<String, Integer> entry : itemsWithCount.entrySet()) {
            System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue() * itemsWithPrice.get(entry.getKey()));
        }
    }
}
