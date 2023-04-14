package family;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Family {

    private final Human mother;
    private final Human father;
    private Human[] children = {};
    private Pet pet;

    public Family (Human father, Human mother) {
        this.father = father;
        this.mother = mother;

        this.father.setFamily(this);
        this.mother.setFamily(this);
        this.children = new Human[] {};
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public Human[] getChildren() { return children; }
    public Pet getPet() { return pet; }

    public void addChild(Human child) {
        child.setFamily(this);
        this.children = Arrays.copyOf(this.children, this.children.length + 1);
        this.children[this.children.length - 1] = child;
    }

    public boolean deleteChild(Human child) {
        int len = children.length;

        Human[] prevChildren = Arrays.copyOf(children, len);

        if (len == 0) return false;
        if (len == 1 && child.equals(children[0])) {
            children = new Human[]{};
            return false;
        }

        Human[] humans = new Human[len];

        for (int i = 0; i < len; i++) {
            if (!child.equals(children[i])) {
                humans[i] = children[i];
            }
        }

        children = Stream.of(humans).filter(Objects::nonNull).toArray(Human[]::new);

        return !Arrays.deepEquals(children, prevChildren);
    }

    public boolean deleteChild(int index) {
        Human child = new Man();

        if (index >= children.length) return  false;

        for (int i = 0; i < children.length; i++) {
            if (i == index) {
                child = children[index];
                break;
            }
        }

        return deleteChild(child);
    }

    public int countFamily() {
        int count = 0;
        if (father.getFamily().toString().equals(this.toString())) {
            count++;
            if (father.getPet() != null && father.getPet().getFamily().equals(this)) {
                count++;
            }
        }
        if (mother.getFamily().toString().equals(this.toString())) {
            count++;
            if (mother.getPet() != null && mother.getPet().getFamily().equals(this)) {
                count++;
            }
        }

        for (Human h: children) {
            if (h.getFamily().toString().equals(this.toString())) {
                count++;
                if (h.getPet() != null && h.getPet().getFamily().equals(this)) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String childrenArray = "\nchildren=".concat(Arrays.toString(children));

        return String.format(father.toString().concat("\n")
                .concat(mother.toString().concat("\n")
                        .concat(childrenArray).concat("\n")
                        .concat(pet == null ? "" : pet.toString())));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            return this.father.hashCode() == obj.hashCode();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return father.hashCode() + mother.hashCode();
    }
}
