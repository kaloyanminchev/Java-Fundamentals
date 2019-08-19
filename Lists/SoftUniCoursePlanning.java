package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            String[] tokens = command.split(":");
            String typeCommand = tokens[0];
            String lesson = tokens[1];
            switch (typeCommand) {
                case "Add":
                    if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lesson)) {
                        schedule.add(index, lesson);
                    }
                    break;
                case "Remove":
                    schedule.remove(lesson);
                    schedule.remove(lesson + "-Exercise");
                    break;
                case "Swap":
                    String secondLesson = tokens[2];
                    String exerciseOne = lesson + "-Exercise";
                    String exerciseTwo = secondLesson + "-Exercise";

                    if (schedule.contains(lesson) && schedule.contains(secondLesson)) {
                        int firstIndex = schedule.indexOf(lesson);
                        int secondIndex = schedule.indexOf(secondLesson);
                        String temp = lesson;
                        schedule.set(firstIndex, secondLesson);
                        schedule.set(secondIndex, temp);
                    }
                    if (schedule.contains(exerciseOne)) {
                        schedule.remove(exerciseOne);
                        schedule.add(schedule.indexOf(lesson) + 1, exerciseOne);
                    }
                    if (schedule.contains(exerciseTwo)) {
                        schedule.remove(exerciseTwo);
                        schedule.add(schedule.indexOf(secondLesson) + 1, exerciseTwo);
                    }
                    break;
                case "Exercise":
                    String exercise = lesson + "-Exercise";
                    if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                        schedule.add(exercise);
                    } else if (!schedule.contains(exercise) && schedule.contains(lesson)) {
                        int indexLesson = schedule.indexOf(lesson);
                        schedule.add(indexLesson + 1, exercise);
                    }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, schedule.get(i));
        }
    }
}
