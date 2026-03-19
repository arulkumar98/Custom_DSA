package queue;

public class MyDeque<T> {

    private Object[] arr;
    private int front;
    private int size;
    private int capacity;

    public MyDeque() {
        capacity = 10;
        arr = new Object[capacity];
        front = 0;
        size = 0;
    }

    // add at front
    public void addFirst(T value) {

        if (size == capacity) {
            resize();
        }

        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        size++;
    }

    // add at rear
    public void addLast(T value) {

        if (size == capacity) {
            resize();
        }

        int rear = (front + size) % capacity;
        arr[rear] = value;
        size++;
    }

    // remove from front
    public T removeFirst() {

        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }

        T value = (T) arr[front];
        arr[front] = null;

        front = (front + 1) % capacity;
        size--;

        return value;
    }

    // remove from rear
    public T removeLast() {

        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }

        int rear = (front + size - 1) % capacity;

        T value = (T) arr[rear];
        arr[rear] = null;

        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {

        int newCapacity = capacity * 2;
        Object[] newArr = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % capacity];
        }

        arr = newArr;
        front = 0;
        capacity = newCapacity;
    }
}