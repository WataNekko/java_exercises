import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int i = 0;
        for (; i < n; i++) {
            int tmp = t - scanner.nextInt();
            if (tmp >= 0) {
                // possible to do this task in time
                t = tmp; // update remaining time
            } else {
                // can't do any more task
                break;
            }
        }

        System.out.println(i);
        scanner.close();
    }

}
