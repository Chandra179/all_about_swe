package ds.stack;

import java.util.EmptyStackException;

public class DynamicArrayStack<T> {
    private Object[] array;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(T item) {
        if (top == array.length - 1) {
            // Stack is full, resize the array dynamically
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
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
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();

        for (int i = 1; i <= 20; i++) {
            stack.push(i);
        }

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 20
        System.out.println("Stack size: " + stack.size());   // Output: Stack size: 20

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}
