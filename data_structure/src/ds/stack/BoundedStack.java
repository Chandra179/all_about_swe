package ds.stack;

import java.util.EmptyStackException;

/**
 * A bounded stack is a stack data structure with a maximum capacity.
 * Once the stack reaches its capacity, you cannot push more elements onto it
 * without removing some
 */
public class BoundedStack<T> {
    private int capacity;
    private Object[] elements;
    private int size;

    public BoundedStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer.");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Cannot push more elements.");
        }
        elements[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        T item = (T) elements[--size];
        elements[size] = null; // Set the popped element to null for garbage collection.
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        T item = (T) elements[size - 1];
        return item;
    }

    public static void execute() {
        BoundedStack<Integer> stack = new BoundedStack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.size()); // Output: 3

        System.out.println("Top element: " + stack.peek()); // Output: 3

        stack.pop();
        System.out.println("Popped an element.");

        System.out.println("Stack size after pop: " + stack.size()); // Output: 2

        stack.push(4);
        stack.push(5);

        System.out.println("Is the stack full? " + stack.isFull()); // Output: true

        // Attempting to push more elements into a full stack will throw an exception.
        // stack.push(6); // This line will throw an exception.
    }
}
