package Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "int":
                int one = Integer.parseInt(scanner.nextLine());
                int two = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(one, two));
                break;
            case "char":
                char a = scanner.nextLine().charAt(0);
                char b = scanner.nextLine().charAt(0);
                System.out.println(getMax(a, b));
                break;
            case "string":
                String first = scanner.nextLine();
                String second = scanner.nextLine();
                System.out.println(getMax(first, second));
                break;
        }
    }

    static int getMax(int one, int two) {
        if (one > two) {
            return one;
        }
        return two;
    }

    static char getMax(char a, char b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }
}