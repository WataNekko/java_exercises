import java.util.Scanner;

public class BoundingRobots {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int w = scanner.nextInt();
            int l = scanner.nextInt();
            if (w == 0 && l == 0)
                // terminate
                break;

            int robotX = 0;
            int robotY = 0;
            int actualX = 0;
            int actualY = 0;

            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                char dir = scanner.next().charAt(0);
                int amount = scanner.nextInt();

                switch (dir) {
                    case 'u':
                        robotY += amount;
                        actualY = Math.max(0, Math.min(l - 1, actualY + amount));
                        break;
                    case 'd':
                        robotY -= amount;
                        actualY = Math.max(0, Math.min(l - 1, actualY - amount));
                        break;
                    case 'l':
                        robotX -= amount;
                        actualX = Math.max(0, Math.min(w - 1, actualX - amount));
                        break;
                    case 'r':
                        robotX += amount;
                        actualX = Math.max(0, Math.min(w - 1, actualX + amount));
                        break;
                }
            }

            System.out.println("Robot thinks " + robotX + " " + robotY);
            System.out.println("Actually at " + actualX + " " + actualY);
            System.out.println();
        }

        scanner.close();
    }

}