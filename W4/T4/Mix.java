import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Mix {

    static <E> int indexOf(List<E> list, Predicate<E> predicate) {
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i)))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        var chars = Files.readString(Path.of("text.in"))
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        var sub = chars.subList(0, chars.size());
        while (true) {
            int start = indexOf(sub, ch -> !Character.isWhitespace(ch));
            if (start == -1) {
                break;
            }

            sub = sub.subList(start, sub.size());
            int end = indexOf(sub, Character::isWhitespace);
            end = end != -1 ? end : sub.size();

            Collections.shuffle(sub.subList(1, Math.max(end - 1, 1)));

            sub = sub.subList(Math.min(end + 1, sub.size()), sub.size());
        }

        try (FileWriter writer = new FileWriter("text.out")) {
            for (var ch : chars) {
                writer.write(ch);
            }
        }
    }
}