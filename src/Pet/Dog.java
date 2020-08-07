package Pet;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
        runLimit = 500;
        swimLimit = 10;
    }
}
