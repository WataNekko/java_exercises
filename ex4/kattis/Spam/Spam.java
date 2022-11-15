import java.util.Scanner;

public class Spam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        double whitespace = s.chars().filter(ch -> ch == '_').count();
        double lowercase = s.chars().filter(Character::isLowerCase).count();
        double uppercase = s.chars().filter(Character::isUpperCase).count();
        double symbol = s.length() - whitespace - lowercase - uppercase;

        System.out.println(whitespace / s.length());
        System.out.println(lowercase / s.length());
        System.out.println(uppercase / s.length());
        System.out.println(symbol / s.length());

        scanner.close();
    }

}
