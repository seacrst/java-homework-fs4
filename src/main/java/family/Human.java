package family;

import entities.Schedule;

import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private Schedule[] schedule = {};
    private Family family;


    public Human() {}

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        setBirthYear(year);
    }

    public Human(String name, String surname, int year, Human father, Human mother) {
        this(name, surname, year);
        this.mother= mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, Human father, Human mother, int iq, Pet pet, Schedule[] schedule) {
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

    public String[] getFormatSchedule() {
        String[] strArr = new String[schedule.length];

        for (int i = 0; i < schedule.length; i++) {
            strArr[i] = String.format("%s: %s", schedule[i].day(), schedule[i].task());
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
