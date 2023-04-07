package animals;

public class Fish extends Pet {

    public Fish(Species species) {
        super();
        this.species = species;
    }
    @Override
    public void respond() {
        System.out.println("буль-буль");
    }
}
