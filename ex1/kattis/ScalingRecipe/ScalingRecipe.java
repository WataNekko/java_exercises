
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Scaling Recipe
 * Link: https://open.kattis.com/contests/mjt68e/problems/scalingrecipe
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.Scanner;

public class ScalingRecipe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(scanner.nextInt() * y / x);
        }

        scanner.close();
    }

}