
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Misa
 * Link: https://open.kattis.com/contests/mjt68e/problems/misa
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.Scanner;

public class Misa {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int s = scanner.nextInt();

        String[] seating = new String[r];
        for (int i = 0; i < r; i++) {
            seating[i] = scanner.next();
        }

        scanner.close();

        int othersHandshakeCount = 0;
        int mirkosHandshakeCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                int handshakeCountAtThisPos = getNumOfHandshakeAt(i, j, seating, r, s);
                if (seating[i].charAt(j) == 'o') {
                    othersHandshakeCount += handshakeCountAtThisPos;
                } else {
                    mirkosHandshakeCount = Math.max(
                            mirkosHandshakeCount, handshakeCountAtThisPos);
                }
            }
        }

        othersHandshakeCount /= 2; // remove repetitions
        System.out.println(othersHandshakeCount + mirkosHandshakeCount);

    }

    static int getNumOfHandshakeAt(int atRow, int atCol, String[] seating, int nRows, int nCols) {
        int handshake = 0;
        for (int r = Math.max(atRow - 1, 0), n1 = Math.min(atRow + 2, nRows); r < n1; r++) {
            for (int c = Math.max(atCol - 1, 0), n2 = Math.min(atCol + 2, nCols); c < n2; c++) {
                if (r == atRow && c == atCol) {
                    continue;
                }
                if (seating[r].charAt(c) == 'o') {
                    handshake++;
                }
            }
        }
        return handshake;
    }

}