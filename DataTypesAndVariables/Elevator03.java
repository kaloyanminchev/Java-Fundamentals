package DataTypesAndVariables;

import java.util.Scanner;

public class Elevator03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (numberOfPeople > capacity) {
            sum += numberOfPeople / capacity;
            numberOfPeople = numberOfPeople % capacity;
        }
        if (numberOfPeople != 0 && numberOfPeople < capacity) {
            sum += 1;
        }
        System.out.println(sum);
    }
}
