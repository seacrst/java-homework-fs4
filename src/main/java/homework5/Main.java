//package homework5;
//import family.*;
//import entities.*;
//
//import java.util.stream.IntStream;
//
//public class Main {
//    public static void main(String[] args) {
//        Pet goldy = new Pet(Species.Fish, "goldy");
//
//        Human man = new Human("John", "Doe", 1975);
//        System.out.println(man);
////        runFinalize();
//
//    }
//
//    public static void runFinalize() {
//        IntStream.rangeClosed(1, 10_000_000).forEach(i -> {
//            new Pet(Species.Cat, "baz");
//            Human h = new Human("foo", "bar", 1999);
//            new Family(h, h);
//        });
//    }
//}
