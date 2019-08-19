package AssociativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUnitParking05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countCommands = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, String> cars = new LinkedHashMap<>();

        for (int i = 0; i < countCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = tokens[2];
                    if (cars.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s\n", licensePlateNumber);
                    } else {
                        cars.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully\n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!cars.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found\n", username);
                    } else {
                        cars.remove(username);
                        System.out.printf("%s unregistered successfully\n", username);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : cars.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }
    }
}
