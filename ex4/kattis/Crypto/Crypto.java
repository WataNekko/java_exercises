import java.util.Scanner;

public class Crypto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int mod = i % 3;
            if (mod == 0) {
                if (s.charAt(i) != 'P')
                    count++;
            } else if (mod == 1) {
                if (s.charAt(i) != 'E')
                    count++;
            } else {
                if (s.charAt(i) != 'R')
                    count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }

}
