import java.util.ArrayList;
import java.util.Scanner;

public class Symmetric {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        int i = 1;
        while ((n = scanner.nextInt()) != 0) {
            ArrayList<String> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add((int) Math.ceil(j / 2.0), scanner.next());
            }
            System.out.println("SET " + i++);
            list.forEach(System.out::println);
        }

        scanner.close();
    }

}
