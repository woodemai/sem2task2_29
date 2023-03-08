import java.util.*;

public class DoublyLinkedList {
    public DoublyLinkedList(int[] arr) {
        if (arr.length > 0) {
            this.head = new Node(arr[0]);
            Node current = head;
            for (int i = 1; i < arr.length; i++) {
                Node newNode = new Node(arr[i]);
                current.next = newNode;
                newNode.prev = current;
                current = newNode;
            }
            this.tail = current;
        }
    }


    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        temp = head;
        head = tail;
        tail = temp;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
    }
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size()];
        Node current = head;
        int i = 0;
        while (current != null) {
            arr[i] = current.data;
            i++;
            current = current.next;
        }
        return arr;
    }

}
