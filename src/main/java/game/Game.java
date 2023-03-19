package game;

import java.util.Random;

public class Game {

    public static boolean over = false;
    public Game(String outputMessage) {
        message(outputMessage);
    }

    public int[] generateTargetCoordinates(int cols, int rows) {
        var random = new Random();
        int y = random.nextInt(1, cols);
        int x = random.nextInt(1, rows);
        return new int[] {y, x};
    }


    public void play(Area board) {
        char[][] cols = board.area;

        message(String.format("Set column number from 1 to %d", cols.length));
        int inputCol = Player.inputNumber();

        message(String.format("Set row number from 1 to %d", cols[0].length));
        int inputRow = Player.inputNumber();

        board.markAt(inputCol, inputRow, '*');

        Game.over = match(board, inputCol, inputRow);

        if (Game.over) {
            board.markAt(board.getStored(0), board.getStored(1), 'X');
        } else {
            Player.message("You missed. Please try again");

            board.display();
        }
    }

    public void cheat(Area area) {
        Player.message(String.format("target at column %d and row %d", area.getStored(0), area.getStored(1)));
    }

    public boolean match(Area area, int col, int row) {
        int targetCol = area.getStored(0);
        int targetRow = area.getStored(1);

        return targetRow == row && targetCol == col;
    }

    public void message(String text) {
        System.out.println(text);
    }
}
