package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 9, 8, 4, 5, 1};

        System.out.println("Original array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            System.out.println();
            System.out.println("Array : ");
            for (int i=left; i<right+1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("=====LEFT=====");
            System.out.println("Left : " + left);
            System.out.println("Right : " + mid);

            System.out.println("=====RIGHT=====");
            System.out.println("Left : " + (mid + 1));
            System.out.println("Right : " + right);

            // Recursively sort the first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays leftArray[] and rightArray[]
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into arr[left...right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
