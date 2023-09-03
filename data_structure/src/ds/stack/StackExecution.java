package ds.stack;

import ds.Executioner;

public class StackExecution extends Executioner {

    @Override
    public void execute(int i) {
        if (i==0) {
            ArrayStack.execute();
        } else if (i==1) {
            LinkedListStack.execute();
        } else if (i==2) {
            DynamicArrayStack.execute();
        } else if (i==3) {
            BoundedStack.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
