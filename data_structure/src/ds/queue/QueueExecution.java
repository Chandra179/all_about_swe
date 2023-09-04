package ds.queue;

import ds.Executioner;

public class QueueExecution extends Executioner {

    public QueueExecution(){}

    @Override
    public void execute(int i) {
        if (i==0) {
            ArrayQueue.execute();
        } else if (i==1) {
            CircularQueue.execute();
        } else if (i==2) {
            PriorityQueue.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
