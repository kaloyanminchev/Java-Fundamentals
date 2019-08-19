package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class StudentInformation01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());

        System.out.println(String.format("Name: %s, Age: %d, Grade: %.2f", name, age, grade));

    }
}
