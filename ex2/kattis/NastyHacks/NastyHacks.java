import java.util.Scanner;

public class NastyHacks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int profitWithoutAds = scanner.nextInt();
            int profitWithAds = scanner.nextInt() - scanner.nextInt();
            System.out.println(
                    profitWithAds > profitWithoutAds
                            ? "advertise"
                            : profitWithAds == profitWithoutAds
                                    ? "does not matter"
                                    : "do not advertise");
        }

        scanner.close();
    }
}
