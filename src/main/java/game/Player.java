package game;

import java.util.Scanner;

public class Player {
    public static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextInt();
    }

    public static void message(String text) {
        System.out.println(text);
    }

}
