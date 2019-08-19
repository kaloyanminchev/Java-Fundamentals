package FinalExams;

import java.util.Scanner;
import java.util.TreeMap;

public class Exam03MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> userAndSent = new TreeMap<>();
        TreeMap<String, Integer> userAndReceived = new TreeMap<>();

        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Statistics")) {
            String[] tokens = input.split("=");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);

                    if (!userAndSent.containsKey(username)) {
                        userAndSent.put(username, sent);
                        userAndReceived.put(username, received);
                    }
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (userAndSent.containsKey(sender) && userAndSent.containsKey(receiver)) {
                        userAndSent.put(sender, userAndSent.get(sender) + 1);
                        userAndReceived.put(receiver, userAndReceived.get(receiver) + 1);
                        int senderCurrentCapacity = userAndSent.get(sender) + userAndReceived.get(sender);
                        int receiverCurrentCapacity = userAndSent.get(receiver) + userAndReceived.get(receiver);
                        if (senderCurrentCapacity >= capacity) {
                            userAndSent.remove(sender);
                            userAndReceived.remove(sender);
                            System.out.println(sender + " reached the capacity!");
                        }
                        if (receiverCurrentCapacity >= capacity) {
                            userAndSent.remove(receiver);
                            userAndReceived.remove(receiver);
                            System.out.println(receiver + " reached the capacity!");
                        }
                    }
                    break;
                case "Empty":
                    String user = tokens[1];
                    if (user.equals("All")) {
                        userAndSent.clear();
                        userAndReceived.clear();
                    } else {
                        userAndSent.remove(user);
                        userAndReceived.remove(user);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Users count: " + userAndSent.size());
        userAndReceived.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue() + userAndSent.get(entry.getKey())));
    }
}
