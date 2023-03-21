package family;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human[] family;
    private Human father;
    private Human mother;
    private Human[] children = new Human[] {};

    public Family (Human father, Human mother) {
        create(father, mother);
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

        this.family = Arrays.copyOf(this.family, this.family.length + 1);
        this.family[this.family.length - 1] = child;

        this.children = Arrays.copyOf(this.children, this.children.length + 1);

        this.children[this.children.length - 1] = child;
    }

    public boolean deleteChild(Human child) {
        int idx = 0;
        boolean result = false;
        for (Human searchChild: this.children) {
            if (searchChild.hashCode() == child.hashCode()) {
                result = deleteChild(idx);
            }
            idx++;
        }

        return result;
    }

    public boolean deleteChild(int index) {
        if (this.children.length == 0) return false;

        final int prevLength = this.children.length;

        for (Human child: this.children) {
            if (child.equals(this.children[index])) {
                this.children[index] = null;
                break;
            }
        }

        this.children = (Human[]) Arrays.stream(this.children).filter(child -> child != null).toArray();

        return prevLength != this.children.length;
    }

    public int countFamily() {
        return family.length;
    }

}
