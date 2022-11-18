import java.util.HashMap;
import java.util.Scanner;

public class Doors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        HashMap<String, Boolean> enteredList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boolean isEntering = scanner.next().equals("entry");
            String name = scanner.next();

            boolean isAnomaly = isEntering != !enteredList.getOrDefault(name, Boolean.FALSE);
            enteredList.put(name, isEntering);

            System.out.print(name);
            System.out.print(isEntering
                    ? " entered"
                    : " exited");
            System.out.println(isAnomaly
                    ? " (ANOMALY)"
                    : "");
        }

        scanner.close();
    }

}
