package list;

import sorting.SortingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer [] ints = SortingUtil.generateRandomArray(100, 0 , 100);
        System.out.println(Arrays.toString(ints));
        runPerformanceCheckArrayList(ints);
        System.out.println("******************");
        runPerformanceCheckLinkedList(ints);
        System.out.println("******************");
        runPerformanceCheckMyLinkedList(ints);
    }


    private static void runPerformanceCheckArrayList(Integer [] ints) {
        java.util.List<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, ints);


        long startTime = System.nanoTime();
        arrayList.add(11);
        long endTime = System.nanoTime();
        long addToEndAL = (endTime - startTime);


        startTime = System.nanoTime();
        arrayList.add(0, 0);
        endTime = System.nanoTime();
        long addToStartAL = (endTime - startTime);

        int index = arrayList.size() / 2;
        startTime = System.nanoTime();
        arrayList.add(index, 20);
        endTime = System.nanoTime();
        long addToMiddleAL = (endTime - startTime);


        System.out.println("ArrayList insertions: ");
        System.out.println("at the beginning: " +  addToStartAL);
        System.out.println("at the middle: " +  addToMiddleAL);
        System.out.println("at the end: " +  addToEndAL);
    }

    private static void runPerformanceCheckLinkedList(Integer [] ints) {
        java.util.List<Integer> linkedList = new java.util.LinkedList<>(java.util.List.of(ints));

        long startTime = System.nanoTime();
        linkedList.add(11);
        long endTime = System.nanoTime();
        long addToEndLL = (endTime - startTime) ;


        startTime = System.nanoTime();
        linkedList.add(0, 0);
        endTime = System.nanoTime();
        long addToStartLL = (endTime - startTime);

        int index = linkedList.size() / 2;
        startTime = System.nanoTime();
        linkedList.add(index, 20);
        endTime = System.nanoTime();
        long addToMiddleLL = (endTime - startTime);

        System.out.println("LinkedList insertions: ");
        System.out.println("at the beginning: " +  addToStartLL);
        System.out.println("at the middle: " +  addToMiddleLL);
        System.out.println("at the end: " +  addToEndLL);
    }

    private static void runPerformanceCheckMyLinkedList(Integer [] ints) {
        List<Integer> myLinkedList = LinkedList.of(ints);
        System.out.println(myLinkedList);

        long startTime = System.nanoTime();
        myLinkedList.add(11);
        long endTime = System.nanoTime();
        long addToEndLL = (endTime - startTime) ;


        startTime = System.nanoTime();
        myLinkedList.addAtStart(0);
        endTime = System.nanoTime();
        long addToStartLL = (endTime - startTime);

        int index = myLinkedList.size() / 2;
        startTime = System.nanoTime();
        myLinkedList.addAt(index, 20);
        endTime = System.nanoTime();
        long addToMiddleLL = (endTime - startTime);

        System.out.println("My implementation of LinkedList insertions: ");
        System.out.println("at the beginning: " +  addToStartLL);
        System.out.println("at the middle: " +  addToMiddleLL);
        System.out.println("at the end: " +  addToEndLL);
    }
}
