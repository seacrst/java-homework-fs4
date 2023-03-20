import family.*;
public class Main {
    public static void main(String[] args) {
        enum Foo {
            Bar() {
                void baz() {
                    System.out.println("FOO BAR");
                }
            };

            Foo () {

            }

        }

        Foo foo = Foo.Bar;

        foo

        Foo.Bar.baz()

    }


}