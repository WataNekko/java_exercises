import java.util.Scanner;

/**
 * PizzaCrust
 */
public class PizzaCrust {

    static double circleArea(int r) {
        return Math.PI * r * r;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(circleArea(r - c) / circleArea(r) * 100);
        scanner.close();
    }

}