package family;

import entities.Species;

public class RoboCat extends Pet implements Disgusting {
    public RoboCat(String name) {
        super(name);
    }
    public RoboCat(String name, int age, int trickLevel, String[] habits) {
        super(name, age, trickLevel, habits);
    }
    @Override
    public void respond() {
        System.out.println("Better meow");
    }

    @Override
    public void foul() {
        System.out.println("Destroy robot vacuum cleaner");
    }
}
