package tasks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tasks {
    static String[][] schedule = new String[7][2];
    final Week[] week = Week.values();
    public Tasks(String placeholder) {
        initSchedule(placeholder);
    }

    private void initSchedule(String initialValue) {
        int idx = 0;

        String[] days = new String[7];
        convertWeekToStringArr(week, days);

        for (String[] task : schedule) {
            task[0] = days[idx];
            task[1] = initialValue;
            idx++;
        }
    }

    public void writeTask(String dayOfWeek, String taskText) {
        int idx = 0;
        boolean exist = false;

        for (Week day : week) {
            if (day.equals(Week.valueOf(dayOfWeek))) {
                schedule[idx][1] = taskText;
                exist = true;
            }

            idx++;
        }

        if (!exist) {
            throw new IllegalStateException("Invalid day value");
        }
    }

    public String getTask(String dayOfWeek) {

        for (String[] task: schedule) {
            if (task[0].equals(dayOfWeek)) {
                return task[1];
            }
        }

        return "";
    }

    static String parseString(String str) {
        char[] charArr = str.trim().toCharArray();
        charArr[0] = Character.toUpperCase(charArr[0]);

        return String.copyValueOf(charArr);
    }


    private void convertWeekToStringArr(Week[] week, String[] array) {
        int idx = 0;
        for (Week day: week) {
            array[idx] = day.day;
            idx++;
        }
    }


}
