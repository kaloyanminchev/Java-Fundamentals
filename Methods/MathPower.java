package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());
        double result = pow(number, pow);
        DecimalFormat format = new DecimalFormat("#.########");
        System.out.println(format.format(result));
    }

    public static double pow(double number, int pow) {
        double result = 1;

        for (int i = 1; i <= pow; i++) {
            result *= number;
        }
        return result;
    }
}