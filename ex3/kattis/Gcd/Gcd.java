import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Gcd {

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, Math.abs(a - b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        HashSet<Integer> gcd = new HashSet<>();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < n; i++) {
            var tmp = arr[i];
            gcd.add(tmp);

            for (int j = i + 1; j < n; j++) {
                tmp = gcd(tmp, arr[j]);
                gcd.add(tmp);
            }
        }

        System.out.println(gcd.size());
    }

}