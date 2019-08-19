package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (validatePassword(password)) {
            System.out.println("Password is valid");
        }
    }

    static boolean validatePassword(String password) {
        boolean isValid = true;
        if (!checkLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        if (!checkContent(password)) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }
        if (!checkDigits(password)) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }
        return isValid;
    }

    static boolean checkLength(String password) {

        return password.length() >= 6 && password.length() <= 10;
    }

    static boolean checkContent(String password) {
        boolean isValid = true;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static boolean checkDigits(String password) {
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                countDigits++;
                if (countDigits == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
