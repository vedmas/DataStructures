package DataStructures.Lesson3;

import DataStructures.Lesson3.Queue.PriorityQueue;
import DataStructures.Lesson3.Queue.Queue;
import DataStructures.Lesson3.Queue.QueueImpl;
import DataStructures.Lesson3.Stack.Stack;
import DataStructures.Lesson3.Stack.StackImpl;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
//        stack();
        Queue<Integer> queue = new PriorityQueue<>(5);
        queue.insert(1);
        queue.insert(3);
        queue.insert(5);
        queue.insert(2);
        queue.insert(4);
        queue.insert(6);

        System.out.println("Top of queue is: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void stack() {
        Stack<Integer> stack = new StackImpl<>(5);
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
