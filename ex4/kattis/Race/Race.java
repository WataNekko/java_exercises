import java.util.Map;
import java.util.Scanner;

public class Race {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        var map = Map.of(
                (int) ' ', 'Z' + 1,
                (int) '\'', 'Z' + 2);
        double distBetweenConsecutiveStops = Math.PI * 60 / 28;

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            int stopsMoved = 0;
            for (int j = 1; j < str.length(); j++) {
                int a = str.charAt(j - 1);
                a = map.getOrDefault(a, a);
                int b = str.charAt(j);
                b = map.getOrDefault(b, b);

                int diff = Math.abs(a - b);
                stopsMoved += Math.min(diff, Math.abs(diff - 28));
            }
            double timeMoved = stopsMoved * distBetweenConsecutiveStops / 15;
            System.out.println(timeMoved + str.length() /* plus pickup time */);
        }

        scanner.close();
    }

}
