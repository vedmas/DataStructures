package Lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long start, finish, timeConsumedMillis;
        Array<Integer> arrayBubble = new ArrayOperation<>(5);
//        Array<Integer> array = new SortedArrayOperation<>();
        for (int i = 0; i < 10000; i++) {
            arrayBubble.add(arrayBubble.createValue());
        }

        Array<Integer> arraySelect = new ArrayOperation<>(5);
        for (int i = 0; i < 10000; i++) {
            arraySelect.add(arrayBubble.createValue());
        }

        Array<Integer> arrayInsert = new ArrayOperation<>(5);
        for (int i = 0; i < 10000; i++) {
            arrayInsert.add(arrayBubble.createValue());
        }



        start = System.currentTimeMillis();
        arrayBubble.sortBubble();
        finish = System.currentTimeMillis();
        System.out.println(("Time consumed to sort by sortBubble method: " + (finish - start) + " millis"));

        start = System.currentTimeMillis();
        arraySelect.sortSelect();
        finish = System.currentTimeMillis();
        System.out.println(("Time consumed to sort by sortSelect method: " + (finish - start) + " millis"));

        start = System.currentTimeMillis();
        arrayInsert.sortInsert();
        finish = System.currentTimeMillis();
        System.out.println(("Time consumed to sort by sortInsert method: " + (finish - start) + " millis"));

//        array.display();
//
        System.out.println("Remove: " + arrayBubble.remove(Integer.valueOf(2)));
        System.out.println("Remove: " + arrayBubble.remove(Integer.valueOf(200)));

//        array.display();

        System.out.println("Find: " + arrayBubble.indexOf(1));
        System.out.println("Find: " + arrayBubble.indexOf(7));
        System.out.println("Find: " + arrayBubble.indexOf(5));
        System.out.println("Find: " + arrayBubble.indexOf(8));
        arraySelect.display();


    }

}
