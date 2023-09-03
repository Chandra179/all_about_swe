package ds.stack;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private Object[] array;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(T item) {
        if (top == array.length - 1) {
            // Stack is full, resize the array
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) array[top];
        array[top--] = null; // Avoid memory leak
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void execute() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 3
        System.out.println("Stack size: " + stack.size());   // Output: Stack size: 3

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}