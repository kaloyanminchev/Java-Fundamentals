package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        if (firstList.size() > secList.size()) {
            for (int i = 0; i < firstList.size(); i++) {
                if (i < secList.size()) {
                    result.add(firstList.get(i));
                    result.add(secList.get(i));
                } else {
                    result.add(firstList.get(i));
                }
            }
        } else {
            for (int i = 0; i < secList.size(); i++) {
                if (i < firstList.size()) {
                    result.add(firstList.get(i));
                    result.add(secList.get(i));
                } else {
                    result.add(secList.get(i));
                }
            }
        }
        for (Integer number : result) {
            System.out.print(number + " ");
        }
    }
}
