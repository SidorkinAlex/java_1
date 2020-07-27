package java_1.ru.drop;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        play();
        scanner.close();
    }

    private static void play() {
        System.out.println("Ваша задача угадать число");
        int range = 10;
        playLevel(range);
        replay();
    }

    private static void playLevel(int range) {
        int random_number = (int) (Math.random() * range);
        int iter = 0;
        while (iter < 3) {
            System.out.println("Угадайте числоо от 0 до " + range);
            int imputNumber = scanner.nextInt();
            if (imputNumber == random_number) {
                System.out.println("Поздравляем Вы угадали число " + random_number);
                break;
            } else if (imputNumber > random_number) {
                System.out.println(" Вы не угадали число Ваше число больше ");
            } else {
                System.out.println(" Вы не угадали число Ваше число меньше ");
            }
            iter++;
        }
    }

    private static void replay() {
        System.out.println("Если хотите сыграть еще раз введите 1, если нет введите любое другое число");
        int play = scanner.nextInt();
        if (play == 1) {
            play();
        }
    }
}