package MidExams;

import java.util.Scanner;

public class BonusSystemArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = Double.MIN_VALUE;
        int studentAttendances = 0;

        for (int i = 1; i <= students; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = Math.ceil(attendances * 1.0 / lectures * (5 + bonus));
            if (totalBonus >= maxBonus) {
                maxBonus = totalBonus;
                studentAttendances = attendances;
            }
        }

        System.out.printf("The maximum bonus score for this course is %.0f.The student has attended %d lectures.", maxBonus, studentAttendances);
    }
}
