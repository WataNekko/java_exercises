import java.util.Scanner;

public class Plania {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int tmp = getNumSidePointsStored(n);
        System.out.println(tmp * tmp);

        scanner.close();
    }

    static int getNumSidePointsStored(int i) {
        if (i == 0)
            return 2;
        return getNumSidePointsStored(i - 1) * 2 - 1;
    }

}