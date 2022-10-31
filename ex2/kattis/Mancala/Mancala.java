import java.util.Scanner;

public class Mancala {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();

            System.out.printf("%d ", k);
            solve(scanner.nextInt());
        }

        scanner.close();
    }

    static void solve(int totalCounters) {
        int[] board = new int[80];
        int lastNonZeroBin = -1;

        for (int i = 0; i < totalCounters; i++) {
            int counters = 1;

            int j = 0;
            while (board[j] != 0) {
                board[j]--;
                counters++;
                j++;
            }

            board[j] = counters;
            lastNonZeroBin = Math.max(lastNonZeroBin, j);
        }

        System.out.println(lastNonZeroBin + 1);
        print(board, lastNonZeroBin);
    }

    static void print(int[] board, int lastNonZeroBin) {
        for (int i = 0; i <= lastNonZeroBin; i++) {
            System.out.printf("%d ", board[i]);
            if (i % 10 == 9) {
                // print only 10 per line
                System.out.println();
            }
        }
        if (lastNonZeroBin % 10 != 0) {
            System.out.println();
        }
    }

}