package MidExams;

import java.util.*;

public class HogswatchArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int homesToVisit = Integer.parseInt(scanner.nextLine());
        int initialPresents = Integer.parseInt(scanner.nextLine());
        int presents = initialPresents;
        int visitedHomes = 0;
        int timesBack = 0;
        int takenPresents = 0;
        boolean isEnough = true;

        for (int home = 1; home <= homesToVisit; home++) {
            visitedHomes++;
            int childrenPerHome = Integer.parseInt(scanner.nextLine());
            if (presents - childrenPerHome < 0) {
                timesBack++;
                int additionalPresentsTaken = (initialPresents / visitedHomes)
                        * (homesToVisit - visitedHomes)
                        + (childrenPerHome - presents);
                takenPresents += additionalPresentsTaken;
                presents += additionalPresentsTaken;
                isEnough = false;
            }
            presents -= childrenPerHome;
        }
        if (isEnough) {
            System.out.println(presents);
        } else {
            System.out.println(timesBack);
            System.out.println(takenPresents);
        }
    }
}