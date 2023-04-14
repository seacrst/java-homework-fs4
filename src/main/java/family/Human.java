package family;

import entities.Tasks;
import entities.Week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private Map<Week, Tasks> schedule = new HashMap<Week, Tasks>();
    private Family family;


    protected Human() {}

    protected Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        setBirthYear(year);
    }

    protected Human(String name, String surname, int year, Human father, Human mother) {
        this(name, surname, year);
        this.mother= mother;
        this.father = father;
    }

    protected Human(String name, String surname, int year, Human father, Human mother, int iq, Pet pet, Map<Week, Tasks> schedule) {
        this(name, surname, year, father, mother);
        setIq(iq);

        this.pet = pet;
        this.schedule = schedule;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}



    public void setFamily(Family family) {
        this.family = family;
        if (pet != null) {
            this.family.getPets().add(pet);
            pet.setFamily(family);
        }
    }

    public Family getFamily() { return family; }

    public void setIq(int iq) {
        if (iq < 0 || iq > 100) {
            this.iq = 0;
        } else {
            this.iq = iq;
        }
    }

    public void setBirthYear(int year) throws IllegalArgumentException {

        if (year < 1900) {
            throw new IllegalArgumentException("Human too old");
        }

        if (year > 2023) {
            throw new IllegalArgumentException("Human cannot be from the future");
        }

        this.year = year;
    }

    public Pet getPet() { return pet; }

    public abstract void greetPet();

    public void describePet() {
        String details = String.format("""
                У мене є %s, йому %d, він %s
                """, this.pet.getSpecies(), this.pet.getAge(), this.pet.getTrickLevel()
        );

        System.out.println(details);
    }

    public String[] getFormatSchedule() {
        String[] strArr = new String[schedule.size()];

        int i = 0;
        for (var key: schedule.keySet()) {
            strArr[i] = String.format("%s: %s", key, schedule.get(key));
            i++;
        }

        return  strArr;
    }
    @Override
    public String toString() {

        return String.format(
                "\nhuman={\n\tname='%s', surname='%s', year=%d, iq=%d, \n\tfather=%s, mother=%s pet=%s \n\tschedule=%s\n}",
                name, surname, year, iq, Human.getHumanFullNameAsString(father),
                Human.getHumanFullNameAsString(mother),
                pet == null ? "_" : pet.toString(), Arrays.toString(getFormatSchedule())
        );
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object h) {
        return this.hashCode() == h.hashCode();
    }

    @Override
    public int hashCode() {
        int self = name.hashCode() + surname.hashCode();

        if (father != null) {
            self += family.hashCode();
        }

        if (mother != null) {
            self += mother.hashCode();
        }

        return self;
    }

    public static String getHumanFullNameAsString(Human h) {
        if (h != null) {
            return String.format("name='%s' surname='%s'", h.getName(), h.getSurname());
        }

        return "name='_' surname='_'";
    }
}
