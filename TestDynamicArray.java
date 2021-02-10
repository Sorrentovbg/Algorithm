package lesson2;

import java.util.concurrent.*;

public class TestDynamicArray {
    private static int size = 10000;


    public static void main(String[] args) throws InterruptedException {
        Array<Integer> sortByBubble = new ArrayImpl<>(size);
        Array<Integer> sortBySelect = new ArrayImpl<>(size);
        Array<Integer> sortByInsert = new ArrayImpl<>(size);

        Array<Integer> bubbleSortedArray = new SortedArrayImpl<>(size);
        Array<Integer> selectSortedArray = new SortedArrayImpl<>(size);
        Array<Integer> insertSortedArray = new SortedArrayImpl<>(size);

        ExecutorService service = Executors.newFixedThreadPool(6);


        for(int i = 0; i < size; i++){
            int a = (int) (Math.random()*size);
            sortByBubble.add(a);
            sortBySelect.add(a);
            sortByInsert.add(a);
        }

        for(int i = 0; i < size; i++){
            int a = (int) (Math.random()*size);
            bubbleSortedArray.add(a);
            selectSortedArray.add(a);
            insertSortedArray.add(a);
        }

        System.out.println(sortByBubble.size());

//      ArrayImpl<>(size);

        new Thread(() -> {
                long timeStartBubble = System.currentTimeMillis();
                sortByBubble.sortBubble();
                long endTimeBubble = System.currentTimeMillis();
                long timeResultBubble = endTimeBubble - timeStartBubble;
                System.out.println("Sort by Bubble ArrayImpl = " + timeResultBubble);
        }).start();

        new Thread(() -> {
                long timeStartSelect = System.currentTimeMillis();
                sortBySelect.sortSelect();
                long endTimeSelect = System.currentTimeMillis();
                long timeResultSelect = endTimeSelect - timeStartSelect;
                System.out.println("Sort by Select ArrayImpl = " +  timeResultSelect);
        }).start();

        new Thread(() -> {
                long timeStartInsert = System.currentTimeMillis();
                sortByInsert.sortInsert();
                long endTimeInsert = System.currentTimeMillis();
                long timeResultInsert = endTimeInsert - timeStartInsert;
                System.out.println("Sort by Insert ArrayImpl " +  timeResultInsert);
        }).start();

        Thread.sleep(600);

        new Thread(() -> {
            long timeStartBubble = System.currentTimeMillis();
            bubbleSortedArray.sortBubble();
            long endTimeBubble = System.currentTimeMillis();
            long timeResultBubble = endTimeBubble - timeStartBubble;
            System.out.println("Sort by Bubble SortedArrayImpl = " + timeResultBubble);
        }).start();

        new Thread(() -> {
            long timeStartSelect = System.currentTimeMillis();
            selectSortedArray.sortSelect();
            long endTimeSelect = System.currentTimeMillis();
            long timeResultSelect = endTimeSelect - timeStartSelect;
            System.out.println("Sort by Select SortedArrayImpl = " +  timeResultSelect);
        }).start();

        new Thread(() -> {
            long timeStartInsert = System.currentTimeMillis();
            insertSortedArray.sortInsert();
            long endTimeInsert = System.currentTimeMillis();
            long timeResultInsert = endTimeInsert - timeStartInsert;
            System.out.println("Sort by Insert SortedArrayImpl = " +  timeResultInsert);
        }).start();
    }
}
