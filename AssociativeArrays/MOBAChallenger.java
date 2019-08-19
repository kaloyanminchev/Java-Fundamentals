package AssociativeArrays;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> participants = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Season end")) {
            if (!input.contains("vs")) {
                String[] tokens = input.split("\\s->\\s");
                String player = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                if (!participants.containsKey(player)) {
                    participants.put(player, new TreeMap<>());
                    participants.get(player).put(position, skill);
                } else {
                    if (!participants.get(player).containsKey(position)) {
                        participants.get(player).put(position, skill);
                    } else {
                        if (participants.get(player).get(position) < skill) {
                            participants.get(player).put(position, skill);
                        }
                    }
                }

            } else {
                String[] array = input.split("\\svs\\s");
                String firstPlayer = array[0];
                String secondPlayer = array[1];

                String playerToRemove = "";
                if (participants.containsKey(firstPlayer) && participants.containsKey(secondPlayer)) {

                    for (Map.Entry<String, Integer> entry : participants.get(firstPlayer).entrySet()) {

                        if (participants.get(secondPlayer).containsKey(entry.getKey())) {
                            int totalSkillSecondPlayer = participants.get(secondPlayer).entrySet().stream().mapToInt(e -> e.getValue()).sum();
                            int totalSkillFirstPlayer = participants.get(firstPlayer).entrySet().stream().mapToInt(e -> e.getValue()).sum();
                            if (totalSkillSecondPlayer < totalSkillFirstPlayer) {
                                playerToRemove = secondPlayer;
                                break;
                            } else if (totalSkillSecondPlayer > totalSkillFirstPlayer) {
                                playerToRemove = firstPlayer;
                                break;
                            }
                        }
                    }
                    if (playerToRemove.equals(firstPlayer)) {
                        participants.remove(firstPlayer);
                    } else if (playerToRemove.equals(secondPlayer)) {
                        participants.remove(secondPlayer);
                    }
                }
            }
            input = scanner.nextLine();
        }

        participants.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum() - e1.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum())
                .forEach(entry -> {
                    if (entry.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum() > 0) {
                        System.out.println(String.format("%s: %d skill", entry.getKey(), entry.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum()));
                        entry.getValue().entrySet().stream()
                                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                                .forEach(n -> System.out.printf("- %s <::> %d%n", n.getKey(), n.getValue()));
                    }
                });
    }
}
