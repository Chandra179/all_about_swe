package ds.linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static void execute() {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addToFront(3);
        list.addToFront(2);
        list.addToFront(1);

        list.addToEnd(4);
        list.addToEnd(99);
        list.addToEnd(5);

        System.out.println("Doubly Linked List:");
        list.display(); // Output: 1 2 3 4 5

        list.remove(3);

        System.out.println("After removing 3:");
        list.display(); // Output: 1 2 4 5
    }


    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Add a node to the beginning of the list
    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a node to the end of the list
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove a node with a specific value from the list
    public void remove(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    // If the node to be removed is the head
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    // If the node to be removed is the tail
                    tail = current.prev;
                }

                return; // Node found and removed
            }
            current = current.next;
        }
    }

    // Display the elements of the list from head to tail
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}
