import family.Family;
import family.Human;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {

    @Test
    public void toStringTest() {
        Human man = new Human("John", "Doe", 1975);
        String manOutput = "\nhuman={\n\tname='John', surname='Doe', year=1975, iq=0, \n\tfather=name='_' surname='_', mother=name='_' surname='_' pet=_ \n\tschedule=[]\n}";

        assertEquals(manOutput, man.toString());
    }
    @Test
    public void toStringTestFails() {
        Human man = new Human("John", "Doe", 1975);
        String manOutput = "human={\n\tname='John', surname='Doe', year=1975, iq=0, \n\tfather=name='_' surname='_', mother=name='_' surname='_' pet=_ \n\tschedule=[]\n}";

        assertNotEquals(manOutput, man.toString());
    }
    @Test
    public void addChildTest() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);
        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        assertEquals(family.getChildren().length, 3);
    }


    @Test
    public void addChildArrayLengthTest() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);
        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);

        int originChildrenLength = family.getChildren().length;

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        int targetChildrenLength = family.getChildren().length;

        assertNotEquals(originChildrenLength, targetChildrenLength);
    }

    @Test
    public void addChildArrayDistinctionTest() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);

        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);


        Human[] originChildren = family.getChildren();

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        family.deleteChild(kid1);
        family.deleteChild(kid2);
        family.deleteChild(kid3);


        assertNotEquals(originChildren, family.getChildren());

    }

    @Test
    public void childrenArrayDistinctionTest() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);

        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);


        Human[] originChildren = family.getChildren();

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        family.deleteChild(kid1);
        family.deleteChild(kid2);
        family.deleteChild(kid3);


        assertNotEquals(originChildren, family.getChildren());

    }

    @Test
    public void childrenArraySameEmptinessTest() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);

        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);


        Human[] originChildren = family.getChildren();

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        family.deleteChild(kid1);
        family.deleteChild(kid2);
        family.deleteChild(kid3);

        assertArrayEquals(originChildren, family.getChildren());
    }

    @Test
    public void deleteChildTestWithInstance() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);
        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        boolean res = family.deleteChild(kid3);

        assertTrue(res);
    }

    @Test
    public void deleteChildTestWithIndex() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);
        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);

        boolean res = family.deleteChild(10);

        assertFalse(res);
    }


    @Test
    public void familyCountTest() {

        Human man = new Human("John", "Doe", 1975);
        Human woman = new Human("Jane", "Doe", 1975);
        Human kid1 = new Human("Jack", "Doe", 2000);
        Human kid2 = new Human("Jim", "Doe", 2001);
        Human kid3 = new Human("Josh", "Doe", 2002);

        Family family = new Family(man, woman);

        family.addChild(kid1);
        family.addChild(kid2);
        family.addChild(kid3);


        assertEquals(family.countFamily(), 5);
    }
}
