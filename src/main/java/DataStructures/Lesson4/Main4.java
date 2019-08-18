package DataStructures.Lesson4;

import DataStructures.Lesson3.Stack.Stack;
import DataStructures.Lesson3.Stack.StackImpl;
import DataStructures.Lesson4.LinkedList.LinkedList;
import DataStructures.Lesson4.LinkedList.LinkedStackImpl;
import DataStructures.Lesson4.LinkedList.SimpleLinkedList;

public class Main4 {

    public static void main(String[] args) {
        //testSimpleLinkedList();
        testStack();
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
}
