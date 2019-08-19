package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsString01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = String.join("", scanner.nextLine().split("\\s"));
//        String input = scanner.nextLine().replaceAll(" ", "");
        LinkedHashMap<Character, Integer> someMap = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!someMap.containsKey(symbol)) {
                someMap.put(symbol, 1);
            } else {
                someMap.put(symbol, someMap.get(symbol) + 1);
            }
        }

        someMap.forEach((key, value) -> System.out.println(String.format("%c -> %d",
                key, value)));

    }
}

//    String text = scanner.nextLine();
//    LinkedHashMap<Character, Integer> someMap = new LinkedHashMap<>();
//
//        for (char symbol : text.toCharArray()) {
//                if (symbol != ' ') {
//                    if (!someMap.containsKey(symbol)) {
//                         someMap.put(symbol, 1);
//                } else {
//                    someMap.put(symbol, someMap.get(symbol) + 1);
//                }
//        }
//     }