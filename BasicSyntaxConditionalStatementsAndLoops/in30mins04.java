package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class in30mins04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int totalMins = hours * 60 + minutes + 30;

        int rHours = totalMins / 60;
        int rMinutes = totalMins % 60;

        if (rHours > 23) {
            rHours = 0;
        }

        System.out.printf("%d:%02d", rHours, rMinutes);
    }
}
