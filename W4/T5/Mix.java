import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Mix {

    static boolean isSameText(String a, String b) {
        String[] arr1 = a.split("\\s");
        String[] arr2 = b.split("\\s");
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr2.length; i++) {
            String str1 = arr1[i];
            String str2 = arr2[i];
            if (str1.length() != str2.length()
                    || str1.charAt(0) != str1.charAt(0)
                    || str1.charAt(str1.length() - 1) != str2.charAt(str2.length() - 1)) {
                return false;
            }

            Map<Character, Integer> count1 = new HashMap<>();
            Map<Character, Integer> count2 = new HashMap<>();
            for (int j = 1; j < str1.length() - 1; j++) {
                Character ch1 = str1.charAt(j);
                count1.put(ch1, count1.getOrDefault(ch1, 0) + 1);

                Character ch2 = str2.charAt(j);
                count2.put(ch2, count2.getOrDefault(ch2, 0) + 1);
            }
            if (!count1.equals(count2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        String text1 = Files.readString(Path.of("text1.in"));
        String text2 = Files.readString(Path.of("text2.txt"));

        System.out.println(isSameText(text1, text2) ? "YES" : "NO");
    }
}