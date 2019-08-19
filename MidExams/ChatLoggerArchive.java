package MidExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatLoggerArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> output = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] tokens = command.split("\\s+");
            String type = tokens[0];

            switch (type) {
                case "Chat":
                    output.add(tokens[1]);
                    break;
                case "Delete":
                    String messageToDelete = tokens[1];
                    output.remove(messageToDelete);
                    break;
                case "Edit":
                    String messageToEdit = tokens[1];
                    String editedVersion = tokens[2];
                    int indexToEdit = output.indexOf(messageToEdit);
                    output.set(indexToEdit, editedVersion);
                    break;
                case "Pin":
                    String message = tokens[1];
                    if (output.contains(message)) {
                        output.remove(message);
                        output.add(message);
                    }
                    break;
                case "Spam":
                    for (int i = 1; i < tokens.length; i++) {
                        output.add(tokens[i]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(System.lineSeparator(), output));
    }
}
