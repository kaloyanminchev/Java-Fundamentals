package DataTypesAndVariables;

import java.util.Scanner;

public class WaterOverflow07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int litters = Integer.parseInt(scanner.nextLine());

            if (sum + litters > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                sum += litters;
            }
        }
        System.out.println(sum);
    }
}
