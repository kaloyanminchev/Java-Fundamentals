package AssociativeArrays;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumber01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> counts = new TreeMap<>();

        for (Double number : numbers) {
            if (!counts.containsKey(number)) {
                counts.put(number, 1);
            } else {
                counts.put(number, counts.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.println(String.format("%s -> %d",
                    new DecimalFormat("#.###").format(entry.getKey()),
                    entry.getValue()));
        }


    }
}
