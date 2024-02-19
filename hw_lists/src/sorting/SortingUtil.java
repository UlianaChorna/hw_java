package sorting;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class SortingUtil {

    public static Integer[] generateRandomArray(int size, int min, int max) {
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            // Generate random integer between min (inclusive) and max (exclusive)
            arr[i] = rand.nextInt(max - min) + min;
        }
        return arr;
    }

    public static Integer [] bubbleSort(Integer [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int x = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = x;
                }
            }
        }

        return arr;

    }

    public static Integer [] insertSort(Integer [] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int x = arr[i];
            int j = i - 1;

            while (j >= 0 && x < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
                arr[j + 1] = x;
            }
        }
        return  arr;
    }
}
