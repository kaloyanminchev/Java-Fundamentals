package Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println(output(s, count));
    }

    static String output(String s, int count) {
        String[] output = new String[count];
        for (int i = 0; i < output.length; i++) {
            output[i] = s;
        }
        String result = String.join("", output);
        return result;
    }
}
