
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Yoda
 * Link: https://open.kattis.com/contests/mjt68e/problems/yoda
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.Scanner;

public class Yoda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input integers
        int[] in = { scanner.nextInt(), scanner.nextInt() };
        int[] out = { 0, 0 }; // output var
        int[] placeValues = { 1, 1 }; // next place value of the output digits
        scanner.close();

        do {
            // retrieve the least significant digits
            int[] digits = { in[0] % 10, in[1] % 10 };
            in[0] /= 10;
            in[1] /= 10;

            // add a digit to the output if it's larger or equal to the other
            if (digits[0] >= digits[1]) {
                out[0] += placeValues[0] * digits[0];
                placeValues[0] *= 10; // increase place value for next use
            }
            if (digits[1] >= digits[0]) {
                out[1] += placeValues[1] * digits[1];
                placeValues[1] *= 10; // increase place value for next use
            }

        } while (in[0] != 0 || in[1] != 0); // repeat until all digits are read

        // The placeValue variable acts as an indicator to whether every digits
        // of a number fell out, when which placeValue is never increased and
        // stay at the default value of 1.
        System.out.println(placeValues[0] == 1 ? "YODA" : out[0]);
        System.out.println(placeValues[1] == 1 ? "YODA" : out[1]);
    }

}