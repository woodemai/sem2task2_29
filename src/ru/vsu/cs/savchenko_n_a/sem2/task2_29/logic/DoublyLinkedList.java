package ru.vsu.cs.savchenko_n_a.sem2.task2_29.logic;

public class DoublyLinkedList {

    /*
    DoublyLinkedList имеет поля:
    Node head - первый элемент
    Node tail - последний элемент
    int size - размер
     */
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
    private int size;

    /*
    Пустой стандартный конструктор и конструктор на основе массива целых чисел
     */
    public DoublyLinkedList() {
    }

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
        size = arr.length;
    }

    /*
    добавление и удаления элемента
     */
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
        size++;
    }

    public void remove(int data) {
        Node current = head;
        Node previous;
        Node next;
        for (int i = 1; i < size; i++) {
            assert current != null;
            previous = current.prev;
            next = current.next;
            if (current.data == data) {
                next.prev = previous;
                previous.next = next;
                current = null;
            }
        }
        this.tail = current;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        result.append("\n");
        return result.toString();
    }

    public void reverse() {
        Node current = head;
        Node temp;

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

    public int[] toArray() {
        int[] arr = new int[size];
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
