package ds.linkedlist;

public class SingleLinkedListDs {
    public SingleLinkedListDs() {
        SinglyLinkedList list = new SinglyLinkedList();

        // Adding elements to the list
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        list.addToEnd(40);
        list.addToEnd(60);

        // Displaying the list
        System.out.println("Singly Linked List:");
        list.display();

        // Finding an element
        int target = 20;
        Node foundNode = list.find(target);
        if (foundNode != null) {
            System.out.println(target + " found in the list: " + target);
        } else {
            System.out.println(target + " not found in the list.");
        }
    }

    class Node {
        int data;
        SingleLinkedListDs.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class SinglyLinkedList {
        private SingleLinkedListDs.Node head;

        public SinglyLinkedList() {
            this.head = null;
        }

        // Add an element to the end of the list
        public void addToEnd(int data) {
            SingleLinkedListDs.Node newNode = new SingleLinkedListDs.Node(data);
            if (head == null) {
                head = newNode;
            } else {
                SingleLinkedListDs.Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Display the elements of the list
        public void display() {
            SingleLinkedListDs.Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // Find an element in the list
        public SingleLinkedListDs.Node find(int target) {
            SingleLinkedListDs.Node current = head;
            while (current != null) {
                if (current.data == target) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }
    }

}
