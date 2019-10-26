import java.util.ArrayList;
import java.util.Scanner;

public class TruckTour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int gas = scanner.nextInt();
            int dist = scanner.nextInt();
            arrayList.add(new int[]{gas, dist});
        }

        System.out.println(check(arrayList, size));
    }

    public static int check(ArrayList<int[]> arrayList, int size) {
        int index = 0;
        int excess = 0;

        for (int i = 0; i < size; i++) {
            if (arrayList.get(i)[0] - arrayList.get(i)[1] + excess < 0) {
                index = i + 1;
                excess = 0;
            } else {
                excess += arrayList.get(i)[0] - arrayList.get(i)[1];

            }
        }
        return index;

    }
}
