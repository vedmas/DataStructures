package DataStructures.Lesson5.DZ5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainDZ {
    static long result = 1;
    private static Thing[] things = new Thing[5];
    private static List<List<Thing>> kits = new ArrayList<>();
    private static final int CAPACITY_KNAPSACK = 15;

    public static void main(String[] args) {
        things[0] = new Thing("Thing1", 1, 1);
        things[1] = new Thing("Thing2", 3, 2);
        things[2] = new Thing("Thing3", 2, 2);
        things[3] = new Thing("Thing4", 4, 10);
        things[4] = new Thing("Thing5", 12, 4);

        knapsack(things.length);

        for (List<Thing> kit : kits) {
            for (Thing thing : kit) {
                System.out.print(thing.weight + " ");
            }
            System.out.println();
            //System.out.println("-------");
        }
        if(kits.get(0).equals(kits.get(4))) {
            System.out.println("yes");
        } else System.out.println("No");

        System.out.println("kits.size() = " + kits.size());

        System.out.println("findDuplicate(kits.get(0), kits.get(3)) = " + findDuplicate(kits.get(0), kits.get(3)));

//        System.out.println(exponentiation(5, 3));
    }

    // Первое ДЗ
    private static long exponentiation(long value, long exp) {
        if (exp == 1) {
            return value;
        }
//        result = result * value;
//        exponentiation(value, exp - 1);
        return value * exponentiation(value, exp - 1);
//        return result;
    }

    // Второе ДЗ
    private static void knapsack(int length) {
        if (things.length == 0 || length == 1) {
            return;
        } else if (sumWeight(things) <= MainDZ.CAPACITY_KNAPSACK) {

            System.out.println("All things will fit in your knapsack!");
            return;
        }
        for (int i = 0; i < length; i++) {
            knapsack(length - 1);
//            for (Thing thing : things) {
//                System.out.print(thing.weight + " ");
//            }
            if(findDuplicatesKit(packingThings(things)) == false) {
                kits.add(packingThings(things));
            }
//            System.out.println();
//            System.out.println("--------------");
            rotate(length);
        }
    }
    //формирует комплекты вещей по вместимости рюкзака
    private static List<Thing> packingThings(Thing[] things) {
        int limit = 0;
        List<Thing> kit = new LinkedList<>();
        for (Thing thing : things) {
            limit += thing.weight;
            if (limit < CAPACITY_KNAPSACK) {
                kit.add(thing);
            }
        }
        return kit;
    }
    // Меняет позицию элемента для получения всех вариаций
    private static Thing[] rotate(int length) {
        int pos = things.length - length;
        Thing temp = things[pos];
        for (int i = pos + 1; i < things.length; i++) {
            things[i - 1] = things[i];
        }
        things[things.length - 1] = temp;
        return things;
    }
    // расчитывает общий вес вещей в списке
    private static int sumWeight(Thing[] things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.weight;
        }
        return sum;
    }

    private static boolean findDuplicatesKit(List<Thing> newKit) {
        for (List<Thing> kitInKits : kits) {
            if(newKit.equals(kitInKits)) {
                return true;
            }
        }
        return false;
    }
    private static boolean findDuplicate(List<Thing> newKit, List<Thing> oldKit) {
        boolean indicator = false;
        if(newKit.size() != oldKit.size()) return false;
        for (Thing thingInNewKit : newKit) {
            for (Thing thingInOldKit : oldKit) {
                if(thingInNewKit.equals(thingInOldKit)) {
                    indicator = true;
                }
                if(!indicator) return false;
            }
        }
        return true;
    }
    }


