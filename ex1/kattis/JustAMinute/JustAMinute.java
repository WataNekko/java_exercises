
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Just a Minute
 * Link: https://open.kattis.com/contests/mjt68e/problems/justaminute
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh 
 */

import java.util.Scanner;

public class JustAMinute {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumMinDisplayed = 0;
        int sumSecWaited = 0;

        for (int i = 0, n = scanner.nextInt(); i < n; i++) {
            sumMinDisplayed += scanner.nextInt();
            sumSecWaited += scanner.nextInt();
        }

        double aveSlMinute = sumSecWaited / (sumMinDisplayed * 60.0);
        System.out.println(aveSlMinute > 1 ? aveSlMinute : "measurement error");

        scanner.close();
    }

}