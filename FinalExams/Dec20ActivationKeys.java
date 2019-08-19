package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dec20ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("&");
        List<String> output = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            StringBuilder keyResult = new StringBuilder();
            String currentKey = line[i];
            if (validateKey(currentKey)) {
                if (currentKey.length() == 16) {
                    for (int j = 0; j < currentKey.length(); j++) {
                        for (int k = j; k < j + 4; k++) {
                            keyResult.append(currentKey.charAt(k));
                        }
                        if (j + 4 < currentKey.length()) {
                            keyResult.append('-');
                        }
                        j += 3;
                    }
                } else if (currentKey.length() == 25) {
                    for (int j = 0; j < currentKey.length(); j++) {
                        for (int k = j; k < j + 5; k++) {
                            keyResult.append(currentKey.charAt(k));
                        }
                        if (j + 5 < currentKey.length()) {
                            keyResult.append('-');
                        }
                        j += 4;
                    }
                }
                for (int j = 0; j < keyResult.length(); j++) {
                    char symbol = keyResult.charAt(j);
                    if (Character.isLetter(symbol)) {
                        keyResult.setCharAt(j, Character.toUpperCase(symbol));
                    } else if (Character.isDigit(symbol)) {
                        keyResult.setCharAt(j, (char) ('9' - symbol + '0'));
                    }
                }
                output.add(keyResult.toString());
            }
        }

        System.out.println(String.join(", ", output));
    }

    private static boolean validateKey(String currentKey) {
        if (currentKey.length() != 16 && currentKey.length() != 25) {
            return false;
        }
        for (int i = 0; i < currentKey.length(); i++) {
            if (!Character.isLetterOrDigit(currentKey.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
