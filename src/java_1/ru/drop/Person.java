package java_1.ru.drop;

public class Person {
    String fio;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Person(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void sowPerson(){
        System.out.printf("**********\n Сотрудник: %s\n Должность: %s\n Email: %s\n Телефон: %s\n Зарплата: %d\n Возраст: %d\n**********\n",fio,position,email,phone,salary,age);
    }
}
