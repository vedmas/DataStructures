package DataStructures.Lesson3.DZ;

import DataStructures.Lesson3.Stack.Stack;
import DataStructures.Lesson3.Stack.StackImpl;

import java.util.Deque;
import java.util.Queue;

public class ReadBackwards {

    public static void main(String[] args) {
        String text = "МИЛАН";
        Stack<Character> textmass = new StackImpl<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            textmass.push(text.charAt(i));
        }
        while (!textmass.isEmpty()) {
            System.out.print(textmass.pop());
        }
    }
}
