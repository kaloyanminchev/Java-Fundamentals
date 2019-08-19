package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class April14OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> listStores = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String store = tokens[1];
            if (input.contains("Add")) {
                String item = tokens[2];
                if (!item.contains(",")) {
                    listStores.putIfAbsent(store, new ArrayList<>());
                    listStores.get(store).add(item);
                } else {
                    String[] arrayOfItems = item.split(",");
                    listStores.putIfAbsent(store, new ArrayList<>());
                    for (String product : arrayOfItems) {
                        listStores.get(store).add(product);
                    }
                }
            } else if (input.contains("Remove")) {
                listStores.remove(store);
            }
            input = scanner.nextLine();
        }

        System.out.println("Stores list:");
        listStores
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sort == 0) {
                        sort = e2.getKey().compareTo(e1.getKey());
                    }
                    return sort;
                })
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(e -> System.out.printf("<<%s>>\n", e));
                });
    }
}
