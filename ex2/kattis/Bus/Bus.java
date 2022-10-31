import java.util.Scanner;

public class Bus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(getNumOfPassengers(scanner.nextInt()));
        }

        scanner.close();
    }

    static int getNumOfPassengers(int numOfStops) {
        // We have
        // nk = 0
        //
        // n1 = n0 / 2 - 0.5 ...
        // => n0 = (n1 + 0.5) * 2
        // = n1 * 2 + 1 ...

        if (numOfStops == 0)
            return 0;
        return getNumOfPassengers(numOfStops - 1) * 2 + 1;
    }

}