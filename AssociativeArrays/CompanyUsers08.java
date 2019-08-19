package AssociativeArrays;

import java.util.*;

public class CompanyUsers08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> users = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s->\\s");
            String companyName = tokens[0];
            String employeeID = tokens[1];

            if (!users.containsKey(companyName)) {
                users.put(companyName, new ArrayList<>());
            }
            if (!users.get(companyName).contains(employeeID)) {
                users.get(companyName).add(employeeID);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue()
                    .forEach(e -> System.out.printf("-- %s%n", e));
        }
    }
}
