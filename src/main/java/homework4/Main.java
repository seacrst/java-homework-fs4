package homework4;

import entities.Human;
import entities.Pet;

public class Main {
    public static void main(String[] args) {
        String[][] schedule = {{"monday", "foo"}, {"friday", "bar"}};

        Pet dog = new Pet("dog", "Spike");
        Pet cat = new Pet("cat", "Spooky");

        Human father = new Human("John", "Doe", 1980);
        Human mother = new Human("Jane", "Doe", 1982);

        Human child = new Human("Jack", "Doe", 1990, father, mother, 70, dog, schedule);
        Human child2 = new Human("Jim", "Doe", 1991, father, mother, 71, cat, schedule);
        Human child3 = new Human("Josh", "Doe", 1991, father, mother);

        Family family = new Family(father, mother);

        family.addChild(child);
        family.addChild(child2);
        family.addChild(child3);

        System.out.println(family);
        System.out.print("FAMILY COUNT ==> ");
        System.out.print(family.countFamily());
        System.out.println();

        boolean res1 = family.deleteChild(child);
        boolean res2 = family.deleteChild(1);

        System.out.println(res1);
        System.out.println(family);
        System.out.println();
        System.out.println(res2);
        System.out.println(family);


        System.out.print("FAMILY COUNT ==> ");
        System.out.print(family.countFamily());
    }
}
