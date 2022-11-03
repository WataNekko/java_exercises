import java.util.Scanner;

public class NumberFun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (a + b == c || Math.abs(a - b) == Math.abs(c) || a * b == c || a / (double) b == c
                    || b / (double) a == c) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
        scanner.close();
    }

}
