package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec16SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(":");
            String artist = tokens[0];
            String song = tokens[1];

            String artistRegex = "^[A-Z][a-z'\\s]+$";
            Matcher artistMatcher = Pattern.compile(artistRegex).matcher(artist);

            String songRegex = "^[A-Z\\s]+$";
            Matcher songMatcher = Pattern.compile(songRegex).matcher(song);

            if (artistMatcher.find() && songMatcher.find()) {
                String encryptedInfo = "";
                int key = artistMatcher.group().length();
                for (int i = 0; i < input.length(); i++) {
                    char symbol = input.charAt(i);
                    if (symbol == ':') {
                        encryptedInfo += "@";
                    } else if (symbol != ' ' && symbol != '\'') {
                        if (symbol >= 65 && symbol <= 90) {
                            if (symbol + key > 90) {
                                encryptedInfo += (char) (symbol + key - 26);
                            } else {
                                encryptedInfo += (char) (symbol + key);
                            }
                        } else if (symbol >= 97 && symbol <= 122) {
                            if (symbol + key > 122) {
                                encryptedInfo += (char) (symbol + key - 26);
                            } else {
                                encryptedInfo += (char) (symbol + key);
                            }
                        }
                    } else {
                        if (symbol == ' ') {
                            encryptedInfo += ' ';
                        } else {
                            encryptedInfo += '\'';
                        }
                    }
                }
                System.out.println("Successful encryption: " + encryptedInfo);
            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }
}
