package Arrays;

import java.util.Scanner;

public class DayOfWeek01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = Integer.parseInt(scanner.nextLine());
        String[] daysNames = {"Monday",
                              "Tuesday",
                              "Wednesday",
                              "Thursday",
                              "Friday",
                              "Saturday",
                              "Sunday",};
        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println(daysNames[dayNumber - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
