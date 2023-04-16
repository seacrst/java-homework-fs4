package homework8;

import family.Family;
import family.FamilyController;
import family.Man;

public class Main {
    public static void main(String[] args) {

        FamilyController families = new FamilyController();

        Man father = new Man("John", "Doe", 1975);
        Man mother = new Man("Jane", "Doe", 1978);

        families.createNewFamily(father, mother);

        families.displayAllFamilies();


        Family f = families.getFamilyById(0);
        System.out.println("FAMILY INDEX 0:");
        System.out.print(f);
    }
}
