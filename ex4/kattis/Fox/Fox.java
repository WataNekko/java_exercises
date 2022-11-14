import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Fox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            var recording = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
            while (true) {
                String s = scanner.nextLine();
                if (s.endsWith("?")) {
                    break;
                }
                String sound = s.split(" ")[2];
                recording.removeIf((str) -> str.equals(sound));
            }
            System.out.println(String.join(" ", recording));
        }
        scanner.close();
    }

}