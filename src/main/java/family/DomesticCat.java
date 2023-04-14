package family;

import entities.Species;

public class DomesticCat extends Pet implements Disgusting {

    public DomesticCat(String name) {
        super(name);
        species = Species.Cat;
    }
    public DomesticCat(String name, int age, int trickLevel, String[] habits) {
        super(name, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Meow");
    }

    @Override
    public void foul() {
        System.out.println("Scrape");
    }
}
