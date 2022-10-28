
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Cudoviste
 * Link: https://open.kattis.com/contests/mjt68e/problems/cudoviste
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.Scanner;

public class Cudoviste {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // read input city map
        String[] map = new String[rows];
        for (int i = 0; i < rows; i++) {
            map[i] = scanner.next();
        }

        int[] output = new int[5];

        // brute force through all positions
        for (int i = 0; i < rows - 1; i++) {
            pos: for (int j = 0; j < cols - 1; j++) {

                // consider the space the truck occupies
                int numCarsInTheWay = 0;
                for (int r = i; r < i + 2; r++) {
                    for (int c = j; c < j + 2; c++) {
                        switch (map[r].charAt(c)) {
                            case 'X':
                                numCarsInTheWay++; // squash this car :>>
                                break;
                            case '#':
                                // a building prevents parking the truck in this position
                                continue pos; // consider next position
                        }
                    }
                }

                // increment the case where `numCarsInTheWay` are squashed
                output[numCarsInTheWay]++;
            }
        }

        // output result
        for (int i = 0; i < 5; i++) {
            System.out.println(output[i]);
        }
    }

}