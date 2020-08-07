package java_1.ru.drop;

import Pet.Cat;
import Pet.Dog;

public class Main {

    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик");
        catBarsik.run(100);
        catBarsik.swim(100);
        catBarsik.run(500);
        Dog dogBarsik = new Dog("Шарик");

        dogBarsik.run(100);
        dogBarsik.swim(5);
        dogBarsik.run(500);
        dogBarsik.swim(15);
    }
}
