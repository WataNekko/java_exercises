import java.util.Scanner;

public class TakeTwoStones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt() % 2 == 0 ? "Bob" : "Alice");
        scanner.close();
    }

}
