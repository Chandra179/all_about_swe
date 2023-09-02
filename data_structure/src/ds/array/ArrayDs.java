package ds.array;

import ds.Executioner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayDs extends Executioner {

    public ArrayDs() {}

    @Override
    public void execute(int i) {
        if (i==0) {
            oneDimensionalArray();
        } else if (i==1) {
            multiDimensionalArray();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }

    public static void oneDimensionalArray() {
        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 20;
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void multiDimensionalArray() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 9;
        matrix[0][2] = 3;
        matrix[1][1] = 5;
        for (int i=0; i< matrix.length; i++) {
            System.out.print("Row " + i + " : ");
            for (int j : matrix[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /**
     * Resizeable array
     */
    public static void dynamicArray() {
        ArrayList<Integer> dynamicArray = new ArrayList<>();
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.remove(0);
    }

    public static void jaggedArray() {
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[] { 1, 2 };
        jaggedArray[1] = new int[] { 3, 4, 5 };
    }

    public static void sparseArray() {
        Map<Integer, Integer> sparseArray = new HashMap<>();
        sparseArray.put(2, 10); // Element at index 2 has value 10
        sparseArray.put(5, 7);  // Element at index 5 has value 7
    }

    public static void parallelArray() {
        String[] names = { "Alice", "Bob", "Carol" };
        int[] ages = { 25, 30, 28 };
        double[] salaries = { 50000.0, 60000.0, 55000.0 };
    }

    public static void associativeArray() {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Alice", 95);
        grades.put("Bob", 85);
        grades.put("Carol", 92);
    }
}
