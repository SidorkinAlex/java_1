package java_1.ru.drop;

public class Cat {
    private String name;
    boolean satiety = false;
    final int PORTION = 10;


    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(PORTION)) {
            System.out.println(name + " eat");
            satiety = true;
        } else {
            System.out.println(name + " non eat");
        }
    }

    public void fear(Dog dog) {
        System.out.println(name + " fear " + dog.getName());
    }


    public void writeSatiety() {
        String satietyWrite = satiety ? "deadly" : "well-fed";
        System.out.println(name + " is " + satietyWrite);
    }
}
