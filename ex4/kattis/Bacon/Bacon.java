import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bacon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n == 0)
                break;

            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] order = scanner.nextLine().split(" ");
                for (int j = 1; j < order.length; j++) {
                    if (map.get(order[j]) == null)
                        map.put(order[j], new ArrayList<>());

                    map.get(order[j]).add(order[0]);
                }
            }
            map.entrySet()
                    .stream()
                    .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                    .forEach(entry -> {
                        System.out.println(
                                entry.getKey() + " " + entry.getValue()
                                        .stream()
                                        .sorted()
                                        .collect(Collectors.joining(" ")));
                    });
            System.out.println();
        }
        scanner.close();
    }

}
