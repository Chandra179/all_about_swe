package ds.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void enqueue(int item) {
        if (size == capacity) {
            // Queue is full, you can handle this case as needed
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }

        // Add the new item to the end of the array
        array[size] = item;
        size++;

        // Reorder the queue to maintain priority
        heapifyUp();
    }

    public int dequeue() {
        if (isEmpty()) {
            // Queue is empty, you can handle this case as needed
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a sentinel value indicating failure
        }

        int highestPriority = array[0]; // Highest priority item is at the root
        size--;

        // Move the last item to the root and reorder the queue
        array[0] = array[size];
        heapifyDown();

        return highestPriority;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && array[childIndex] > array[parentIndex]) {
            // Swap the child and parent elements
            int temp = array[childIndex];
            array[childIndex] = array[parentIndex];
            array[parentIndex] = temp;

            // Move up the tree
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    private void heapifyDown() {
        int parentIndex = 0;

        while (true) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            int largestChildIndex = parentIndex;

            if (leftChildIndex < size && array[leftChildIndex] > array[largestChildIndex]) {
                largestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < size && array[rightChildIndex] > array[largestChildIndex]) {
                largestChildIndex = rightChildIndex;
            }

            if (largestChildIndex == parentIndex) {
                // The parent has higher priority than both children
                break;
            }

            // Swap the parent and the largest child
            int temp = array[parentIndex];
            array[parentIndex] = array[largestChildIndex];
            array[largestChildIndex] = temp;

            // Move down the tree
            parentIndex = largestChildIndex;
        }
    }

    public static void execute() {
        PriorityQueue pq = new PriorityQueue(10);
        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(8);

        System.out.println("Dequeue: " + pq.dequeue()); // Should print 8
        System.out.println("Dequeue: " + pq.dequeue()); // Should print 5
    }
}
