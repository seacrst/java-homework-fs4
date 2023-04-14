package family;

import java.util.Arrays;
import entities.*;

public abstract class Pet {
    protected Species species;
    private String nickname;
    private int age = 1;
    private int trickLevel = 1;
    private String[] habits = new String[] {};
    private Family family;

    protected Pet(String nickname) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
    }
    protected Pet(String nickname, int age, int trickLevel, String[] habits) {
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
        ) + Arrays.toString(this.habits) + "}";
    }
}
