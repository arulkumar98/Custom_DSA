package queue;

import java.util.Deque;

public class MyQueueLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> front;
    private Node<T> back;
    private int size;


    public void enqueue(T value){
        Node<T> newNode = new Node<>(value);

        if (back == null){
            front = back = newNode;
        }else {
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    public T dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T value = front.value;
        front = front.next;
        if (front == null){
            back = null;
        }
        size--;
        return value;

    }

    private boolean isEmpty() {
        return size == 0;
    }





















}
