import java.util.Scanner;

public class Welcome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String welcum = "welcome to code jam";
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            final String t = scanner.nextLine();
            int welcumLen = welcum.length() + 1;
            int tLen = t.length() + 1;

            // init matrix
            int[] dp = new int[welcumLen * tLen];
            for (int j = 0; j < tLen; j++) {
                dp[j] = 1;
            }

            // dynamic programming
            for (int j = 1; j < welcumLen; j++) {
                for (int k = 1; k < tLen; k++) {
                    dp[j * tLen + k] = dp[j * tLen + (k - 1)] + (welcum.charAt(j - 1) == t.charAt(k - 1)
                            ? dp[(j - 1) * tLen + (k - 1)]
                            : 0);
                }
            }
            System.out.printf("Case #%d: %04d\n", i, dp[welcumLen * tLen - 1] % 10000);
        }

        scanner.close();
    }

}