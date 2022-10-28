
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Touchscreen Keyboard
 * Link: https://open.kattis.com/contests/mjt68e/problems/touchscreenkeyboard
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.LinkedList;
import java.util.Scanner;

public class TouchscreenKeyboard {

    static class Pair<T, U> {
        public T a;
        public U b;

        public Pair(T a, U b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // for each test case
        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            int spellCheckerSize = scanner.nextInt();

            LinkedList<Pair<String, Integer>> list = new LinkedList<>();
            for (int j = 0; j < spellCheckerSize; j++) {
                // calculate distance of the typed string and each spell checker entry
                // and add to a list for later sorting
                String entry = scanner.next();
                list.add(new Pair<String, Integer>(
                        entry,
                        getDistance(entry, input)));
            }

            // sort the list
            list.sort((var pair1, var pair2) -> {
                int cmpDist = Integer.compare(pair1.b, pair2.b);
                return cmpDist == 0
                        // sort alphabetically if have the same distance
                        ? pair1.a.compareTo(pair2.a)
                        : cmpDist;
            });

            // print output
            for (var entry : list) {
                System.out.println(entry.a + " " + entry.b);
            }
        }

        scanner.close();
    }

    static char[][] keyboard = {
            { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
            { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' },
            { 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };

    static int[] getKeyboardCoord(char ch) {
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                if (keyboard[i][j] == ch) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    static int getDistance(char a, char b) {
        int[] aCoord = getKeyboardCoord(a);
        int[] bCoord = getKeyboardCoord(b);
        return Math.abs(aCoord[0] - bCoord[0]) +
                Math.abs(aCoord[1] - bCoord[1]);
    }

    static int getDistance(String a, String b) {
        int total = 0;
        for (int i = 0; i < a.length(); i++) {
            total += getDistance(a.charAt(i), b.charAt(i));
        }
        return total;
    }

}