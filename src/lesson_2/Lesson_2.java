package lesson_2;

import java.util.Arrays;
import java.util.HashMap;

public class Lesson_2 {
    // выполнение заданий
    public static void main(String[] args) {
        int[] test = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        // задание1
        System.out.println("Задание 1");
        System.out.println(Arrays.toString(ReversNull(test)));
        System.out.println("Задание 2");
        System.out.println(Arrays.toString(mackeArray3step()));
        System.out.println("Задание 3");
        int[] test3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multiply2less6(test3)));
        System.out.println("Задание 4");
        prinnt2array(mackeXinarray(21)); // вводим размерность массива
        System.out.println("Задание 5");
        int[] test5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 32, 232, 345578, 987, 234, 134, 578, 689, 78934, 5234, 98};
        HashMap maxminArrr = minAndMaxArray(test5);
        System.out.println("Минимальное значение массива:" + maxminArrr.get("MinVal") + " \n Ключ минимального значения массива:" + maxminArrr.get("MinKey") + "\n Максимальное значение массива:" + maxminArrr.get("MaxVal") + " \n Ключ Максимального значения массива:" + maxminArrr.get("MaxKey"));
        System.out.println("Задание 6");
        int[] test6 = {2, 2, 2, 1, 2, 2, 10, 1};
        if (SummArray(test6)) {
            System.out.println("массиве есть место, в котором сумма левой и правой части массива равны");
        } else {
            System.out.println("массиве нет места, в котором сумма левой и правой части массива равны");
        }
        System.out.println("Задание 7");
        int[] test7 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(OffsetArray(test7,-3)));
    }

    // Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int[] ReversNull(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else if (a[i] == 1) {
                a[i] = 0;
            }
        }
        return a;
    }

    //2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static int[] mackeArray3step() {
        int[] array;
        array = new int[8];
        byte a = 0;
        for (int i = 0; i <= 7; i++) {
            array[i] = i * 3;
        }
        return array;
    }

    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;
    public static int[] multiply2less6(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] = a[i] * 2;
            }
        }
        return a;
    }

    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static int[][] mackeXinarray(int number) {
        int[][] arrayX = new int[number][number];

        for (int i = 0; i <= number - 1; i++) {
            for (int j = 0; j <= number - 1; j++) {
                if (i == j || i == -(j - (number - 1))) {
                    arrayX[i][j] = 1;
                } else {
                    arrayX[i][j] = 0;
                }
            }
        }

        return arrayX;
    }

    public static void prinnt2array(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static HashMap minAndMaxArray(int[] array) {
        HashMap maxMinArray = new HashMap();
        int keyMax = 0;
        int keyMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[keyMax]) {
                keyMax = i;
            } else if (array[i] < array[keyMin]) {
                keyMin = i;
            }
        }
        maxMinArray.put("MinVal", array[keyMin]);
        maxMinArray.put("MinKey", keyMin);
        maxMinArray.put("MaxVal", array[keyMax]);
        maxMinArray.put("MaxKey", keyMax);
        return maxMinArray;
    }

    //Написать метод, в который передается не пустой одномерный
    // целочисленный массив, метод должен вернуть true, если в
    // массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean SummArray(int[] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            summ = summ + array[i];
            int summLast = 0;
            int iteration = i;
            for (int ii = (iteration + 1); ii < array.length; ii++) {
                summLast = summLast + array[ii];
            }
            if (summ == summLast) {
                return true;
            }
        }
        return false;
    }

    //Написать метод, которому на вход подается одномерный массив и число
    // n (может быть положительным, или отрицательным), при этом метод должен сместить
    // все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static int[] OffsetArray(int[] array, int stap) {
        if (stap > 0) {
            for (int i = stap; i != 0; i--) {
                int first = array[(array.length - 1)];
                for (int j = 1; j <= (array.length - 1); j++) {
                    array[array.length - j] = array[array.length - j - 1];
                }
                array[0] = first;
            }
        } else {
            for (int i = -stap; i != 0; i--) {
                int last = array[0];
                for (int j = 1; j <= (array.length - 1); j++) {
                    array[j - 1] = array[j];
                }
                array[(array.length - 1)] = last;
            }
        }
        return array;
    }


}
