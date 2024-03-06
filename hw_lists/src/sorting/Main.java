package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        runBubbleSort();
        System.out.println("*******************");
        runInsertSort();
    }

    private static void runBubbleSort() {
        System.out.println("Bubble sorting:");
        Integer [] myIntArray = SortingUtil.generateRandomArray(10, 0, 100);

        System.out.println("Initial array");
        System.out.println(Arrays.toString(myIntArray));

        System.out.println("Sorted array");
        System.out.println(Arrays.toString(SortingUtil.bubbleSort(myIntArray)));
    }

    private static void runInsertSort() {
        System.out.println("Insert sorting:");
        Integer [] myIntArray = SortingUtil.generateRandomArray(10, 0, 100);

        System.out.println("Initial array");
        System.out.println(Arrays.toString(myIntArray));

        System.out.println("Sorted array");
        System.out.println(Arrays.toString(sorting.SortingUtil.insertSort(myIntArray)));
    }
}
