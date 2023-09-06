package ds.tree;

import ds.Executioner;
import ds.graph.CyclicGraph;

public class TreeExecution extends Executioner {

    @Override
    public void execute(int i) {
        if (i==0) {
            BinarySearchTree.execute();
        } else if (i==1) {
            AvlTree.execute();
        } else if (i==2) {
            Trie.execute();
        } else if (i==3) {
            SuffixTree.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
