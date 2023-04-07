package animals;

public class RoboCat extends Pet implements Disgusting {

    public RoboCat(Species species) {
        super();
        this.species = species;
    }
    @Override
    public void respond() {
        System.out.println("00111100 00110000 01000011");
    }

    @Override
    public void foul() {
        System.out.println("роблю гидоту по своєму");
    }
}
