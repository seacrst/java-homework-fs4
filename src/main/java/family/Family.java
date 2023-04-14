package family;

import java.util.*;

public class Family {

    private final Human mother;
    private final Human father;
    private List<Human> children;
    private final Set<Pet> pets;

    public Family (Human father, Human mother) {
        this.father = father;
        this.mother = mother;

        this.father.setFamily(this);
        this.mother.setFamily(this);
        this.children = new ArrayList<>();

        pets = new HashSet<>();
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public List<Human> getChildren() { return children; }
    public Set<Pet> getPets() { return pets; }

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
        int parents = 0;
        if (father != null) parents++;
        if (mother != null) parents++;

        return parents + children.size() + pets.size();
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
                        .concat(pets == null ? "" : pets.toString())));
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
