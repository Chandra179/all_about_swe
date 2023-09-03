package ds.linkedlist;

import ds.Executioner;

public class LinkedListExecution extends Executioner {

    public LinkedListExecution(){}

    @Override
    public void execute(int i) {
        if (i==0) {
            SingleLinkedList sll = new SingleLinkedList();
        } else if (i==1) {
            DoublyLinkedList.execute();
        } else if (i==2) {
            CircularLinkedList.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
