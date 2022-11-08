import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Gcd {

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, Math.abs(a - b));
    }

    static ArrayList<Integer> gcd(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < list.size(); i++) {
            set.add(gcd(list.get(i - 1), list.get(i)));
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();

        HashSet<Integer> gcd = new HashSet<>(list);
        while (list.size() > 1) {
            list = gcd(list);
            gcd.addAll(list);
        }

        System.out.println(gcd.size());
    }

}