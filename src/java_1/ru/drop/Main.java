package java_1.ru.drop;

public class Main {

    public static void main(String[] args) {
        // Создать переменные всех пройденных типов данных и инициализировать их значения/
        byte varByte = 10;
        short varShort = 2020;
        int varInt = 9999;
        long varLong = 293841340928L;
        float varFloat = 764.23234f;
        double varDouble = 928734.12391;
        char varChar = '\u6576';
        boolean varBool = true;
    }

    //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float MathematicalOperations(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean dubleSumm(int a, int b) {

        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    //Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
    // в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void IsPositive(int number) {
        if (number < 0) {
            System.out.println("Число " + number + " отрицательное");
        } else {
            System.out.println("Число " + number + " положительное");
        }
    }

    //Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
    // отрицательное, и вернуть false если положительное.
    public static boolean IsNegative(int number) {
        return (number < 0);
    }

    //Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void helloName(String Name) {
        System.out.println("Привет " + Name + "!");
    }

    //Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void LeapYear(int year){
        if (year % 100 != 0 && year % 4 == 0 || year % 400 ==0){
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " не год является високосным");
        }
    }
}

