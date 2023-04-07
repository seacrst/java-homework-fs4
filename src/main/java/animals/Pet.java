package animals;

public abstract class Pet {

    Species species = Species.UNKNOWN;
    public void eat() {
        System.out.println("Я їм!");
    }

    abstract void respond();
}
