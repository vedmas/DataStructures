package DataStructures.Lesson8;



import DataStructures.Lesson8.DZ.ChainHashTableImpl;

public class Main8 {
    public static void main(String[] args) {
//        HashTable<Item, Integer> hashTable = new HashTableImpl<>(5);
//        HashTable<Item, Integer> hashTable = new DoubleHashTableImpl<>(5);
        HashTable<Integer, String> hashTable = new ChainHashTableImpl<>(5);
//
//        Item orange = new Item(1, "Orange", 150);
//        Item banana = new Item(71, "Banana", 100);
//        Item lemon = new Item(60, "Lemon", 250);
//        Item milk = new Item(52, "Milk", 120);
//        Item potato = new Item(21, "potato", 67);
//        hashTable.put(orange, orange.cost);
//        hashTable.put(banana, banana.cost);
//        hashTable.put(lemon, lemon.cost);
//        hashTable.put(milk, milk.cost);
//        hashTable.put(potato, potato.cost);

        hashTable.put(1, "apple");
        hashTable.put(51, "orange");
        hashTable.put(91, "tomato");
        hashTable.put(22, "potato");
        hashTable.put(32, "fish");
        hashTable.put(25, "bread");
        hashTable.put(55, "butter");
        hashTable.put(23, "cabbage");
        hashTable.put(70, "egg");
        hashTable.put(0, "onion");
        hashTable.put(100, "corn");
//
//        System.out.println("hashTable.size() = " + hashTable.size());
        hashTable.remove(32);
        hashTable.remove(22);
        hashTable.display();

//        LinkedList<Integer> [] data = new LinkedList[10];
//        data[0].add(1);
//        data[0].add(2);
//        data[0].add(3);
//        data[0].add(4);
//        data[0].add(5);
//
//        for (Integer i : data[0]) {
//            System.out.println(i);
//        }

    }
}
