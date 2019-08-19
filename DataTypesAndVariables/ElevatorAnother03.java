package DataTypesAndVariables;

import java.util.Scanner;

public class ElevatorAnother03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        double course = Math.ceil(numberOfPeople * 1.0 / capacity);
        int result = (int) course;
        System.out.println(result);

    }
}
