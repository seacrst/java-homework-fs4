package family;

import entities.Species;

import java.util.Set;

public class Dog extends Pet implements Disgusting {
    public Dog(String name) {
        super(name);
        species = Species.Dog;
    }
    public Dog(String name, int age, int trickLevel, Set<String> habits) {
        super(name, age, trickLevel, habits);
    }
    public void respond() {
        System.out.println("Bark");
    }
    @Override
    public void foul() {
        System.out.println("Spoil");
    }
}

