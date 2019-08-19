package FinalExams;

import java.util.Scanner;

public class April06Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encrypted = scanner.nextLine();
        String[] elements = scanner.nextLine().split("\\s+");
        String elementToReplace = elements[0];
        String replacement = elements[1];

        if (!encrypted.matches("[d-z{}|#]+")) {
            System.out.println("This is not the book you are looking for.");
        } else {
            StringBuilder decoded = new StringBuilder();
            for (int i = 0; i < encrypted.length(); i++) {
                char symbol = encrypted.charAt(i);
                decoded.append((char) (symbol - 3));
            }
            String result = decoded.toString();
            result = result.replace(elementToReplace, replacement);
            System.out.println(result);
        }

//        Another Solution:
//        Scanner scanner = new Scanner(System.in);
//        String regex = "^[^a-c][d-z{}|#]+$";
//        Pattern pattern = Pattern.compile(regex);
//
//        String encryptedMessage = scanner.nextLine();
//        Matcher matcher = pattern.matcher(encryptedMessage);
//
//        if (matcher.find()) {
//            String decodedMessage = "";
//
//            for (int i = 0; i < encryptedMessage.length(); i++) {
//                char symbol = encryptedMessage.charAt(i);
//                decodedMessage += (char) (symbol - 3);
//            }
//            String[] secondInput = scanner.nextLine().split(" ");
//            String firstSubstring = secondInput[0];
//            String secondSubstring = secondInput[1];
//
//            decodedMessage = decodedMessage.replace(firstSubstring, secondSubstring);
//            System.out.println(decodedMessage);
//        } else {
//            System.out.println("This is not the book you are looking for.");
//        }
    }
}
