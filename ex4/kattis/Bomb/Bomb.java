import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Bomb {

    public static void main(String[] args) {
        var toNumber = Map.of(
                "**** ** ** ****", 0,
                "  *  *  *  *  *", 1,
                "***  *****  ***", 2,
                "***  ****  ****", 3,
                "* ** ****  *  *", 4,
                "****  ***  ****", 5,
                "****  **** ****", 6,
                "***  *  *  *  *", 7,
                "**** ***** ****", 8,
                "**** ****  ****", 9);

        Scanner scanner = new Scanner(System.in);

        StringBuilder[] numBuilders = null;
        int n = 0;
        for (int i = 0; i < 5; i++) {
            String line = scanner.nextLine();

            if (numBuilders == null) {
                n = line.length() / 4 + 1;
                numBuilders = new StringBuilder[n];
                for (int j = 0; j < n; j++) {
                    numBuilders[j] = new StringBuilder(15);
                }
            }

            for (int j = 0; j < n; j++) {
                numBuilders[j].append(line.substring(j * 4, j * 4 + 3));
            }
        }

        var num = Arrays.stream(numBuilders)
                .map(StringBuilder::toString)
                .map(toNumber::get)
                .reduce(0, (acc, digit) -> (acc != null && digit != null)
                        ? acc * 10 + digit
                        : null);

        System.out.println(
                (num != null && num % 6 == 0)
                        ? "BEER!!"
                        : "BOOM!!");

        scanner.close();
    }

}
