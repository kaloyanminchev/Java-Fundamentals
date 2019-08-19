package DataTypesAndVariables;

import java.util.Scanner;

public class PokeMon10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        double half = N * 0.5;
        int counter = 0;

        while (N >= M) {
            counter++;
            N -= M;

            if (N == half) {
                if (Y > 0) {
                    N /= Y;
                }
            }
        }
        System.out.println(N);
        System.out.println(counter);
    }
}
