package FinalExams;

import java.util.Scanner;

public class Exam01StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Translate":
                    String ch = tokens[1];
                    String replacement = tokens[2];
                    text = text.replaceAll(ch, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    if (text.contains(tokens[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String stringStart = tokens[1];
                    int length = stringStart.length();
                    if (text.substring(0, length).equals(stringStart)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char symbol = tokens[1].charAt(0);
                    int lastIndex = text.lastIndexOf(symbol);
                    System.out.println(lastIndex);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    int endIndex = count + startIndex;
                    text = text.replace(text.substring(startIndex, endIndex), "");
                    System.out.println(text);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
