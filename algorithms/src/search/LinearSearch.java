package search;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found the target element, return its index
            }
        }
        return -1; // Target element not found in the array
    }

    public static void main(String[] args) {
        int[] arr = { 10, 25, 30, 45, 50, 60, 70 };
        int target = 45;

        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
