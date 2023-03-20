package game;

import java.util.Random;

public class Game {
    public static String player;
    public static boolean over = false;

    public static int numberToGuess;

    static int[] numbersRange = {0, 100};
    static Random generator = new Random();
    public static void start(String playerName) {
        Game.player = playerName;
        Game.numberToGuess = Game.getRandomNumber(Game.numbersRange[1]);
    }

    public static void play(int number) {
        Game.over = Game.numberToGuess == number;

        if (number < numberToGuess) {
            User.message("Your number is too small. Please, try again.");
        }

        if (number > numberToGuess) {
            User.message("Your number is too big. Please, try again.");
        }

    }
    public static int getRandomNumber(int maxNumber) {
        return Game.generator.nextInt(maxNumber);
    }
}
