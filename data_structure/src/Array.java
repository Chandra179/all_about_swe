public class Array {

    public static void execute(int i) {
        if (i==0) {
            oneDimensionalArray();
        } else if (i==1) {
            multiDimensionalArray();
        } else {
            System.out.println("Allowed input : " + "[0]");
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
}
