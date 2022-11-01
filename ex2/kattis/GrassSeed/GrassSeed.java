import java.util.Scanner;

public class GrassSeed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double c = scanner.nextDouble();
        int n = scanner.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            double w = scanner.nextDouble();
            double l = scanner.nextDouble();

            totalCost += c * w * l;
        }
        System.out.println(totalCost);

        scanner.close();
    }

}
