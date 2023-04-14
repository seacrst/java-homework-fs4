package family;

import entities.Species;

public class Dog extends Pet implements Disgusting {
    public Dog(String name) {
        super(name);
        species = Species.Dog;
    }
    public Dog(String name, int age, int trickLevel, String[] habits) {
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

