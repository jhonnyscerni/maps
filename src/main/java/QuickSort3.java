import java.util.Scanner;

public class QuickSort3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        quickSort(array, 0, array.length - 1);
    }


    static void quickSort(int[] array, int first, int last) {
        if (first >= last) {
            return;
        }
        int pivotIdx = partition(array, first, last);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        quickSort(array, first, pivotIdx - 1);
        quickSort(array, pivotIdx + 1, last);
    }


    static int partition(int[] array, int first, int last) {
        int pivotIdx = first;
        for (int i = first; i < last; i++) {
            if (array[i] <= array[last]) {
                int temp = array[i];
                array[i] = array[pivotIdx];
                array[pivotIdx] = temp;
                pivotIdx++;
            }
        }
        int temp = array[last];
        array[last] = array[pivotIdx];
        array[pivotIdx] = temp;

        return pivotIdx;
    }

}


