package family;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Family {

    private Human[] family;
    private Human father;
    private Human mother;
    private List children;

    public Family (Human father, Human mother) {
        create(father, mother);
        children = new ArrayList<Human>();
    }

    private void create(Human father, Human mother) {
        father.setFamilyRelative(this);
        mother.setFamilyRelative(this);

        this.father = father;
        this.mother = mother;

        this.family = new Human[]{father, mother};
    }


    public void addChild(Human child) {
        child.setFamilyRelative(this);

        this.children.add(child);
    }

    public boolean deleteChild(Human child) {
        int currentSize = this.children.size();
        int nextSize = (int) Stream.of(this.children).filter(c -> !c.equals(child)).count();

        return currentSize - nextSize == 1;
    }

    public boolean deleteChild(int index) {
        if (this.children.isEmpty()) return false;

        this.children.remove(index);
    }

    public int countFamily() {
        return family.length;
    }

}
