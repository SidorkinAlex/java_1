package java_1.ru.drop;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Barsik");
        cats[1] = new Cat("Mirsik");
        cats[2] = new Cat("Muska");
        cats[3] = new Cat("Gav");
        cats[4] = new Cat("Baks");
        Plate plate = new Plate(30);

        for (Cat cat : cats) {
            cat.eat(plate);
        }
        for (Cat cat : cats) {
            cat.writeSatiety();
        }

    }

    static void abcd(Object o){
        System.out.println(o);
    }
}
