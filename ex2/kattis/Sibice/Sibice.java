import java.util.Scanner;

public class Sibice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        double diag = Math.sqrt(w * w + h * h);

        for (int i = 0; i < n; i++) {
            System.out.println(scanner.nextInt() <= diag ? "DA" : "NE");
        }
        scanner.close();
    }

}
