package animals;

public class Dog extends Pet implements Disgusting{

    public Dog(Species species) {
        super();
        this.species = species;
    }
    @Override
    public void respond() {
        System.out.println("гав");
    }

    @Override
    public void foul() {
        System.out.println("роблю гидоту по своєму");
    }
}
