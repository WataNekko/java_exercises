import java.util.ArrayList;
import java.util.Scanner;

public class Parking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] costs = new int[4];
        for (int i = 1; i < costs.length; i++) {
            costs[i] = scanner.nextInt();
        }

        class Data {
            int time;
            boolean isArrival;

            Data(int time, boolean isArrival) {
                this.time = time;
                this.isArrival = isArrival;
            }
        }

        ArrayList<Data> data = new ArrayList<>(6);
        for (int i = 0; i < 3; i++) {
            data.add(new Data(scanner.nextInt(), true));
            data.add(new Data(scanner.nextInt(), false));
        }
        scanner.close();

        // sort the timestamps
        data.sort((var dat1, var dat2) -> Integer.compare(dat1.time, dat2.time));

        int totalCost = 0;
        int truckCount = 0;
        for (int i = 0; i < 5; i++) {
            Data d = data.get(i);
            Data dd = data.get(i + 1);

            if (d.isArrival) {
                truckCount++;
            } else {
                truckCount--;
            }

            totalCost += truckCount * (dd.time - d.time) * costs[truckCount];
        }

        System.out.println(totalCost);
    }

}
