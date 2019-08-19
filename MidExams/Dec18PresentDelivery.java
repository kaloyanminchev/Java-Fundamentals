package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dec18PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> houses = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        int santaIndex = 0;
        while (!"Merry Xmas!".equals(command)) {
            String[] tokens = command.split("\\s+");
            int length = Integer.parseInt(tokens[1]);

            if (santaIndex + length < houses.size()) {
                santaIndex += length;
            } else {
                santaIndex = (santaIndex + length) % houses.size();
            }

            if (houses.get(santaIndex).equals(0)) {
                System.out.printf("House %d will have a Merry Christmas.%n", santaIndex);
            } else {
                houses.set(santaIndex, houses.get(santaIndex) - 2);
            }

            command = scanner.nextLine();
        }
        System.out.printf("Santa's last position was %d.%n", santaIndex);

        int count = 0;
        boolean successful = true;
        for (Integer house : houses) {
            if (!house.equals(0)) {
                successful = false;
                count++;
            }
        }

        if (successful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Santa has failed %d houses.", count);
        }
    }
}
