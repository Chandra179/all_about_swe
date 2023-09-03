package ds.array;

import ds.Executioner;

public class ArrayExecution extends Executioner {

    @Override
    public void execute(int i) {
        if (i==0) {
            Array.oneDimensionalArray();
        } else if (i==1) {
            Array.multiDimensionalArray();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
