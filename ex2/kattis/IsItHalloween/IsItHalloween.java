import java.util.Scanner;

public class IsItHalloween {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        System.out.println(
                date.equals("OCT 31") || date.equals("DEC 25")
                        ? "yup"
                        : "nope");
        scanner.close();
    }

}
