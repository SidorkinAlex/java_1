package java_1.ru.drop;

public class Main {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0]= new Person("Васильков Николай Михайлович","Главный Бухгалтер","vasilkov@mail.ru","+79208126577",100000,33);
        persArray[1]= new Person("Новиков Алексей Михайлович","Главный Инженер","novikov@mail.ru","+79208126577",110000,33);
        persArray[2]= new Person("Лыжников Дмитрий Михайлович","Главный по лыжам","lignikov@mail.ru","+79208126577",120000,53);
        persArray[3]= new Person("Велосипедов Георгий Михайлович","Главный по велосипедам","velosipedov@mail.ru","+79208126577",130000,63);
        persArray[4]= new Person("Горбунков Ефстафий Михайлович","Главный по коням","gorbunkov@mail.ru","+79208126577",140000,73);
        for (Person pers: persArray) {
            if(pers.age > 40) {
                pers.sowPerson();
            }
        }
    }
}
