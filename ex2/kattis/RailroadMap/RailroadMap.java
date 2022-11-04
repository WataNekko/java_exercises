import java.util.Scanner;

public class RailroadMap {

    static class Railroad {
        final int[] ss; // stations that the railroad connects
        int length;

        Railroad(int a, int b, int length) {
            this.ss = new int[] { a, b };
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            // for each test case
            int stationCount = scanner.nextInt();
            int railroadCount = scanner.nextInt();

            // used to store railroad segments
            Railroad[] roads = new Railroad[railroadCount];

            // used to store the number of occurences of a station
            int[] occurenceCountArr = new int[stationCount];

            // store the first occurence of a station for later removal of
            // that station if the number of occurences of that station is 2
            int[] firstOccurenceArr = new int[stationCount];

            for (int j = 0; j < railroadCount; j++) {
                // input railroads
                var road = new Railroad(
                        scanner.nextInt() - 1,
                        scanner.nextInt() - 1,
                        scanner.nextInt());
                roads[j] = road;

                for (int k = 0; k < 2; k++) {
                    int s = road.ss[k];
                    if (++occurenceCountArr[s] == 1) {
                        firstOccurenceArr[s] = j;
                    }
                }
            }

            int newRailroadCount = railroadCount;
            for (int j = railroadCount - 1; j >= 0; j--) {
                // removal of stations
                var road = roads[j];

                for (int k = 0; k < 2; k++) {
                    int s = road.ss[k];

                    if (occurenceCountArr[s] == 2) {
                        // remove station `s`
                        int s_ = road.ss[(k + 1) % 2]; // the other station
                        int firstIndex = firstOccurenceArr[s];
                        Railroad first = roads[firstIndex];

                        replace(first.ss, s, s_);
                        first.length += road.length;
                        road.length = 0; // mark as invalid (removed)

                        firstOccurenceArr[s_] = Math.min(
                                firstOccurenceArr[s_],
                                firstIndex); // update first occurence index for `s_`

                        newRailroadCount--;

                        break;
                    }
                }
            }

            System.out.println(newRailroadCount);
            for (int j = 0; j < railroadCount; j++) {
                // output result
                var road = roads[j];

                if (road.length > 0) {
                    System.out.println((road.ss[0] + 1) + " " + (road.ss[1] + 1) + " " + road.length);
                }
            }
            System.out.println();

        } // test cases

        scanner.close();
    }

    static void replace(int[] arr, int a, int withB) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                arr[i] = withB;
                return;
            }
        }
    }

}