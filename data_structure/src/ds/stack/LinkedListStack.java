package ds.stack;

import java.util.EmptyStackException;

public class LinkedListStack<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void execute() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        stack.push(34);
        stack.push(8);
        stack.push(3);

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 3
        System.out.println("Stack size: " + stack.size());   // Output: Stack size: 3

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}
