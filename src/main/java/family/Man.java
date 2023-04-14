package family;

import entities.Schedule;

public final class Man extends Human {

    public Man() {
        super();
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, Human father, Human mother) {
        super(name, surname, year, father, mother);
    }

    public Man(String name, String surname, int year, Human father, Human mother, int iq, Pet pet, Schedule[] schedule) {
        super(name, surname, year, father, mother, iq, pet, schedule);
    }

    public void hunting() { }


    @Override
    public void greetPet() {
        System.out.println("What's up body");
    }
}
