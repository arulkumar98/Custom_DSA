package linkedlist;

public class DoublyLinkedList<T> {

    class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    // Insert at start
    public void insertAtStart(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end ⭐
    public void insertAtEnd(T data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Pop from start
    public T popFromStart() {
        if (head == null) return null;

        Node temp = head;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return temp.data;
    }

    // Pop from end ⭐
    public T popFromEnd() {
        if (tail == null) return null;

        Node temp = tail;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return temp.data;
    }

    // Delete by VALUE (removes first occurrence)
    public void deleteByValue(T key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(key)) {

                // head
                if (temp == head) {
                    popFromStart();
                    return;
                }

                // tail
                if (temp == tail) {
                    popFromEnd();
                    return;
                }

                // middle
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    // Delete by NODE (O(1)) ⭐ interview favorite
    public void deleteNode(Node node) {
        if (node == null) return;

        if (node == head) {
            popFromStart();
            return;
        }

        if (node == tail) {
            popFromEnd();
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}