import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Advanced Object Oriented Programming with Java, WS 2022
 * Problem: False Sense of Security
 * Link: https://open.kattis.com/contests/mjt68e/problems/falsesecurity
 *
 * @author Baba Alimou Barry
 * @author Phi Dinh Van Toan
 * @author Quan Nguyen Le Anh
 */

public class FalseSenseOfSecurity {

    public static void main(String[] args) {
        var charToMorse = getMorseMap();
        var morseToChar = reverseMap(charToMorse);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String in = scanner.nextLine();
            String morseString = "";
            ArrayList<Character> lenList = new ArrayList<>();

            // encode to morse
            for (int i = 0; i < in.length(); i++) {
                String morse = charToMorse.get(in.charAt(i));
                lenList.add((char) morse.length());
                morseString += morse;
            }

            // decode in reverse order
            int currPos = 0;
            for (int i = lenList.size() - 1; i >= 0; i--) {
                char morseLen = lenList.get(i);
                String morse = morseString.substring(currPos, currPos + morseLen);
                currPos += morseLen;

                System.out.print(morseToChar.get(morse));
            }
            System.out.println();

        }

        scanner.close();
    }

    static Map<Character, String> getMorseMap() {
        return Map.ofEntries(
                Map.entry('A', ".-"),
                Map.entry('H', "...."),
                Map.entry('O', "---"),
                Map.entry('V', "...-"),
                Map.entry('B', "-..."),
                Map.entry('I', ".."),
                Map.entry('P', ".--."),
                Map.entry('W', ".--"),
                Map.entry('C', "-.-."),
                Map.entry('J', ".---"),
                Map.entry('Q', "--.-"),
                Map.entry('X', "-..-"),
                Map.entry('D', "-.."),
                Map.entry('K', "-.-"),
                Map.entry('R', ".-."),
                Map.entry('Y', "-.--"),
                Map.entry('E', "."),
                Map.entry('L', ".-.."),
                Map.entry('S', "..."),
                Map.entry('Z', "--.."),
                Map.entry('F', "..-."),
                Map.entry('M', "--"),
                Map.entry('T', "-"),
                Map.entry('G', "--."),
                Map.entry('N', "-."),
                Map.entry('U', "..-"),
                Map.entry('_', "..--"),
                Map.entry(',', ".-.-"),
                Map.entry('.', "---."),
                Map.entry('?', "----"));
    }

    static Map<String, Character> reverseMap(Map<Character, String> map) {
        return map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Entry::getValue, Entry::getKey));
    }

}