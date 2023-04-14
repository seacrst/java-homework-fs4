package family;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import entities.*;

public abstract class Pet {
    protected Species species;
    protected String nickname;
    protected int age = 1;
    protected int trickLevel = 1;
    protected Set<String> habits = new HashSet<String>();

    protected Family family;

    protected Pet(String nickname) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
    }
    protected Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this(nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() { }

    public void setFamily(Family family) {
        this.family = family;
    }


    public void setTrickLevel(int lvl) {
        if (lvl < 0 || lvl > 100) {
            this.trickLevel = 0;
        } else {
            this.trickLevel = lvl;
        }
    }

    public Family getFamily() { return family; }

    public String getNickname() {
        return nickname;
    }

    public Species getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }



    public String getTrickLevel() {
        return this.trickLevel > 50 ? "дуже хитрий" : "не хитрий";
    }

    public void eat() {
        System.out.println("Я їм!");
    }

    public abstract void respond();


    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return String.format(
                "%s{nickname='%s', age=%d, trickLevel=%d habits=", species, nickname, age, trickLevel
        ) + Arrays.toString(this.habits.toArray()) + "}";
    }
}
