package FieldofDreams;


import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class FieldofDreams {
    public static void main(String[] args) {
        beforeplay();
    }
    private static void beforeplay(){
        play();
        replay();
        //scanner.close();
    }

    private static void play() {
        String Word;
        String InputWord;
        String ReturnWord = "###############";
        boolean WordFalse = true;
        Word = genericWord();
        while (WordFalse) {
            InputWord = getWord();
            ReturnWord = checkWord(Word, InputWord, ReturnWord);
            if (ReturnWord.equals(InputWord)){
                WordFalse = false;
            }
            System.out.println(ReturnWord);
        }
    }

    private static String genericWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String retWord;
        int RandomKey = (int) (Math.random() * 25);
        retWord = words[RandomKey];
        return retWord;
    }

    private static String getWord() {

        Scanner scanner = new Scanner(in);
        System.out.println("Введите слово");
        String getWordVar = "";
            getWordVar = scanner.nextLine();
        return getWordVar;
    }

    private static String checkWord(String Word, String InputWord, String ReturnWord) {
        if (Word.equals(InputWord))
        {
            return InputWord;
        }
        String[] ArrWord=Word.split("");
        String[] ArrInputWord=InputWord.split("");
        String[] ArrReturnWord=ReturnWord.split("");
        for (int i = 0; i < 15; i++) {
            String WordLetter="";
            if ( i < ArrWord.length) {
                WordLetter = ArrWord[i];
            }

            String InputWordLetter="";
            if (i < ArrInputWord.length) {
                InputWordLetter = ArrInputWord[i];
            }

            if (WordLetter.equals(InputWordLetter) && !WordLetter.isEmpty() && ArrReturnWord[i].equals("#")) {
                ArrReturnWord[i] = ArrInputWord[i];
            }

        }
        ReturnWord=String.join("", ArrReturnWord);
        return ReturnWord;
    }

    private static void replay() {
        Scanner scanner = new Scanner(in);
        System.out.println("Если хотите сыграть еще раз введите 1, если нет введите любое другое число");
        int play = scanner.nextInt();
        if (play == 1) {
            beforeplay();
        }
    }
}
