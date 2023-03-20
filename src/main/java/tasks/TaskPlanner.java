package tasks;

import java.util.Scanner;

public class TaskPlanner {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String placeholder = "no tasks has been added on this day yet";

        Tasks planner = new Tasks("");

        planner.writeTask(Week.Sunday.name(), "do home work");
        planner.writeTask(Week.Monday.name(), "go to courses; watch a film");

        getTasks(planner,"Please, input the day of the week:");
    }

    public static void taskQuery(Tasks planner) {
        final String TERMINATE = "exit";

        String dayOfWeek = input(scan, TERMINATE);

        String errorMsg = "Sorry, I don't understand you, please try again.";

        String taskStr = switch (dayOfWeek) {
            case "Sunday" -> planner.getTask(Week.Sunday.name());
            case "Monday" -> planner.getTask(Week.Monday.name());
            case "Tuesday" -> planner.getTask(Week.Tuesday.name());
            case "Wednesday" -> planner.getTask(Week.Wednesday.name());
            case "Thursday" -> planner.getTask(Week.Thursday.name());
            case "Friday" -> planner.getTask(Week.Friday.name());
            case "Saturday" -> planner.getTask(Week.Saturday.name());
            case TERMINATE -> TERMINATE;
            default -> errorMsg;
        };

        if (taskStr.equals(TERMINATE)) {
            return;
        }

        if (taskStr.equals(errorMsg)) {
            System.out.println(errorMsg);
            taskQuery(planner);
        } else {
            if (taskStr.isEmpty()) {
                System.out.printf("No tasks for %s\n", dayOfWeek);
                getTasks(planner,"Please, input the day of the week:");
            } else {
                System.out.printf("Your tasks for %s: %s\n", dayOfWeek, taskStr);
                getTasks(planner,"Please, input the day of the week:");
            }
        }
    }

    public static void getTasks(Tasks planner, String msg) {
        System.out.println(msg);
        taskQuery(planner);
    }

    public static String input(Scanner scan, String excludedParsingStr) {
        String str = scan.nextLine().trim();

        if (str.startsWith(excludedParsingStr)) return str;

        return Tasks.parseString(str);
    }

}
