package family;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() { }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this(species, nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я їм!");
    }

    public void respond() {
        System.out.printf("Привіт, господар! Я - %s. Я скучив", this.nickname);
    }

    public void foul() {
        System.out.println("Потрібно замести сліди...");
    }

    public String getNickname() {
        return nickname;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getTrickLevel() {
        return this.trickLevel > 50 ? "дуже хитрий" : "не хитрий";
    }

    @Override
    public String toString() {
        return String.format(
                "%s{nickname='%s', age=%d, trickLevel=%d habits=", species, nickname, age, trickLevel
        ) + Arrays.toString(habits) + "}";
    }
}
