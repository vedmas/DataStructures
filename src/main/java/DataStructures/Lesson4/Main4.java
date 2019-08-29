package DataStructures.Lesson4;

import DataStructures.Lesson3.Queue.Queue;
import DataStructures.Lesson3.Queue.QueueImpl;
import DataStructures.Lesson3.Stack.Stack;
import DataStructures.Lesson3.Stack.StackImpl;
import DataStructures.Lesson4.LinkedList.*;

public class Main4 {

    public static void main(String[] args) {
//        testSimpleLinkedList();
//        testStack();
//        testTwoSideLinkedList();
        queue();
    }

    private static void testSimpleLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);

        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Contains 2: " + linkedList.contains(2));

        System.out.println("Size is: " + linkedList.size() );
        linkedList.display();

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }
    }

    private static void testTwoSideLinkedList() {
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertFirst(3);
        linkedList.insertLast(4);
        linkedList.insertFirst(5);

        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Contains 2: " + linkedList.contains(2));

        System.out.println("Size is: " + linkedList.size() );
        linkedList.display();

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }
    }

    private static void testStack() {
        //Stack<Integer> stack = new StackImpl<>(5);
        Stack<Integer> stack = new LinkedStackImpl<>();
        addToStack(stack, 1);
        addToStack(stack, 2);
        addToStack(stack, 3);
        addToStack(stack, 4);
        addToStack(stack, 5);
        addToStack(stack, 6);

        System.out.println("Top of stack is: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    private static void addToStack(Stack<Integer> stack, int value) {
        if(!stack.isFull()) {
            stack.push(value);
        }
    }

    private static void queue() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.insert(1);
        queue.insert(3);
        queue.insert(5);
        queue.insert(2);
        queue.insert(4);
        queue.insert(6);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
