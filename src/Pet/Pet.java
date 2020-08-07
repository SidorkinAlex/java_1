package Pet;

public class Pet {
    String name;
    int runLimit = 0;
    int swimLimit = 0;

    public Pet(String name) {
        this.name = name;
    }

    public void run(int var) {
        if (var <= runLimit) {
            System.out.printf("%s пробежал %d метров \n", name, var);
        } else {
            System.out.printf("%s пробежал %d метров устал упал без чувств \n", name, runLimit);
        }
    }

    public void swim(int var) {
        if (var <= swimLimit) {
            System.out.printf("%s проплыл %d метров\n", name, var);
        } else {
            System.out.printf("%s проплыл %d метров и утонул\n", name, swimLimit);
        }
    }

}
