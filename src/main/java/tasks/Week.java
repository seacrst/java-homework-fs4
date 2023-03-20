package tasks;

public enum Week {
    Sunday("Sunday"),
    Monday("Monday"),
    Tuesday("Tuesday"),
    Wednesday("Wednesday"),
    Thursday("Thursday"),
    Friday("Friday"),
    Saturday("Saturday");

    final String day;
    Week(String day) {
        this.day = day;
    }
}
