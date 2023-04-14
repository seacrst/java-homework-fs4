package family;

import entities.Schedule;

public final class Woman extends Human {

    public Woman() {
        super();
    }
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, Human father, Human mother) {
        super(name, surname, year, father, mother);
    }

    public Woman(String name, String surname, int year, Human father, Human mother, int iq, Pet pet, Schedule[] schedule) {
        super(name, surname, year, father, mother, iq, pet, schedule);
    }

    public void shopping() { }
    @Override
    public void greetPet() {
        System.out.println("Hey sweetie");
    }
}
