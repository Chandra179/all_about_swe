package search;

public class InterpolationSearch {

    public static int interpolationSearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            // Calculate the position using interpolation formula
            int pos = low + ((target - array[low]) * (high - low)) / (array[high] - array[low]);

            if (array[pos] == target) {
                return pos; // Element found
            }

            if (array[pos] < target) {
                low = pos + 1; // Adjust the search range to the right
            } else {
                high = pos - 1; // Adjust the search range to the left
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int result = interpolationSearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}

