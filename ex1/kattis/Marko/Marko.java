import java.util.Map;
import java.util.Scanner;

public class Marko {
    public static void main(String[] args) {
        // Store value a...z in T9_input as 2..9
        Map<Character, Character> t9Input = Map.ofEntries(
                Map.entry('a', '2'),
                Map.entry('b', '2'),
                Map.entry('c', '2'),
                Map.entry('d', '3'),
                Map.entry('e', '3'),
                Map.entry('f', '3'),
                Map.entry('g', '4'),
                Map.entry('h', '4'),
                Map.entry('i', '4'),
                Map.entry('j', '5'),
                Map.entry('k', '5'),
                Map.entry('l', '5'),
                Map.entry('m', '6'),
                Map.entry('n', '6'),
                Map.entry('o', '6'),
                Map.entry('p', '7'),
                Map.entry('q', '7'),
                Map.entry('r', '7'),
                Map.entry('s', '7'),
                Map.entry('t', '8'),
                Map.entry('u', '8'),
                Map.entry('v', '8'),
                Map.entry('w', '9'),
                Map.entry('z', '9'),
                Map.entry('y', '9'),
                Map.entry('x', '9'));

        Scanner scan = new Scanner(System.in);
        int wordNumber = scan.nextInt();
        String[] wordArray = new String[wordNumber];

        for (int i = 0; i < wordNumber; i++) {
            // add word in to wordArray
            wordArray[i] = scan.next();
        }

        String inputNumber = scan.next();
        scan.close();

        int count = 0;
        for (int i = 0; i < wordNumber; i++) {
            boolean equal = true;
            if (wordArray[i].length() != inputNumber.length())
                continue;
            // Check if inputNumber is resemble to the word in wordArray
            for (int j = 0; j < inputNumber.length(); j++) {
                // if it is not equal set equal to false so that count can not increment
                if (t9Input.get(wordArray[i].charAt(j)) != inputNumber.charAt(j)) {
                    equal = false;
                    break;
                }
            }
            // if equal is true count will increment
            if (equal)
                count++;
        }

        System.out.println(count);
    }
}