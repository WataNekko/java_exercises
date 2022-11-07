import java.util.Scanner;

public class Digits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n <= 1) {
                System.out.println(1);
                continue;
            }

            // Kamenetsky formula thingy
            double x = (n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) / 2.0);

            System.out.println((long) (Math.floor(x)) + 1);
        }

        scanner.close();
    }

}
