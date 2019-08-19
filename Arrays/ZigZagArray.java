package Arrays;

import java.util.Scanner;

public class ZigZagArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] first = new String[n];
        String[] second = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                first[i] = input[0];
                second[i] = input[1];
            } else {
                first[i] = input[1];
                second[i] = input[0];
            }
        }
        System.out.println(String.join(" ", first));
        System.out.println(String.join(" ", second));
    }
}