package FinalExams;

import java.util.*;

public class Dec16Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> bandAndMembers = new LinkedHashMap<>();
        TreeMap<String, Integer> bandAndTime = new TreeMap<>();

        String command = scanner.nextLine();
        while (!"start of concert".equals(command)) {
            String[] tokens = command.split("; ");
            String bandName = tokens[1];
            if (tokens[0].equals("Add")) {
                bandAndMembers.putIfAbsent(bandName, new LinkedHashSet<>());
                String[] members = tokens[2].split(", ");
                for (String member : members) {
                    bandAndMembers.get(bandName).add(member);
                }
            } else {
                int time = Integer.parseInt(tokens[2]);
                if (!bandAndTime.containsKey(bandName)) {
                    bandAndTime.put(bandName, time);
                } else {
                    bandAndTime.put(bandName, bandAndTime.get(bandName) + time);
                }
            }

            command = scanner.nextLine();
        }

        int totalTime = bandAndTime.entrySet().stream().mapToInt(e -> e.getValue()).sum();
        System.out.println("Total time: " + totalTime);
        bandAndTime.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue())));

        String printBand = scanner.nextLine();
        System.out.println(printBand);
        for (Map.Entry<String, LinkedHashSet<String>> entry : bandAndMembers.entrySet()) {
            if (entry.getKey().equals(printBand)) {
                entry.getValue().forEach(e -> System.out.printf("=> %s%n", e));
            }
        }
    }
}
