
/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: Eligibility
 * Link: https://open.kattis.com/contests/mjt68e/problems/eligibility
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

import java.util.Scanner;

public class Eligibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of test cases

        // for each test case
        for (int i = 0; i < n; i++) {
            // parse input
            String name = scanner.next();
            int studyYear = Integer.parseInt(scanner.next().substring(0, 4));
            int birthYear = Integer.parseInt(scanner.next().substring(0, 4));
            int numCourse = scanner.nextInt();

            // determine status
            String status = (studyYear >= 2010 || birthYear >= 1991)
                    ? "eligible"
                    : numCourse > 40 ? "ineligible" : "coach petitions";

            // output
            System.out.println(name + ' ' + status);
        }

        scanner.close();
    }

}