import java.util.Scanner;

public class QuickEstimates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(scanner.next().length());
        }

        scanner.close();
    }

}
