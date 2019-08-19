package MidExams;

import java.util.Scanner;

public class MidExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepsMade = Integer.parseInt(scanner.nextLine());
        double lengthOfOneStep = Double.parseDouble(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());

        double travelledDistance = 0;

        for (int step = 1; step <= stepsMade; step++) {
            if (step % 5 == 0) {
                travelledDistance += lengthOfOneStep * 0.70;
            } else {
                travelledDistance += lengthOfOneStep;
            }
        }

        travelledDistance *= 0.01;
        double result = (travelledDistance / distance) * 100;

        System.out.printf("You travelled %.2f%% of the distance!", result);
    }
}
