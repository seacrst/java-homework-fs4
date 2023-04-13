package homework4;
import family.*;
public class Main {
    public static void main(String[] args) {
        String[][] schedule = {{"monday", "foo"}, {"friday", "bar"}};

        Pet dog = new Pet("dog", "Spike");
        Pet cat = new Pet("cat", "Spooky", 2, 30, new String[] {"sleep"});

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
        boolean res2 = family.deleteChild(child);
        boolean res3 = family.deleteChild(1);


        System.out.print("DELETED ==> ");
        System.out.print(res1);
        System.out.println();
        System.out.println(family);
        System.out.println();


        System.out.print("DELETED ==> ");
        System.out.print(res2);
        System.out.println();
        System.out.println(family);
        System.out.println();

        System.out.print("DELETED ==> ");
        System.out.print(res3);
        System.out.println();
        System.out.println(family);
        System.out.println();


        System.out.print("FAMILY COUNT ==> ");
        System.out.print(family.countFamily());

        System.out.println("\n=====================\nFAMILY 2");
        Human july = new Human("July", "Doe", 1992);
        Family family2 = new Family(child, july);
        System.out.println(family2);
        System.out.println("Does FAMILY 1 equals FAMILY 2 ?");
        System.out.println(family.equals(family2));
    }
}
