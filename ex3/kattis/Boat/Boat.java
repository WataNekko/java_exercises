import java.util.HashSet;
import java.util.Scanner;

public class Boat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfParts = scanner.nextInt();
        int days = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        int i = 0;
        for (; i < days; i++) {
            set.add(scanner.next());
            if (set.size() == numOfParts)
                break;
        }
        scanner.close();
        System.out.println((i == days) ? "paradox avoided" : (i + 1));
    }

}
