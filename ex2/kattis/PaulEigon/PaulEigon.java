import java.util.Scanner;

public class PaulEigon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        System.out.println(((p + q) / n) % 2 == 0 ? "paul" : "opponent");

        scanner.close();
    }

}
