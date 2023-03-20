package family;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
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


}
