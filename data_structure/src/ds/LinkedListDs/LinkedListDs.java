package ds.LinkedListDs;

import ds.Executioner;

public class LinkedListDs extends Executioner {

    public LinkedListDs(){}

    @Override
    public void execute(int i) {
        if (i==0) {
            SingleLinkedListDs sll = new SingleLinkedListDs();
        } else if (i==1) {
            DoublyLinkedListDs.execute();
        } else if (i==2) {
            CircularLinkedListDs.execute();
        } else {
            System.out.println("Allowed input : " + "[0, 1]");
        }
    }
}
