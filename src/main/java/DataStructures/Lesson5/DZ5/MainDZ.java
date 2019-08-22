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
        knapsack(things);

//        System.out.println(exponentiation(5, 3));
    }


    private static long exponentiation(long value, long exp) {
        if(exp == 1) {
            return value;
        }
//        result = result * value;
//        exponentiation(value, exp - 1);
        return value * exponentiation(value, exp - 1);
//        return result;
    }
    private static void knapsack(Thing[] things) {
        if(things.length == 0) {
            return;
        }
         else if(sumWeight(things) <= MainDZ.CAPACITY_KNAPSACK) {

            System.out.println("All things will fit in your knapsack!");
            return;
        }

        for (Thing thing : things) {
            System.out.println(thing.weight);
        }
    }

    private static int sumWeight(Thing[] things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.weight;
        }
        return sum;
    }
}
