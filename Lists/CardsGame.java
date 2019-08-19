package Lists;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstPlayer = scanner.nextLine().split("\\s+");
        String[] secondPlayer = scanner.nextLine().split("\\s+");

        List<Integer> firstDeck = new ArrayList<>();
        List<Integer> secondDeck = new ArrayList<>();

        for (int i = 0; i < firstPlayer.length; i++) {
            firstDeck.add(Integer.parseInt(firstPlayer[i]));
        }

        for (String element : secondPlayer) {
            secondDeck.add(Integer.parseInt(element));
        }

//        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {}
        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
            if (firstDeck.get(0) > secondDeck.get(0)) {
                firstDeck.add(firstDeck.get(0));
                firstDeck.add(secondDeck.get(0));
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else if (firstDeck.get(0) < secondDeck.get(0)) {
                secondDeck.add(secondDeck.get(0));
                secondDeck.add(firstDeck.get(0));
                secondDeck.remove(0);
                firstDeck.remove(0);
            } else {
                firstDeck.remove(0);
                secondDeck.remove(0);
            }
        }

        String winner = "";
        if (firstDeck.size() > secondDeck.size()) {
            winner = "First player wins! Sum: " + firstDeck.stream().mapToInt(e -> e).sum();
        } else {
            winner = "Second player wins! Sum: " + secondDeck.stream().mapToInt(e -> e).sum();
        }
        System.out.println(winner);
    }
}
