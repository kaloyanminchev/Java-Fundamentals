package TextProcessing;

import java.util.Scanner;

public class CaesarCipher04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            input.setCharAt(i, (char) (symbol + 3));
        }
        System.out.println(input);

//        String text = scanner.nextLine();
//
//        for (Character symbol : text.toCharArray()) {
//            System.out.print((char)(symbol + 3));
//        }
    }
}

