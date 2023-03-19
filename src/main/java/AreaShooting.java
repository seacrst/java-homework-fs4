import game.*;

public class AreaShooting {
    public static void main(String[] args) {
        final int ROW_SIZE = 5;
        final int COLUMN_SIZE = 5;

        Game areaShooting = new Game("All set. Get ready to rumble!");

        Area gameArea = new Area(COLUMN_SIZE, ROW_SIZE);
        gameArea.fill('_');

        int[] targetState = areaShooting.generateTargetCoordinates(COLUMN_SIZE, ROW_SIZE); // return entry of [col, row]
        gameArea.store(targetState[0], targetState[1]);

        gameArea.display();

//        areaShooting.cheat(gameArea);


        while (!Game.over) {
            areaShooting.play(gameArea);
        }

        Player.message("You have won!");
        gameArea.display();

    }





}
