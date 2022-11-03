import java.util.ArrayList;
import java.util.Scanner;

public class RailroadMap {

    static Station[] stations;

    static class Station {
        ArrayList<Railroad> to;
        Railroad from;

        Station() {
            this.to = new ArrayList<>();
        }

        boolean isRemovable() {
            // exactly one incoming and one outgoing edge
            return this.to.size() == 1 && Railroad.isValid(this.from);
        }

        void remove() {
            var to = this.to.get(0);
            this.from.length += to.length;
            this.from.b = to.b;
            if (Railroad.isValid(stations[to.b].from)) {
                stations[to.b].from = this.from;
            }

            this.from = null;
            this.to.clear();
        }
    }

    static class Railroad {
        int a;
        int b;
        int length;

        Railroad(int a, int b, int length) {
            this.a = a;
            this.b = b;
            this.length = length;
        }

        static boolean isValid(Railroad road) {
            return road != null && road.length >= 0;
        }

        void print() {
            System.out.println((this.a + 1) + " " + (this.b + 1) + " " + this.length);
        }
    }

    final static Railroad invalidRoad = new Railroad(-1, -1, -1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int stationCount = scanner.nextInt();
            int railroadCount = scanner.nextInt();

            stations = new Station[stationCount];
            for (int j = 0; j < railroadCount; j++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                int length = scanner.nextInt();

                if (stations[a] == null) {
                    // init
                    stations[a] = new Station();
                }
                if (stations[b] == null) {
                    // init
                    stations[b] = new Station();
                }

                Railroad road = new Railroad(a, b, length);

                stations[a].to.add(road);
                if (stations[b].from == null) {
                    // uninitialized -> add one incoming edge
                    stations[b].from = road;
                } else {
                    // more than one incoming edge -> mark as invalid for removal
                    stations[b].from = invalidRoad;
                }
            } // input railroads

            for (int j = 0; j < stationCount; j++) {
                // remove redundant stations
                if (stations[j].isRemovable()) {
                    stations[j].remove();
                    stations[j] = null;
                    railroadCount--;
                }
            }

            // output
            System.out.println(railroadCount);

            for (var station : stations) {
                if (station == null)
                    continue;

                for (var road : station.to) {
                    road.print();
                }
            }
            System.out.println();

        } // test cases

        scanner.close();
    }

}