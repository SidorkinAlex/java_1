package java_1.ru.drop;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount) {
     if((food-amount) >= 0) {
         food -= amount;
         return true;
     }
     return false;
    }
    public void addFood(int add){
        food +=add;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
