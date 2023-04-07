package animals;

public class DomesticCat extends Pet implements Disgusting {
    public DomesticCat(Species species) {
        super();
        this.species = species;
    }
    @Override
    public void respond() {
        System.out.println("мау");
    }

    @Override
    public void foul() {
        System.out.println("роблю гидоту по своєму");
    }
}
