import java.util.HashMap;
import java.util.Scanner;

public class Music {

    public static void main(String[] args) {
        String[] notes = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
        HashMap<String, Integer> noteToPos = new HashMap<>();
        for (int i = 0; i < notes.length; i++) {
            noteToPos.put(notes[i], i);
        }

        short majorScale = 0b101011010101;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        short notesMask = 0b0;
        for (int i = 0; i < n; i++) {
            int pos = noteToPos.get(scanner.next());
            notesMask |= 0b1 << (11 - pos);
        }
        scanner.close();

        String out = "";
        for (int i = 0; i < notes.length; i++) {
            String majorName = notes[i];
            if ((majorScale | notesMask) == majorScale) {
                out += majorName + " ";
            }
            majorScale = (short) (majorScale >> 1 | majorScale << 11 & 0x0FFF);
        }
        System.out.println(out.isEmpty() ? "none" : out);
    }

}
