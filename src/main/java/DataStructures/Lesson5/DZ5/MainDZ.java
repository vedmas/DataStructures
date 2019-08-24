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
        things[4] = new Thing("Thing5", 12, 6);

        mostExpensive(kits); // Второе ДЗ

//        System.out.println(exponentiation(5, 3));  // Первое ДЗ
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
            if(!findDuplicatesKit(packingThings(things))) { //Добавляем уникальные комплекты вещей в список
                kits.add(packingThings(things));            //с учетов максимального веса для рюкзака
            }
            rotate(length);
        }
    }
    //формирует комплекты вещей по вместимости рюкзака
    private static List<Thing> packingThings(Thing[] things) {
        int limit = 0;
        List<Thing> kit = new LinkedList<>();
        for (Thing thing : things) {
            limit += thing.weight;
            if (limit <= CAPACITY_KNAPSACK) {
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
    // расчитывает общий вес вещей в комплекте
    private static int sumWeight(Thing[] things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.weight;
        }
        return sum;
    }
    //расчитываем стоимость вещей в комплекте
    private static int sumPrice(List<Thing> kit) {
        int sum = 0;
        for (Thing thing : kit) {
            sum += thing.price;
        }
        return sum;
    }
    // полный поиск дублей комплектов при добавлении в список
    private static boolean findDuplicatesKit(List<Thing> newKit) {
        for (List<Thing> kitInKits : kits) {
            if (newKit.equals(kitInKits) || findDuplicateThings(newKit, kitInKits)) {
                return true;
            }
        }
        return false;
    }

    //Сравнение комплектов на идентичность находящихся в них вещей
    private static boolean findDuplicateThings(List<Thing> newKit, List<Thing> oldKit) {
        boolean indicator = false;
        if(newKit.size() != oldKit.size()) return false;
        for (Thing thingInNewKit : newKit) {
            boolean tempInd = false;
            for (Thing thingInOldKit : oldKit) {
                if(thingInNewKit.equals(thingInOldKit)) {
                    tempInd = true;
                }
            }
            if(!tempInd) return false;
        }
        return true;
    }
    // поиск самого дорого комплекта
    private static void mostExpensive(List<List<Thing>> kits) {
        knapsack(things.length);
        List<Thing> best = kits.get(0);
        int j = 0;
        for (int i = 0; i < kits.size(); i++) {
            if(j == kits.size()) break;
                for (j = i + 1; j < kits.size(); j++) {
                    if((sumPrice(kits.get(i)) < (sumPrice(kits.get(j))))) {
                        best = kits.get(j);
                        i = j;
                        break;
                    }
                }
        }
        for (Thing thing : best) {
            System.out.println("Name: " + thing.name + " Weight: " + thing.weight + " Price: " + thing.price);
        }
    }
    }


