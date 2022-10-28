
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Identifying Map Tiles
 * Link: https://open.kattis.com/contests/mjt68e/problems/maptiles2
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.Scanner;

public class IdentifyingMapTiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.next();
        scanner.close();
        int len = in.length();

        int xLo = 0;
        int xHi;
        int yLo = 0;
        int yHi;
        xHi = yHi = (int) Math.pow(2, len);

        // Each digit in the quadkey determines whether the x or y coordinate lies on
        // the lower or higher end on each zoom level.
        // We use an algorithm similar to binary search to determines the coordinate.
        for (int i = 0; i < len; i++) {
            char digit = in.charAt(i);

            if (digit == '0' || digit == '2') {
                // x coord to the left of the partition
                xHi = (xLo + xHi) / 2;
            } else {
                // to the right
                xLo = (xLo + xHi) / 2;
            }

            if (digit == '0' || digit == '1') {
                // y coord to the top of the partition
                yHi = (yLo + yHi) / 2;
            } else {
                // to the bottom
                yLo = (yLo + yHi) / 2;
            }
        }

        // at the end, xLo and yLo are the corresponding coordinates
        System.out.printf("%d %d %d", len, xLo, yLo);
    }

}