import java.util.Map;
import java.util.Scanner;

public class Bela {

    public static void main(String[] args) {
        Map<Character, int[]> scores = Map.of(
                'A', new int[] { 11, 11 },
                'K', new int[] { 4, 4 },
                'Q', new int[] { 3, 3 },
                'J', new int[] { 20, 2 },
                'T', new int[] { 10, 10 },
                '9', new int[] { 14, 0 },
                '8', new int[] { 0, 0 },
                '7', new int[] { 0, 0 });

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt() * 4;
        char suit = scanner.next().charAt(0);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            String card = scanner.next();
            sum += scores.get(card.charAt(0))[card.charAt(1) == suit ? 0 : 1];
        }
        System.out.println(sum);

        scanner.close();
    }
}