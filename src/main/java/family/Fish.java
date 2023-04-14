package family;

import entities.Species;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String name) {
        super(name);
        species = Species.Fish;
    }
    public Fish(String name, int age, int trickLevel, Set<String> habits) {
        super(name, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Bubbling");
    }
}
