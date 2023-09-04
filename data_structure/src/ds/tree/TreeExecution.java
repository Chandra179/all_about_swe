package ds.tree;

import ds.Executioner;
import ds.stack.ArrayStack;
import ds.stack.BoundedStack;
import ds.stack.DynamicArrayStack;
import ds.stack.LinkedListStack;

public class TreeExecution extends Executioner {

    @Override
    public void execute(int i) {
        if (i==0) {
            BinarySearchTree.execute();
        } else if (i==1) {
            AvlTree.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
