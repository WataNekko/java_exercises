import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Music {

    static class NoteInfo {
        int pos;
        int duration;

        NoteInfo(int pos, int duration) {
            this.pos = pos;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return pos + " " + duration;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<Character, ArrayList<NoteInfo>> song = new HashMap<>();
        int pos = 0;
        for (int i = 0; i < n; i++) {
            String note = scanner.next();
            String durStr = note.substring(1);

            // get pitch and duration
            Character pitch = note.charAt(0);
            int duration = durStr.isEmpty() ? 1 : Integer.parseInt(durStr);

            // init note list for the pitch
            if (!song.containsKey(pitch)) {
                song.put(pitch, new ArrayList<>());
            }
            var notes = song.get(pitch);

            // process new note
            notes.add(new NoteInfo(pos, duration));
            pos += duration + 1;
        }

        for (var pitch : "GFEDCBAgfedcba".toCharArray()) {
            System.out.print(pitch + ": ");

            char fill;
            switch (pitch) {
                case 'F':
                case 'D':
                case 'B':
                case 'g':
                case 'e':
                case 'a':
                    fill = '-';
                    break;
                default:
                    fill = ' ';
            }

            int prevPos = 0;
            if (song.containsKey(pitch)) {
                var notes = song.get(pitch);
                for (var note : notes) {
                    int gap = note.pos - prevPos;
                    for (int i = 0; i < gap; i++) {
                        System.out.print(fill);
                    }
                    for (int i = 0; i < note.duration; i++) {
                        System.out.print('*');
                    }
                    prevPos = note.pos + note.duration;
                }
            }
            int gapToFinalPos = (pos - 1) - prevPos;
            for (int i = 0; i < gapToFinalPos; i++) {
                System.out.print(fill);
            }
            System.out.println();
        }

        scanner.close();
    }

}