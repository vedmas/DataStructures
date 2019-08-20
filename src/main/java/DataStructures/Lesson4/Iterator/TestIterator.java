package DataStructures.Lesson4.Iterator;

import DataStructures.Lesson4.LinkedList.LinkedList;
import DataStructures.Lesson4.LinkedList.SimpleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
//        for (int i = 0; i < array.length; i++) {
//            doAction(array[i]);
//        }

//        int index = 0;
//        while (index < array.length) {
//            doAction(array[index]);
//            index++;
//        }

//        Iterator<Integer> iterator = null;
//        while (iterator.hasNext()) {
//            doAction(iterator.next());
//        }

        System.out.println("---------------------------");

        LinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);

        while (!linkedList.isEmpty()) {
            doAction(linkedList.removeFirst());
        }
        for (Integer value : linkedList) {
            doAction(value);
        }

//        List<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//
//        for (Integer value : arrayList) {
//            doAction(value);
//        }
//
//        List<Integer> jdkLinkedList = new java.util.LinkedList<>();
//        jdkLinkedList.add(1);
//        jdkLinkedList.add(2);
//        jdkLinkedList.add(3);
//
//        for (Integer value : jdkLinkedList) {
//            doAction(value);
//        }
    }

    private static void doAction(int value) {
        System.out.println(value);
    }



}
