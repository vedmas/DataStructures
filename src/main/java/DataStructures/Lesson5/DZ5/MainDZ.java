package DataStructures.Lesson5.DZ5;

import java.util.ArrayList;
import java.util.List;

public class MainDZ {
    static long result = 1;
    private static Thing[] things = new Thing[5];
    private static List<Thing[]> kits = new ArrayList<>();
    private static final int CAPACITY_KNAPSACK = 18;

    public static void main(String[] args) {
        things[0] = new Thing("Thing1", 1, 1);
        things[1] = new Thing("Thing2", 1, 2);
        things[2] = new Thing("Thing3", 2, 2);
        things[3] = new Thing("Thing4", 4, 10);
        things[4] = new Thing("Thing5", 12, 4);

        knapsack(things.length);

//        System.out.println(exponentiation(5, 3));
    }

    // Первое ДЗ
    private static long exponentiation(long value, long exp) {
        if(exp == 1) {
            return value;
        }
//        result = result * value;
//        exponentiation(value, exp - 1);
        return value * exponentiation(value, exp - 1);
//        return result;
    }

    // Второе ДЗ
    private static void knapsack(int length) {
        if(things.length == 0 || length == 1) {
            return;
        }
         else if(sumWeight(things) <= MainDZ.CAPACITY_KNAPSACK) {

            System.out.println("All things will fit in your knapsack!");
            return;
        }
        for (int i = 0; i < length; i++) {
            knapsack(length - 1);
            for (Thing thing : things) {
                System.out.print(thing.weight + " ");
            }
            System.out.println();
            System.out.println("--------------");
            rotate(length);
        }
    }

    private static Thing[] rotate(int length) {
        int pos = things.length - length;
        Thing temp = things[pos];
        for (int i = pos + 1; i < things.length; i++) {
            things[i - 1] = things[i];
        }
        things[things.length - 1] = temp;
        return things;
    }

    private static int sumWeight(Thing[] things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.weight;
        }
        return sum;
    }
}
