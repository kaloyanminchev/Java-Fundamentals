package MidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> contactList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (true) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String contact = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (contactList.contains(contact)) {
                        if (index >= 0 && index < contactList.size()) {
                            contactList.add(index, contact);
                        }
                    } else {
                        contactList.add(contact);
                    }
                    break;
                case "Remove":
                    int place = Integer.parseInt(tokens[1]);
                    if (place >= 0 && place < contactList.size()) {
                        contactList.remove(place);
                    }
                    break;
                case "Export":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < contactList.size()) {
                        if (count > contactList.size()) {
                            for (int i = startIndex; i < contactList.size(); i++) {
                                System.out.print(contactList.get(i) + " ");
                            }
                        } else {
                            int currentIndex = startIndex;
                            for (int i = 0; i < count; i++) {
                                System.out.print(contactList.get(currentIndex) + " ");
                                currentIndex++;
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Print":
                    String type = tokens[1];
                    if ("Normal".equals(type)) {
                        System.out.print("Contacts: ");
                        System.out.println(String.join(" ", contactList));
                    } else if ("Reversed".equals(type)) {
                        Collections.reverse(contactList);
                        System.out.print("Contacts: ");
                        System.out.println(String.join(" ", contactList));
                    }
                    return;
            }
            input = scanner.nextLine();
        }
    }
}
