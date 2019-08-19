package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        while (!"end".equalsIgnoreCase(command)) {
            String[] currentCommand = command.split("\\s+");
            String type = currentCommand[0];
            if ("exchange".equals(type)) {
                int index = Integer.parseInt(currentCommand[1]);
                if (isInRange(arr, index)) {
                    rotateArray(arr, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if ("max".equals(type)) {
                int index;
                if ("even".equals(currentCommand[1])) {
                    index = findMaxEven(arr);
                } else {
                    index = findMaxOdd(arr);
                }
                if (index != -1) {
                    System.out.println(index);
                } else {
                    System.out.println("No matches");
                }
            } else if ("min".equals(type)) {
                int index;
                if ("even".equals(currentCommand[1])) {
                    index = findMinEven(arr);
                } else {
                    index = findMinOdd(arr);
                }
                if (index != -1) {
                    System.out.println(index);
                } else {
                    System.out.println("No matches");
                }
            } else if ("first".equals(type)) {
                int count = Integer.parseInt(currentCommand[1]);
                if (count > arr.length) {
                    System.out.println("Invalid count");
                } else {
                    if ("even".equals(currentCommand[2])) {
                        int[] result = findFirstEven(arr, count);
                        printArray(result);
                    } else {
                        int[] result = findFirstOdd(arr, count);
                        printArray(result);
                    }
                }
            } else if ("last".equals(type)) {
                int count = Integer.parseInt(currentCommand[1]);
                if (count > arr.length) {
                    System.out.println("Invalid count");
                } else {
                    if ("even".equals(currentCommand[2])) {
                        int[] result = findLastEven(arr, count);
                        printArray(result);
                    } else {
                        int[] result = findLastOdd(arr, count);
                        printArray(result);
                    }
                }
            }

            command = scanner.nextLine();
        }
        printArray(arr);
    }

    private static int[] findLastOdd(int[] arr, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0 && index < result.length) {
                result[index] = arr[i];
                index++;
            }
        }
        int[] isWorking = new int[result.length];
        int ind = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            isWorking[ind] = result[i];
            ind++;
        }
        return isWorking;
    }

    private static int[] findLastEven(int[] arr, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0 && index < result.length) {
                result[index] = arr[i];
                index++;
            }
        }
        int[] isWorking = new int[result.length];
        int ind = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            isWorking[ind] = result[i];
            ind++;
        }
        return isWorking;
    }

    private static int[] findFirstOdd(int[] arr, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && index < result.length) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else if (arr[i + 1] != -1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }

    static int[] findFirstEven(int[] arr, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && index < result.length) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    static int findMinOdd(int[] arr) {
        int minOdd = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                if (arr[i] <= minOdd) {
                    minOdd = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    static int findMinEven(int[] arr) {
        int minEven = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] <= minEven) {
                    minEven = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    static int findMaxOdd(int[] arr) {
        int maxOdd = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                if (arr[i] >= maxOdd) {
                    maxOdd = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    static int findMaxEven(int[] arr) {
        int maxEven = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] >= maxEven) {
                    maxEven = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    static void rotateArray(int[] arr, int index) {
        int[] left = new int[index + 1];
        int[] right = new int[arr.length - left.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        int indexator = 0;
        for (int i = index + 1; i < arr.length; i++) {
            right[indexator] = arr[i];
            indexator++;
        }

        for (int i = 0; i < right.length; i++) {
            arr[i] = right[i];
        }
        for (int i = right.length; i < arr.length; i++) {
            arr[i] = left[i - right.length];
        }

    }

    static boolean isInRange(int[] numbers, int index) {
        return index >= 0 && index < numbers.length;
    }
}
