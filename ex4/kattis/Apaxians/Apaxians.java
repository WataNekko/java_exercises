import java.util.Scanner;

public class Apaxians {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next().replaceAll("(.)\\1+", "$1"));
        scanner.close();
    }

}
