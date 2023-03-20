package tasks;

public class Tasks {
    static String[][] schedule = new String[7][2];
    final String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public Tasks(String placeholder) {
        initSchedule(placeholder);
    }

    private void initSchedule(String initialValue) {
        int idx = 0;

        for (String[] task : schedule) {
            task[0] = week[idx];
            task[1] = initialValue;
            idx++;
        }
    }

    public void writeTask(String dayOfWeek, String taskText) {
        int idx = 0;
        boolean exist = false;

        for (String day : week) {
            if (day.equals(dayOfWeek)) {
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


}
