package java_1.ru.drop;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void scare(Cat cat) {
        System.out.println(name + " gav gav " + cat.getName());
        cat.fear(this);
    }

}
