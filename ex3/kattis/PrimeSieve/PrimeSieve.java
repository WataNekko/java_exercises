import java.util.BitSet;
import java.util.Scanner;

public class PrimeSieve {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // prime sieve thingy
        BitSet notPrime = new BitSet(n + 1);
        notPrime.set(1);
        for (int p = 2; p * p <= n; p++) {
            if (!notPrime.get(p)) {
                for (int i = p * p; i <= n; i += p)
                    notPrime.set(i);
            }
        }

        System.out.println(n - notPrime.cardinality());

        for (int i = 0; i < q; i++) {
            System.out.println(notPrime.get(scanner.nextInt())
                    ? 0
                    : 1);
        }

        scanner.close();
    }

}
