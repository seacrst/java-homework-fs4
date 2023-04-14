package family;

import entities.Species;

public class Fish extends Pet {
    public Fish(String name) {
        super(name);
        species = Species.Fish;
    }
    public Fish(String name, int age, int trickLevel, String[] habits) {
        super(name);
    }

    @Override
    public void respond() {
        System.out.println("Bubbling");
    }
}
