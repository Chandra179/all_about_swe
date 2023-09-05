package ds.graph;

import ds.Executioner;
import ds.queue.ArrayQueue;
import ds.queue.CircularQueue;
import ds.queue.PriorityQueue;

public class GraphExecution extends Executioner {

    public GraphExecution(){}

    @Override
    public void execute(int i) {
        if (i==0) {
            UndirectedGraph.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
