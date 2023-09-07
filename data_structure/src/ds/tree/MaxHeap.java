package ds.tree;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heap[size] = value;
        int currentIndex = size;
        size++;

        while (currentIndex > 0 && heap[currentIndex] > heap[getParentIndex(currentIndex)]) {
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public int extractMax() {
        if (size <= 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return max;
    }

    private void heapify(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largestIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex] > heap[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] > heap[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapify(largestIndex);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void execute() {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(7);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        int max = maxHeap.extractMax();
        System.out.println("Extracted Max Element: " + max);

        System.out.println("Max Heap after extracting max:");
        maxHeap.printHeap();
    }
}

