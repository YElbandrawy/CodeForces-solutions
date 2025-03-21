// Java Program for Implementing
// Circular Linked List

// Class Node

import java.util.Objects;

class Node<T> {
    T data;
    Node<T> next;

    // Constructor to initialize a node with data
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Class CircularLinkedList
class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    // Constructor CircularLinkedList
    public CircularLinkedList() {
        // At the beginning we do not have tail or head
        head = null;
        tail = null;
    }

    // Method to insert a new node with the given
    // data into the circular linked list
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        // If the list is empty, make the new node
        // the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;

            // Point to itself in a circular list
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to delete the node with the given
    // key from the circular linked list
    public void delete(T key) {
        if (head == null) {
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;
        while (curr.next != head) {
            if (curr.data == key) {
                // If the node to be deleted is the head node
                if (prev == null) {
                    Node<T> last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = curr.next;
                    last.next = head;
                    return;
                } else {
                    prev.next = curr.next;

                    // Update tail if the last node is deleted
                    if (curr == tail) {
                        tail = prev;
                    }
                    return;
                }
            }
            prev = curr;
            curr = curr.next;
        }

        // Check if the node to be deleted is the last node
        if (curr == head && curr.data == key) {
            prev.next = head;

            // Update tail if the last node is deleted
            tail = prev;
        }
    }

    // Method to traverse the list and find the 'index' of an element
    // I will call it the 'order' because linked lists dose not have index
    public int index(T element) {
        if (head == null)
            return -1;

        int order = 0;
        Node<T> curr = head;
        do {
            if (Objects.equals(curr.data, element)) {
                return order;
            }
            order++;
            curr = curr.next;
        } while (curr != head);
        return -1;
    }

    // Method to find an Element basedon the order / 'index'
    public T getElement(int order) {
        Node<T> curr = head;
        for (int i = 0; i < order; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    // Method to find an Element starting from a certain order/'index'
    public int indexNext(T element, int order) {
        if (head == null)
            return -1;

        Node<T> curr = head;
        for (int i = 0; i < order; i++) {
            curr = curr.next;
        }
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(element, curr.data)) {
                return order;
            }
            curr = curr.next;
            order++;
        }
        return -1;
    }

    // Method to clear the list
    public void clear() {
        head = null;
        tail = null;
    }

    // Method to display the elements
    // of the circular linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Linked List Elements : ");

        Node<T> itr = head;
        do {
            System.out.print(itr.data);
            if (itr != tail) {
                System.out.print(" -> ");
            }
            itr = itr.next;
        } while (itr != head);
        System.out.println();
    }
}
