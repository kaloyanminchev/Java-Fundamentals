package DataTypesAndVariables;

import java.util.Scanner;

public class CenturiesToMinutes09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte century = Byte.parseByte(scanner.nextLine());
        int years = century * 100;
        int days = (int) (years * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", century, years, days, hours, minutes);


    }
}
