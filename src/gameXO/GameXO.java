package gameXO;

import java.util.*;

public class GameXO {
    final int size = 6;
    final int winSize = 4;
    char[][] map = new char[size][size];
    final char cNull = '•', player = 'x', cpu1 = 'o', cpu2 = 'W', cpu3 = 'Z';
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public static void main(String[] args) {
        GameXO g = new GameXO();
        g.newMap();
        g.printMap();

        while (true) {
            //player turn
            g.playerTurn();
            g.printMap();
            if (g.checkWin(g.player)) {
                System.out.println("CONGRATULATIONS! YOU ARE THE WINNER");
                break;
            }
            if (g.isMapFull()) {
                System.out.println("GAME OVER. NOBODY'S WIN");
                break;
            }

            //AI-1 turn
            g.aiTurn(g.cpu1);
            g.printMap();
            if (g.checkWin(g.cpu1)) {
                System.out.println("GAME OVER. CPU1 IS THE WINNER");
                break;
            }
            if (g.isMapFull()) {
                System.out.println("GAME OVER. NOBODY'S WIN");
                break;
            }

        }
    }

    void newMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = cNull;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print(">X");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(" " + (i + 1) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println(i + 1);
        }
        System.out.print(" vY ");
        for (int i = 1; i <= size; i++) System.out.print(i + "  ");
        System.out.println("O\n");
    }

    void playerTurn() {
        int x, y;
        do {
            System.out.println("YOUR TURN. Enter coordinates >X vY");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            //System.out.println("Your enter coordinates: x = " + (x + 1) + ", y = " + (y + 1));
        } while (!isCellValid(x, y));
        map[y][x] = player;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        if (map[y][x] == cNull) return true;
        return false;
    }

    boolean checkWin(char c) {
        int countV;
        int countH;
        for (int i = 0; i <= size - 1; i++) {
            countH = 0;
            countV = 0;
            for (int j = 0; j <= size - 1; j++) {
                //tested horizontal check
                if (map[i][j] == c) {
                    countH++;
                    if (countH == winSize) {
                        return true;
                    }
                    int countDiagonalRU = 1;
                    int countDiagonalLU = 1;
                    int countDiagonalRB = 1;
                    int countDiagonalLB = 1;
                    for (int k = 1; k <= winSize - 1; k++) {
                        System.out.println("k=" + k);
                        System.out.println("winSize=" + winSize);
                        // check right up
                        if (i - k >= 0 && j - k >= 0 && map[i - k][j - k] == c) {
                            countDiagonalLU++;
                        }
                        if (i - k >= 0 && j + k < size && map[i - k][j + k] == c) {
                            countDiagonalRU++;
                        }
                        if (i + k < size && j - k >= 0 && map[i + k][j - k] == c) {
                            countDiagonalLB++;
                        }
                        if (i + k < size && j + k < size && map[i + k][j + k] == c) {
                            countDiagonalRB++;
                        }
                        if (countDiagonalRB == winSize || countDiagonalLB == winSize || countDiagonalRU == winSize || countDiagonalLU == winSize) {
                            return true;
                        }
                    }
                }

                //tested vertical check
                if (map[j][i] == c) {
                    countV++;
                    if (countV == winSize) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == cNull) {
                    return false;
                }
            }
        }
        return true;
    }

    void aiTurn(char c) {
        int x = 0;
        int y = 0;
        int countH = 0;
        int countHNull = 0;
        int countV = 0;
        int countVNull = 0;
        int countDiagonalA = 0;
        int countDiagonalB = 0;
        int countDANull = 0;
        int countDBNull = 0;

        System.out.println("CPU TURN WITH [" + c + "]:");
        int[][] leed;
        // 1. Атакуем игрока
        for (int i = 0; i < winSize; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < winSize; j++) {
                //Вертикаль
                if (map[j][i] == c) countV++;
                else if (map[j][i] == cNull) countVNull++;
                if ((countV == winSize - 1) && (countVNull == 1)) {
                    //System.out.println("CPU ALMOST WIN! vert line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < winSize; k++) {
                        if (map[k][i] == cNull) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }
                //Горизонталь
                if (map[i][j] == c) countH++;
                else if (map[i][j] == cNull) countHNull++;
                if ((countH == winSize - 1) && (countHNull == 1)) {
                    //System.out.println("CPU ALMOST WIN! horiz line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < winSize; k++) {
                        if (map[i][k] == cNull) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

            }

            // Диагональ
            if (map[i][i] == c) countDiagonalA++;
            else if (map[i][i] == cNull) countDANull++;
            if ((countDiagonalA == winSize - 1) && (countDANull == 1)) {
                //System.out.println("CPU ALMOST WIN! diagA line \\");
                for (int j = 0; j < winSize; j++) {
                    if (map[j][j] == cNull) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // Диагональ
            if (map[i][winSize - 1 - i] == c) countDiagonalB++;
            else if (map[i][winSize - 1 - i] == cNull) countDBNull++;
            if ((countDiagonalB == winSize - 1) && (countDBNull == 1)) {
                //System.out.println("CPU ALMOST WIN! diagB line /");
                for (int j = 0; j < winSize; j++) {
                    if (map[j][winSize - 1 - j] == cNull) {
                        map[j][winSize - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        countH = 0;
        countHNull = 0;
        countV = 0;
        countVNull = 0;
        countDiagonalA = 0;
        countDiagonalB = 0;
        countDANull = 0;
        countDBNull = 0;

        // 2. локируем пользователя
        for (int i = 0; i < winSize; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < winSize; j++) {
                //Вертикаль
                if (map[j][i] == player) countV++;
                else if (map[j][i] == cNull) countVNull++;
                if ((countV == winSize - 1) && (countVNull == 1)) {
                    //System.out.println("WARNING FOR CPU! vert line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < winSize; k++) {
                        if (map[k][i] == cNull) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }
                //Горизонталь
                if (map[i][j] == player) countH++;
                else if (map[i][j] == cNull) countHNull++;
                if ((countH == winSize - 1) && (countHNull == 1)) {
                    //System.out.println("WARNING FOR CPU! horiz line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < winSize; k++) {
                        if (map[i][k] == cNull) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

            }

            // Диагональ
            if (map[i][i] == player) countDiagonalA++;
            else if (map[i][i] == cNull) countDANull++;
            if ((countDiagonalA == winSize - 1) && (countDANull == 1)) {
                //System.out.println("WARNING FOR CPU! diagA line \\");
                for (int j = 0; j < winSize; j++) {
                    if (map[j][j] == cNull) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // Диагональ
            if (map[i][winSize - 1 - i] == player) countDiagonalB++;
            else if (map[i][winSize - 1 - i] == cNull) countDBNull++;
            if ((countDiagonalB == winSize - 1) && (countDBNull == 1)) {
                //System.out.println("WARNING FOR CPU! diagB line /");
                for (int j = 0; j < winSize; j++) {
                    if (map[j][winSize - 1 - j] == cNull) {
                        map[j][winSize - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        // 3. чекаем центр карты
        if (!(size % 2 == 0)) {
            int center = (((size + 1) / 2) - 1);
            if (map[center][center] == cNull) {
                map[center][center] = c;
                return;
            }
        }


        if (map[0][0] == cNull) {
            map[0][0] = c;
            return;
        }
        if (map[0][map.length - 1] == cNull) {
            map[0][map.length - 1] = c;
            return;
        }
        if (map[map.length - 1][0] == cNull) {
            map[map.length - 1][0] = c;
            return;
        }
        if (map[map.length - 1][map.length - 1] == cNull) {
            map[map.length - 1][map.length - 1] = c;
            return;
        }

        // 5. рандом
        //System.out.println("AI random");
        do {
            x = r.nextInt(size);
            y = r.nextInt(size);
        } while (!isCellValid(x, y));
        map[y][x] = c;
        System.out.println("AI X: " + (x + 1) + " Y: " + (y + 1));
    }
}
