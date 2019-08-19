package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Nov18QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!"Retire!".equals(command)) {
            String[] tokens = command.split(" - ");
            String type = tokens[0];

            switch (type) {
                case "Start":
                    if (!journal.contains(tokens[1])) {
                        journal.add(tokens[1]);
                    }
                    break;
                case "Complete":
                    journal.remove(tokens[1]);
                    break;
                case "Side Quest":
                    String[] typeQuest = tokens[1].split(":");
                    String quest = typeQuest[0];
                    String sideQuest = typeQuest[1];
                    if (journal.contains(quest)) {
                        int indexQuest = journal.indexOf(quest);
                        if (!journal.contains(sideQuest)) {
                            journal.add(indexQuest + 1, sideQuest);
                        }
                    }
                    break;
                case "Renew":
                    if (journal.contains(tokens[1])) {
                        journal.add(tokens[1]);
                        journal.remove(tokens[1]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", journal));
    }
}

