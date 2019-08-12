package Lesson2;

public class Main {
    public static void main(String[] args) {
        long start, finish, timeConsumedMillis;
        Array<Integer> array = new ArrayOperation<>(5);
//        Array<Integer> array = new SortedArrayOperation<>();
        for (int i = 0; i < 1000000; i++) {
            array.add(array.createValue());
        }

        start = System.currentTimeMillis();
        array.sortBubble();
        finish = System.currentTimeMillis();
        System.out.println(("Time consumed to sort by sortBubble method: " + (finish - start) + " millis"));

        start = System.currentTimeMillis();
        array.sortSelect();
        finish = System.currentTimeMillis();
        System.out.println(("Time consumed to sort by sortSelect method: " + (finish - start) + " millis"));

        start = System.currentTimeMillis();
        array.sortInsert();
        finish = System.currentTimeMillis();
        System.out.println(("Time consumed to sort by sortInsert method: " + (finish - start) + " millis"));

        //array.sortBubble();
        //array.sortSelect();


//        array.display();
//
        System.out.println("Remove: " + array.remove(Integer.valueOf(2)));
        System.out.println("Remove: " + array.remove(Integer.valueOf(200)));

//        array.display();

        System.out.println("Find: " + array.indexOf(1));
        System.out.println("Find: " + array.indexOf(7));
        System.out.println("Find: " + array.indexOf(5));
        System.out.println("Find: " + array.indexOf(8));
        array.display();


    }

}
