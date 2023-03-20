import game.*;
public class GuessingGame {
    public static void main(String[] args) {
        User.welcome("Let the game begin!");
        User.message("Enter your name");
        String name = User.inputString();
        User.message("Enter guess number");
        Game.start(name);

        while(!Game.over) {
            Game.play(User.inputNumber());
        }

        User.message(String.format("Congratulations, %s!", Game.player));
    }


}