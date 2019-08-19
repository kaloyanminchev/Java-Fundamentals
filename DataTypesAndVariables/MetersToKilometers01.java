package DataTypesAndVariables;

import java.util.Scanner;

public class MetersToKilometers01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        double kilometers = meters / 1000d; // 1000.0 = meters * 1.0
        System.out.printf("%.2f", kilometers);

    }
}
