package family;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Family {

    private final Human mother;
    private final Human father;
    private List<Human> children;
    private Pet pet;

    public Family (Human father, Human mother) {
        this.father = father;
        this.mother = mother;

        this.father.setFamily(this);
        this.mother.setFamily(this);
        this.children = new ArrayList<>();
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public List<Human> getChildren() { return children; }
    public Pet getPet() { return pet; }

    public void addChild(Human child) {
        child.setFamily(this);

        children.add(child);
    }

    public boolean deleteChild(Human child) {
        children = children.stream().filter(c -> !c.equals(child)).toList();

        return !children.contains(child);
    }

    public boolean deleteChild(int index) {
        if (index >= children.size()) return false;

        Human h = children.remove(index);

        return children.contains(h);
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
        String childrenArray = "\nchildren=".concat(Arrays.toString(children.toArray()));

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
