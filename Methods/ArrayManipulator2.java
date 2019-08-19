package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] commandArray = command.split(" ");

            if (command.contains("exchange")) {
                exchange(inputArray, Integer.parseInt(commandArray[1]));
            } else if (command.contains("max")) {

                if (command.contains("even")) {
                    maxEven(inputArray);
                } else {
                    maxOdd(inputArray);
                }
            } else if (command.contains("min")) {

                if (command.contains("even")) {
                    minEven(inputArray);
                } else {
                    minOdd(inputArray);
                }
            } else if (command.contains("first")) {

                if (command.contains("even")) {
                    firstCountEven(inputArray, Integer.parseInt(commandArray[1]));
                } else {
                    firstCountOdd(inputArray, Integer.parseInt(commandArray[1]));
                }
            } else if (command.contains("last")) {
                if (command.contains("even")) {
                    lastCountEven(inputArray, Integer.parseInt(commandArray[1]));
                } else {
                    lastCountOdd(inputArray, Integer.parseInt(commandArray[1]));
                }
            }

            command = scanner.nextLine();
        }

        System.out.print("[");
        for (int i = 0; i < inputArray.length; i++) {

            if (i < inputArray.length - 1) {
                System.out.print(inputArray[i] + ", ");
            } else {
                System.out.print(inputArray[i]);
            }
        }
        System.out.println("]");
    }
    // NEW METHOD

    public static void exchange(int[] inputArray, int splitAtIndex) {

        if (splitAtIndex < 0 || splitAtIndex > inputArray.length - 1) {
            System.out.println("Invalid index");
        } else {
            int[] firstHalf = new int[splitAtIndex + 1];
            int[] secondHalf = new int[inputArray.length - firstHalf.length];

            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = inputArray[i];
            }

            for (int i = 0; i <= secondHalf.length - 1; i++) {
                secondHalf[(secondHalf.length - 1) - i] = inputArray[(inputArray.length - 1) - i];
            }

            for (int i = 0; i < secondHalf.length; i++) {
                inputArray[i] = secondHalf[i];
            }

            for (int i = 0; i < firstHalf.length; i++) {
                inputArray[inputArray.length - (1 + i)] = firstHalf[firstHalf.length - (i + 1)];
            }
        }
    }

    // NEW METHOD

    public static void maxOdd(int[] inputArray) {
        int maxOddIndex = 0;
        int maxOdd = 0;
        boolean noOddNumbers = true;

        for (int i = 0; i < inputArray.length; i++) {

            if (inputArray[i] % 2 != 0) {
                noOddNumbers = false;

                if (inputArray[i] >= maxOdd) {
                    maxOdd = inputArray[i];
                    maxOddIndex = i;
                }
            }
        }

        if (noOddNumbers) {
            System.out.println("No matches");
        } else {
            System.out.println(maxOddIndex);
        }
    }

// NEW METHOD

    public static void maxEven(int[] inputArray) {
        int maxEvenIndex = 0;
        int maxEven = 0;
        boolean noEvenNumbers = true;

        for (int i = 0; i < inputArray.length; i++) {

            if (inputArray[i] % 2 == 0) {
                noEvenNumbers = false;

                if (inputArray[i] >= maxEven) {
                    maxEven = inputArray[i];
                    maxEvenIndex = i;
                }
            }
        }
        if (noEvenNumbers) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenIndex);
        }
    }

    // NEW METHOD
    public static void minEven(int[] inputArray) {
        int minEvenIndex = 0;
        int minEven = Integer.MAX_VALUE;

        boolean noEvenNumbers = true;

        for (int i = 0; i < inputArray.length; i++) {

            if (inputArray[i] % 2 == 0) {
                noEvenNumbers = false;

                if (inputArray[i] <= minEven) {
                    minEven = inputArray[i];
                    minEvenIndex = i;
                }
            }
        }
        if (noEvenNumbers) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenIndex);
        }
    }

// NEW METHOD

    public static void minOdd(int[] inputArray) {
        int minOddIndex = 0;
        int minOdd = Integer.MAX_VALUE;

        boolean noOddNumbers = true;

        for (int i = 0; i < inputArray.length; i++) {

            if (inputArray[i] % 2 != 0) {
                noOddNumbers = false;

                if (inputArray[i] <= minOdd) {
                    minOdd = inputArray[i];
                    minOddIndex = i;
                }
            }
        }
        if (noOddNumbers) {
            System.out.println("No matches");
        } else {
            System.out.println(minOddIndex);
        }
    }

// NEW METHOD

    public static void firstCountEven(int[] inputArray, int firstXElements) {

        int[] holdElements = new int[firstXElements];
        int foundElements = 0;

        for (int i = 0; i < inputArray.length; i++) {

            if (foundElements < firstXElements) {

                if (inputArray[i] % 2 == 0) {
                    holdElements[foundElements] = inputArray[i];
                    foundElements++;
                }
            }
        }
        if (firstXElements > inputArray.length) {
            System.out.println("Invalid count");
        } else if (foundElements == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < foundElements; i++) {
                if (foundElements > 1 && i < foundElements - 1) {
                    System.out.print(holdElements[i] + ", ");
                } else {
                    System.out.print(holdElements[i]);
                }
            }
            System.out.println("]");
        }
    }

    // NEW METHOD

    public static void firstCountOdd(int[] inputArray, int firstXElements) {
        int[] holdElements = new int[firstXElements];
        int foundElements = 0;

        for (int i = 0; i < inputArray.length; i++) {

            if (foundElements < firstXElements) {

                if (inputArray[i] % 2 != 0) {
                    holdElements[foundElements] = inputArray[i];
                    foundElements++;
                }
            }
        }

        if (firstXElements > inputArray.length) {
            System.out.println("Invalid count");
        } else if (foundElements == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < foundElements; i++) {
                if (foundElements > 1 && i < foundElements - 1) {
                    System.out.print(holdElements[i] + ", ");
                } else {
                    System.out.print(holdElements[i]);
                }
            }
            System.out.println("]");
        }
    }

    // NEW METHOD
    public static void lastCountEven(int[] inputArray, int lastXElements) {

        int[] holdElements = new int[lastXElements];
        int foundElements = 0;

        for (int i = inputArray.length - 1; i >= 0; i--) {

            if (foundElements < lastXElements) {

                if (inputArray[i] % 2 == 0) {
                    holdElements[foundElements] = inputArray[i];
                    foundElements++;
                }
            }
        }
        if (lastXElements > inputArray.length) {
            System.out.println("Invalid count");
        } else if (foundElements == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < foundElements; i++) {
                if (foundElements > 1 && i < foundElements - 1) {
                    System.out.print(holdElements[i] + ", ");
                } else {
                    System.out.print(holdElements[i]);
                }
            }
            System.out.println("]");
        }
    }

    // NEW METHOD
    public static void lastCountOdd(int[] inputArray, int lastXElements) {
        int[] holdElements = new int[lastXElements];
        int foundElements = 0;

        for (int i = inputArray.length - 1; i >= 0; i--) {

            if (foundElements < lastXElements) {

                if (inputArray[i] % 2 != 0) {
                    holdElements[foundElements] = inputArray[i];
                    foundElements++;
                }
            }
        }
        if (lastXElements > inputArray.length) {
            System.out.println("Invalid count");
        } else if (foundElements == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < foundElements; i++) {
                if (foundElements > 1 && i < foundElements - 1) {
                    System.out.print(holdElements[i] + ", ");
                } else {
                    System.out.print(holdElements[i]);
                }
            }
            System.out.println("]");
        }
    }
}
