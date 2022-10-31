import java.util.Scanner;

public class Sok {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bought = new int[3];
        int[] recipe = new int[3];
        for (int i = 0; i < 3; i++) {
            bought[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            recipe[i] = scanner.nextInt();
        }
        scanner.close();

        double minRatio = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            double ratio = bought[i] / (double) recipe[i];
            if (ratio < minRatio) {
                minRatio = ratio;
            }
        }
        for (int i = 0; i < 3; i++) {
            double used = recipe[i] * minRatio;
            System.out.print((bought[i] - used) + " ");
        }
    }

}
