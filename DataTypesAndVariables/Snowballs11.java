package DataTypesAndVariables;

import java.util.Scanner;

public class Snowballs11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long highestValue = 0;
        int snowballSnowHighest = 0;
        int snowballTimeHighest = 0;
        int snowballQualityHighest = 0;
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long value = (long) Math.pow((snowballSnow / snowballTime), snowballQuality);
            if (value > highestValue) {
                highestValue = value;
                snowballSnowHighest = snowballSnow;
                snowballTimeHighest = snowballTime;
                snowballQualityHighest = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)",
                snowballSnowHighest,
                snowballTimeHighest,
                highestValue,
                snowballQualityHighest);
    }
}
