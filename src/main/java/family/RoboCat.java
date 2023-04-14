package family;

import entities.Species;

import java.util.Set;

public class RoboCat extends Pet implements Disgusting {
    public RoboCat(String name) {
        super(name);
    }
    public RoboCat(String name, int age, int trickLevel, Set<String> habits) {
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
