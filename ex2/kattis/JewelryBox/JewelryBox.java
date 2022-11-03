import java.util.Scanner;

public class JewelryBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // doing math to find the maximum of the function
            double sumXY = x + y;
            double prodXY = x * y;
            double sqrtD = Math.sqrt(16 * sumXY * sumXY - 48 * prodXY);
            double x1 = (4 * sumXY + sqrtD) / 24;
            double x2 = (4 * sumXY - sqrtD) / 24;

            System.out.println(Math.max(getVolume(x, y, x1), getVolume(x, y, x2)));
        }

        scanner.close();
    }

    static double getVolume(int x, int y, double h) {
        return (x - 2 * h) * (y - 2 * h) * h;
    }

}
