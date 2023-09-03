package ds.linkedlist;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public static void execute() {
        CircularLinkedList myList = new CircularLinkedList();

        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);

        System.out.println("Circular Linked List:");
        myList.display();
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add a node to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Point back to itself for circularity
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Make the tail point back to the head
        }
    }

    // Display the elements in the list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == head) {
                System.out.println();
                System.out.println("Tail node next is head cause its circular: " + current.data);
            }
        } while (current != head);
        System.out.println();
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}

