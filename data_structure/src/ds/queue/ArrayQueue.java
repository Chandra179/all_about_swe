package ds.queue;

public class ArrayQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public ArrayQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public int size() {
        return currentSize;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            if (rear == maxSize - 1) {
                rear = -1; // Wrap around
            }
            queueArray[++rear] = item;
            currentSize++;
        } else {
            System.out.println("Queue is full. Cannot enqueue.");
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int removedItem = queueArray[front++];
            if (front == maxSize) {
                front = 0; // Wrap around
            }
            currentSize--;
            return removedItem;
        } else {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
    }

    public static void execute() {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("Enqueue 5");
        queue.enqueue(5);

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 1

        System.out.println("Enqueue 7");
        queue.enqueue(7);

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 2

        System.out.println("Enqueue 1");
        queue.enqueue(1);

        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}