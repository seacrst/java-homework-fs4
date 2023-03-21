package family;

public class Human implements Relative {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    private Family relative;

    public Human() { }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    public Human(String name, String surname, int year, Human father, Human mother) {
        this(name, surname, year);
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this(name, surname, year, father, mother);
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }


    public void greetPet() {
        System.out.printf("Привіт, %s", this.pet.getNickname());
    }

    public void describePet() {
        String details = String.format("""
                У мене є %s, йому %d, він %s
                """, this.pet.getSpecies(), this.pet.getAge(), this.pet.getTrickLevel()
        );

        System.out.println(details);
    }

    public void setFamilyRelative(Family family) {
        relative = family;
    }

    @Override
    public int hashCode() {
        return relative.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return String.format(
                "%s={name='%s', surname='%s', year=%d, iq=%d, mother=%s, father=%s, pet=%s",
                Human.class.getName(), name, surname, year, iq, String.format("%s %s", this.mother.name, this.mother.surname),
                String.format("%s %s", this.father.name, this.father.surname),
                this.pet.toString()
        );
    }
}
