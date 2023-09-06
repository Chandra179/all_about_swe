package ds.tree;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        // Insert the new value at the end of the heap.
        int index = size;
        heap[index] = value;
        size++;

        // Maintain the min-heap property by swapping with the parent if necessary.
        while (index > 0 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty.");
            return -1; // Return a sentinel value or throw an exception in a real application
        }

        int min = heap[0];

        // Replace the root with the last element and reduce the size.
        heap[0] = heap[size - 1];
        size--;

        // Maintain the min-heap property by "bubbling down" the root element.
        int index = 0;
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }

        return min;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void execute() {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(4);
        minHeap.insert(7);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(9);

        System.out.print("Min-Heap: ");
        minHeap.printHeap();

        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.print("Updated Min-Heap: ");
        minHeap.printHeap();
    }
}

