package FinalExams;

import java.util.*;

public class IronGirder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> townAndTime = new TreeMap<>();
        HashMap<String, Integer> townAndPassengers = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Slide rule")) {
            String[] tokens = input.split("->");
            int passengers = Integer.parseInt(tokens[1]);

            String[] array = tokens[0].split(":");
            String town = array[0];

            if (!input.contains("ambush")) {
                int time = Integer.parseInt(array[1]);
                if (!townAndTime.containsKey(town)) {
                    townAndTime.put(town, time);
                    townAndPassengers.put(town, passengers);
                } else {
                    if (townAndTime.get(town) == 0 || time < townAndTime.get(town)) {
                        townAndTime.put(town, time);
                    }
                    townAndPassengers.put(town, townAndPassengers.get(town) + passengers);
                }
            } else {
                if (townAndTime.containsKey(town)) {
                    townAndTime.put(town, 0);
                    townAndPassengers.put(town, townAndPassengers.get(town) - passengers);
                }
            }

            input = scanner.nextLine();
        }

        townAndTime.entrySet()
                .stream()
                .filter(n -> n.getValue() > 0)
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> {
                    if (townAndPassengers.get(entry.getKey()) > 0) {
                        System.out.printf("%s -> Time: %d -> Passengers: %d%n", entry.getKey(), entry.getValue(), townAndPassengers.get(entry.getKey()));
                    }
                });
    }
}
