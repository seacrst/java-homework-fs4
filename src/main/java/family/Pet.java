package family;

import java.util.Arrays;
import entities.*;

public class Pet {
    private Species species;
    private String nickname;
    private int age = 1;
    private int trickLevel = 1;
    private String[] habits = new String[] {};
    private Family family;

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this(species, nickname);
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

    public void respond() {
        System.out.printf("Привіт, господар! Я - %s. Я скучив", nickname);
    }

    public void foul() {
        System.out.println("Потрібно замести сліди...");
    }


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
