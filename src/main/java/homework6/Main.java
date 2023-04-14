package homework6;

import family.*;

public class Main {
    public static void main(String[] args) {
        Pet goldy = new Fish("goldy");

        Human john = new Man("John", "Doe", 1982);
        Woman jane = new Woman();

        ((Man) john).hunting();
        jane.shopping();
    }
}
