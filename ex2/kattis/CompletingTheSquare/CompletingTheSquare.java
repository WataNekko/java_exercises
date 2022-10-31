import java.util.ArrayList;
import java.util.Scanner;

public class CompletingTheSquare {
    static class Vector2 {
        int x;
        int y;

        Vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dot(Vector2 other) {
            return this.x * other.x + this.y * other.y;
        }

        Vector2 sub(Vector2 other) {
            return new Vector2(this.x - other.x, this.y - other.y);
        }

        Vector2 add(Vector2 other) {
            return new Vector2(this.x + other.x, this.y + other.y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vector2[] points = new Vector2[3];
        for (int i = 0; i < 3; i++) {
            points[i] = new Vector2(scanner.nextInt(), scanner.nextInt());
        }
        scanner.close();

        for (int i = 0; i < 3; i++) {
            ArrayList<Vector2> vectors = new ArrayList<>(2);
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    // get the 2 outward vectors from point `points[i]`
                    vectors.add(points[j].sub(points[i]));
                }
            }

            Vector2 v1 = vectors.get(0);
            Vector2 v2 = vectors.get(1);
            if (v1.dot(v2) == 0) {
                // dot product == 0 -> right angle -> find the final point
                Vector2 finalPoint = points[i].add(v1).add(v2);
                System.out.println(finalPoint.x + " " + finalPoint.y);
                return; // program finished
            }
        }
    }
}
